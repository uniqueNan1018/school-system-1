package com.school.controller;

public class Code {
	/**
	 * 保存成功
	 */
	public static final Integer SAVE_OK = 20011;
	/**
	 * 削除成功
	 */
	public static final Integer DELETE_OK = 20021;
	/**
	 * 更新成功
	 */
	public static final Integer UPDATE_OK = 20031;
	/**
	 * 捜索成功
	 */
	public static final Integer GET_OK = 20041;
	
	/**
	 * 保存エラー
	 */
	public static final Integer SAVE_ERROR = 20010;
	/**
	 * 削除エラー
	 */
	public static final Integer DELETE_ERROR = 20020;
	/**
	 * 更新エラー
	 */
	public static final Integer UPDATE_ERROR = 20030;
	/**
	 * 捜索エラー
	 */
	public static final Integer GET_ERROR = 20040;
	
	
	/**
	 * システムエラー
	 */
	public static final Integer SYSTEM_ERROR = 50001;
	public static final Integer SYSTEM_TIMEOUT_ERROR = 50002;
	public static final Integer SYSTEM_UNKNOW_ERROR = 59999;
	/**
	 * ビジネスエラー
	 */
	public static final Integer BUSINESS_ERROR = 60001;
}
