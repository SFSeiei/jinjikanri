package com.jinjikanri.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinjikanri.common.config.CustomRealm;
import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.service.UserService;

/**
 * 
 * 
 * @author zhangxuping
 *
 */
@Controller
@RequestMapping(value = "/sys/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private CharMapper charMapper;

	/**
	 * 列表方法，带分页
	 * 
	 * @param user
	 * @param pageIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectUsers")
//	@RequiresPermissions("sys:user:select")
	public String selectUsers(SYST01UserEntity user, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.userService.selectUsers(user, pageIndex);
		List<SYST01UserEntity> userList = (List<SYST01UserEntity>) result.get("userList");
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("userList", userList);
		model.addAttribute("user", user);
		return "user/list";
	}

	@RequestMapping(value = "/oper")
//	@RequiresPermissions("sys:user:add")
	public String oper(Integer usrCd, Model model) {
		SYST01UserEntity user = new SYST01UserEntity();
		List<SYST06CharEntity> userCharList = new ArrayList<SYST06CharEntity>();
		if (usrCd != null) {
			user = this.userService.selectUserByUsrCd(usrCd);
			userCharList = this.charMapper.selectCharListByUsrCd(usrCd);
		}
		model.addAttribute("user", user);
		List<Integer> charCdList = new ArrayList<Integer>();
		for (SYST06CharEntity oneUserChar : userCharList) {
			charCdList.add(oneUserChar.getCharCd());
		}
		model.addAttribute("charCdList", charCdList);
		return "user/oper";
	}

	@RequestMapping(value = "/detail")
//	@RequiresPermissions("sys:user:select")
	public String detail(Integer usrCd, Model model) {
		SYST01UserEntity userEntity = this.userService.selectUserByUsrCd(usrCd);
		List<SYST06CharEntity> charList = this.charMapper.selectCharListByUsrCd(usrCd);
		model.addAttribute("user", userEntity);
		model.addAttribute("charList", charList);
		return "user/detail";
	}

	@RequestMapping("/modifyPasswdpage")
	public String modifyPasswdpage(Model model) {
		SYST01UserEntity currentUser = (SYST01UserEntity) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", currentUser);
		return "user/modifyPasswd";
	}

	/**
	 * 变更用户密码
	 */
	@RequestMapping("/password")
	public String password(String password, String newPassword, Model model) {
//		Assert.isBlank(newPassword, "パスワード不为能空");
		SYST01UserEntity currentUser = (SYST01UserEntity) SecurityUtils.getSubject().getPrincipal();
		// 更新密码
		boolean flag = this.userService.updateUserPassword(currentUser.getUsrCd(), password, newPassword);
		if (!flag) {
			model.addAttribute("msg", "パスワード变更失败！");
		} else {
			model.addAttribute("msg", "パスワード变更成功！");
		}
		// 添加成功之后 清除缓存
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		CustomRealm shiroRealm = (CustomRealm) securityManager.getRealms().iterator().next();
		// 清除用户认证相关的缓存
		shiroRealm.clearAllCachedAuthenticationInfo();
		model.addAttribute("user", currentUser);
		return "user/modifyPasswd";
	}

//	
	/**
	 * 保存用户
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@RequiresPermissions("sys:user:save")
	public String save(String charCdList, SYST01UserEntity user, Model model) throws Exception{
		List<Integer> charCdLists = new ArrayList<>();
		if (!charCdList.isEmpty() && charCdList != "" && charCdList != null) {
			for (String charCd : charCdList.split(",")) {
				charCdLists.add(Integer.valueOf(charCd));
			}
		}
		user.setPasswd(user.getUsrId());
		this.userService.saveUser(user, charCdLists);
		model.addAttribute("user", user);
		return "user/oper";
	}

	/**
	 * 变更用户
	 */
	@RequestMapping("/update")
//	@RequiresPermissions("sys:user:update")
	public String update(String charCdList, SYST01UserEntity user, Model model) {
		List<Integer> charCdLists = new ArrayList<>();
		if (!charCdList.isEmpty() && charCdList != "" && charCdList != null) {
			for (String charCd : charCdList.split(",")) {
				charCdLists.add(Integer.valueOf(charCd));
			}
		}
		if (user.getPasswd() != null) {
			user.setPasswd(user.getUsrId());
		}
		this.userService.updateUser(user, charCdLists);
		model.addAttribute("user", user);
		return "user/oper";
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
//	@RequiresPermissions("sys:user:delete")
	public String delete(Integer[] usrCds, Model model) {
		for (Integer usrCd : usrCds) {
			System.out.print(usrCd);
		}
		this.userService.deleteUserBatch(usrCds);
		SYST01UserEntity nullUser = new SYST01UserEntity();
		return this.selectUsers(nullUser, 1, model);
	}
}
