package com.school.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.school.exception.BusinessException;
import com.school.exception.SystemException;

@RestControllerAdvice
public class ProjectExceptionAdvice {
	@ExceptionHandler(SystemException.class)
	public Result doSystemException(SystemException ex) {
		/* TODO
		 * ログを保存する
		 * インフラにメッセージを送る
		 * SEにメールを送る
		 */
		return new Result(ex.getCode(), null, ex.getMessage());
	}
	
	@ExceptionHandler(BusinessException.class)
	public Result doBusinessException(BusinessException ex) {
		return new Result(ex.getCode(), null, ex.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public Result doException(Exception ex) {
		/* TODO
		 * ログを保存する
		 * インフラにメッセージを送る
		 * SEにメールを送る
		 */
		return new Result(Code.SYSTEM_UNKNOW_ERROR, null, "未知なエラーが発生しました");
	}
}
