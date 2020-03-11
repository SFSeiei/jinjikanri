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
import org.springframework.web.bind.annotation.ResponseBody;

import com.jinjikanri.common.config.CustomRealm;
import com.jinjikanri.common.util.UserCheck;
import com.jinjikanri.entity.SYST01UserEntity;
import com.jinjikanri.entity.SYST06CharEntity;
import com.jinjikanri.mapper.CharMapper;
import com.jinjikanri.mapper.UserMapper;
import com.jinjikanri.service.UserService;

import ch.qos.logback.core.joran.conditional.IfAction;

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

	@Autowired
	private UserMapper userMapper;

	/**
	 * 列表方法，带分页
	 * 
	 * @param user
	 * @param pageIndex
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/selectUsers")
	public String selectUsers(SYST01UserEntity user, Integer pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = 1;
		}
		Map<String, Object> result = this.userService.selectUsers(user, pageIndex);
		List<SYST01UserEntity> userList = (List<SYST01UserEntity>) result.get("userList");
		for (int i = 0; i < userList.size(); i++) {
			SYST01UserEntity oneUser = userList.get(i);
			if (oneUser.getUsrId().toString().equals("sysAdmin")) {
				userList.remove(i);
				i--;
			}
		}
		model.addAttribute("total", result.get("total"));
		model.addAttribute("pages", result.get("pages"));
		model.addAttribute("userList", userList);
		model.addAttribute("user", user);
		return "user/list";
	}

	@RequestMapping(value = "/oper")
	public String oper(Integer usrCd, Model model) {
		SYST01UserEntity user = new SYST01UserEntity();
		List<SYST06CharEntity> userCharList = new ArrayList<SYST06CharEntity>();
		if (usrCd != null) {
			user = this.userService.selectUserByUsrCd(usrCd);
			if (user.getUsrId().toString().equals("sysAdmin")) {
				user = new SYST01UserEntity();
				model.addAttribute("msg", "このユーザーは変更できません。");
			} else {
				userCharList = this.charMapper.selectCharListByUsrCd(usrCd);
			}
		}
		model.addAttribute("user", user);
		List<Integer> charCdList = new ArrayList<Integer>();
		for (SYST06CharEntity oneUserChar : userCharList) {
			charCdList.add(oneUserChar.getCharCd());
		}
		model.addAttribute("charCdList", charCdList);
		return "user/oper";
	}

	@RequestMapping("/modifyPasswdpage")
	public String modifyPasswdpage(Model model) {
		SYST01UserEntity currentUser = (SYST01UserEntity) SecurityUtils.getSubject().getPrincipal();
		if (currentUser.getUsrId().toString().equals("sysAdmin")) {
			currentUser = new SYST01UserEntity();
			model.addAttribute("msg", "このユーザのパスワードは変更できません。");
		}
		model.addAttribute("user", currentUser);
		return "user/modifyPasswd";
	}

	/**
	 * 变更用户密码
	 */
	@RequestMapping("/password")
	public String password(String updateTime, String passwd, String newPassword, Model model) {
		SYST01UserEntity currentUser = (SYST01UserEntity) SecurityUtils.getSubject().getPrincipal();
		if (currentUser.getUsrId().toString().equals("sysAdmin")) {
			currentUser = new SYST01UserEntity();
			model.addAttribute("msg", "このユーザのパスワードは変更できません。");
		} else {
			// 更新密码
			boolean flag = this.userService.updateUserPassword(currentUser.getUsrCd(), passwd, newPassword, updateTime);
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
			SYST01UserEntity newUser = this.userService.selectUserByUsrCd(currentUser.getUsrCd());
			model.addAttribute("user", newUser);
		}
		return "user/modifyPasswd";
	}

	/**
	 * 保存用户
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public String save(String charCdList, SYST01UserEntity user) throws Exception {
		String message = new String();
		if (user.getUsrId().toString().equals("sysAdmin")) {
			message = "名前を追加できないのは'sysAdmin'のユーザーです";
		} else {
			List<Integer> charCdLists = new ArrayList<>();
			if (!charCdList.isEmpty() && charCdList != "" && charCdList != null) {
				for (String charCd : charCdList.split(",")) {
					charCdLists.add(Integer.valueOf(charCd));
				}
			}
			user.setPasswd(user.getUsrId());
			if (this.userService.saveUser(user, charCdLists)) {
				message = "新規に成功しました。";
			} else {
				message = "新規に失敗しました、更新してから送信してください";
			}
		}
		return message;
	}

	/**
	 * 变更用户
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(String updateTime, String charCdList, SYST01UserEntity user) {
		String message = new String();
		if (user.getUsrId().toString().equals("sysAdmin")) {
			message = "このユーザは変更できません。";
		} else {
			List<Integer> charCdLists = new ArrayList<>();
			if (!charCdList.isEmpty() && charCdList != "" && charCdList != null) {
				for (String charCd : charCdList.split(",")) {
					charCdLists.add(Integer.valueOf(charCd));
				}
			}
			if (user.getPasswd() != null) {
				user.setPasswd(user.getUsrId());
			}
			message = this.userService.updateUser(updateTime, user, charCdLists);
			switch (message) {
			case "updateSucess":
				message = "更新に成功しました。";
				break;
			case "updateFail":
				message = "更新に失敗しました、更新してから送信してください";
				break;
			default:
				break;
			}
			// 添加成功之后 清除缓存
			DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
			CustomRealm shiroRealm = (CustomRealm) securityManager.getRealms().iterator().next();
			// 清除用户认证相关的缓存
			shiroRealm.clearAllCachedAuthenticationInfo();
		}
		return message;
	}

	/**
	 * 删除用户
	 */
	@RequestMapping("/delete")
	public String delete(Integer[] usrCds, Model model) {
		for (int i = 0; i < usrCds.length; i++) {
			SYST01UserEntity user = this.userService.selectUserByUsrCd(usrCds[i]);
			if (user.getUsrId().toString().equals("sysAdmin")) {
				usrCds = UserCheck.arrayDelete(i, usrCds);
			}
		}
		if (usrCds.length != 0) {
			this.userService.deleteUserBatch(usrCds);
		}
		SYST01UserEntity nullUser = new SYST01UserEntity();
		// 添加成功之后 清除缓存
		DefaultWebSecurityManager securityManager = (DefaultWebSecurityManager) SecurityUtils.getSecurityManager();
		CustomRealm shiroRealm = (CustomRealm) securityManager.getRealms().iterator().next();
		// 清除用户认证相关的缓存
		shiroRealm.clearAllCachedAuthenticationInfo();
		return this.selectUsers(nullUser, 1, model);
	}
}
