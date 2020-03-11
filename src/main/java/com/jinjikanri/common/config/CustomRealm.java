package com.jinjikanri.common.config;

import java.util.List;
import java.util.Map;

import org.apache.catalina.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.entity.SYST06RightEntity;
import com.jinjikanri.service.LoginService;
import com.jinjikanri.service.UserService;

/**
 * 
 * @author zhangxuping
 *
 */
public class CustomRealm extends AuthorizingRealm {
	@Autowired
	private LoginService loginService;

	@Autowired
	private UserService UserService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// 获取登录用户名
		SYST01UserEntity user = (SYST01UserEntity) principalCollection.getPrimaryPrincipal();

		// 根据用户CD去数据库查询用户角色权限信息
		Map<String, Object> charAndRightMap = loginService.selectCharAndRightListByUsrCd(user.getUsrCd());
		List<SYST06CharEntity> charList = (List<SYST06CharEntity>) charAndRightMap.get("char");
		Map<String, Object> RightListsMap = (Map<String, Object>) charAndRightMap.get("rights");
		// 添加角色和权限
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		for (SYST06CharEntity oneChar : charList) {
			// 添加角色
			simpleAuthorizationInfo.addRole(oneChar.getCharMei());
			// 添加权限
			for (SYST06RightEntity oneRight : (List<SYST06RightEntity>) RightListsMap
					.get("char" + oneChar.getCharCd() + "rights")) {
				if (StringUtils.isNotBlank(oneRight.getRightKey()) && StringUtils.isNotEmpty(oneRight.getRightKey())) {
					simpleAuthorizationInfo.addStringPermission(oneRight.getRightKey());
				}
			}
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (authenticationToken.getPrincipal() == null) {
			return null;
		}
		// 获取用户信息
		String tokenUsrId = authenticationToken.getPrincipal().toString();
		SYST01UserEntity user = UserService.selectUserByUsrId(tokenUsrId);

		if (user == null) {
			// 这里返回后会报出对应异常
			return null;
		} else {
			// 这里验证authenticationToken和simpleAuthenticationInfo的信息
			// 先验证用户名再验证密码
			SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPasswd(),
					ByteSource.Util.bytes(user.getUsrId()), getName());
			return simpleAuthenticationInfo;
		}
	}

	/**
	 * 重写方法,清除当前用户的的 授权缓存
	 * 
	 * @param principals
	 */
	@Override
	public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
		super.clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 重写方法，清除当前用户的 认证缓存
	 * 
	 * @param principals
	 */
	@Override
	public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
		super.clearCachedAuthenticationInfo(principals);
	}

	@Override
	public void clearCache(PrincipalCollection principals) {
		super.clearCache(principals);
	}

	/**
	 * 自定义方法：清除所有 授权缓存
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * 自定义方法：清除所有 认证缓存
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	/**
	 * 自定义方法：清除所有的 认证缓存 和 授权缓存
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}
}
