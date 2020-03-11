package com.jinjikanri.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * メインコントローラは,パブリックページをジャンプするためのものである
 * @author caichunyu
 *
 */
@Controller
public class MainController {
	/**
	 * アクセス先トランジション登録インタフェースを入力する
	 * @author caichunyu
	 * @return
	 */
	@RequestMapping(value = "/")
	public String login() {
		return "login";
	}

	/**
	 * ジャンプ歓迎ページ
	 * @author caichunyu
	 * @return
	 */
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "welcome";
	}
	
	/**
	 * ページをジャンプする
	 * @author caichunyu
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/errorException")
	public String errorException(Model model) {
		model.addAttribute("msg", "システムエラー、管理に連絡してください");
		return "ajaxException";
	}
}
