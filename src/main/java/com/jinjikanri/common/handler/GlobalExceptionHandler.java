package com.jinjikanri.common.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.jinjikanri.common.constant.ItemConstant;

/**
 * 全局异常处理类
 * @author caichunyu
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	/**
	 * 其他异常
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public Object exceptionHandler(HttpServletRequest reqest, HttpServletResponse response, Exception exception) {
		if (isAjax(reqest)) {
			return "errors";
		} else {
			return exception(exception, reqest);
		}
	}
	
	/**
	 * 判断是否为AJAx请求
	 * @param request
	 * @return
	 */
	public boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null &&
                "XMLHttpRequest".equals(request.getHeader("X-Requested-With").toString()));
    }
	
	/**
	 * 非ajax请求
	 * @param ex
	 * @param request
	 * @return
	 */
	public ModelAndView exception(Exception ex,HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		if (ex instanceof Exception) {
			model.addObject("msg", "システムエラー、管理に連絡してください");
		}
		model.setViewName(ItemConstant.DEFAULT_ERROR_VIEW);
		return model;
	}
	
}
