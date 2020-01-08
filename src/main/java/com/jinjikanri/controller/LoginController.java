package com.jinjikanri.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jinjikanri.entity.SYST01UserEntity;

@Controller
public class LoginController {
	@PostMapping("/login")
	public String login(SYST01UserEntity user, Model model) {
		// 添加用户认证信息
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUsrId(), user.getPasswd());
		try {
			// 进行验证，这里可以捕获异常，然后返回对应信息
			subject.login(usernamePasswordToken);
		} catch (IncorrectCredentialsException e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "ユーザーIDまたはパスワードが不正");
			return "login";
		} catch (LockedAccountException e) {
			model.addAttribute("errormsg", "ユーザーが锁定されて、管理に連絡してください");
			return "login";
		} catch (UnknownAccountException e) {
			model.addAttribute("errormsg", "ユーザーIDまたはパスワードが不正");
			return "login";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "ユーザー検証が失敗");
			return "login";
		} catch (AuthorizationException e) {
			e.printStackTrace();
			model.addAttribute("errormsg", "権限検証が失敗");
			return "login";
		}
		System.out.println(SecurityUtils.getSubject().getPrincipals());
		SYST01UserEntity currentUser = (SYST01UserEntity) SecurityUtils.getSubject().getPrincipal();
		model.addAttribute("user", currentUser);
		return "main";
	}

	/**
	 * 退出
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		SecurityUtils.getSubject().logout();
		return "login";
	}
}
