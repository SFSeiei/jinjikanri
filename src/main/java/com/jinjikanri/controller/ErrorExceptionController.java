package com.jinjikanri.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorExceptionController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping(value = {"/error"})
    public Object error(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        model.addObject("msg", "訪問先が飛んでしまいました");
        model.setViewName("error404");
        return model;
    }

}
