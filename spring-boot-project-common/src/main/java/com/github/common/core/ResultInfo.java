package com.github.common.core;

/**
 * 统一响应结果
 *
 * @author colg
 */
public class ResultInfo extends BaseEntity {

	/** 失败 */
	public static final int TYPE_RESULT_FAIL = 0;
	/** 成功 */
	public static final int TYPE_RESULT_SUCCESS = 1;
	/** 警告 */
	public static final int TYPE_RESULT_WARN = 2;
	/** 提示信息 */
	public static final int TYPE_RESULT_INFO = 3;

	/** 消息提示类型 */
	private int type;

	/** 提示代码 */
	private int messageCode;

	/** 提示信息 */
	private String message;

	/** 响应的数据 */
	private Object data;

	/** 响应列表总行数 */
	private long total;

	public ResultInfo() {
	}

	public ResultInfo(int type) {
		this.type = type;
	}

	public ResultInfo(int type, String message) {
		this.type = type;
		this.message = message;
	}

	public ResultInfo(int type, int messageCode, String message) {
		this.type = type;
		this.messageCode = messageCode;
		this.message = message;
	}

	public ResultInfo(int type, int messageCode, String message, Object data) {
		this.type = type;
		this.messageCode = messageCode;
		this.message = message;
		this.data = data;
	}

	public int getType() {
		return type;
	}

	public ResultInfo setType(int type) {
		this.type = type;
		return this;
	}

	public int getMessageCode() {
		return messageCode;
	}

	public ResultInfo setMessageCode(int messageCode) {
		this.messageCode = messageCode;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ResultInfo setMessage(String message) {
		this.message = message;
		return this;
	}

	public Object getData() {
		return data;
	}

	public ResultInfo setData(Object data) {
		this.data = data;
		return this;
	}

	public long getTotal() {
		return total;
	}

	public ResultInfo setTotal(long total) {
		this.total = total;
		return this;
	}

	public boolean isSuccess() {
		return this.type == TYPE_RESULT_SUCCESS ? true : false;
	}

}
