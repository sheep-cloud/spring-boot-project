package com.github.common.core;

import com.github.pagehelper.Page;

/**
 * 系统响应结果工具类
 *
 * @author colg
 */
public class ResultUtil {

	public static ResultInfo fail(Object data, int messageCode, String message) {
		return createResultInfo(ResultInfo.TYPE_RESULT_FAIL, data, messageCode, message);
	}

	public static ResultInfo success(Object data, int messageCode, String message) {
		return createResultInfo(ResultInfo.TYPE_RESULT_SUCCESS, data, messageCode, message);
	}

	public static ResultInfo warn(Object data, int messageCode, String message) {
		return createResultInfo(ResultInfo.TYPE_RESULT_WARN, data, messageCode, message);
	}

	public static ResultInfo info(Object data, int messageCode, String message) {
		return createResultInfo(ResultInfo.TYPE_RESULT_INFO, data, messageCode, message);
	}

	/**
	 * 构建返回消息
	 * 
	 * @param type
	 * @param data
	 * @param messageCode
	 * @param message
	 * @return
	 */
	private static ResultInfo createResultInfo(int type, Object data, int messageCode, String message) {
		ResultInfo resultInfo = new ResultInfo(type, messageCode, message, data);
		if (data instanceof Page<?>) {
			resultInfo.setTotal(((Page<?>) data).getTotal());
		}
		return resultInfo;
	}
}
