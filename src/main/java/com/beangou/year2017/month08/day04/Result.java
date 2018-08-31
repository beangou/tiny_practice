package com.beangou.year2017.month08.day04;

import com.beangou.year2017.Entity;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * 业务返回对象
 * @param <T>
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result<T> extends Entity implements Serializable {

	private static final long serialVersionUID = -1L;

	// 返回码
	private int code = ResultCodeEnum.SUCCESS.getCode();
	private String message;
	// 子信息
	private String subMessage;
	private T data;

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}


	public static <T> Result<T> success() {
		return build(ResultCodeEnum.SUCCESS, null, null);
	}

	public static <T> Result<T> success(T data) {
		return build(ResultCodeEnum.SUCCESS, null, data);
	}

	public static <T> Result<T> success(String message) {
		return build(ResultCodeEnum.SUCCESS, message, null);
	}

	public static <T> Result<T> success(String message, T content) {
		return build(ResultCodeEnum.SUCCESS, message, content);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T> Result<T> build(ResultCodeEnum code, String message, T data) {
		Result ajax = new Result();
		ajax.setMessage(message);
		ajax.setCode(code.getCode());
		ajax.setData(data);
		return ajax;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 检验返回结果是否成功
	 * @return
	 */
	public static boolean isSuccessful(Result result) {
		return result != null && result.code == ResultCodeEnum.SUCCESS.getCode();
	}

	/**
	 * 检验返回结果是否失败
	 * @return
	 */
	public static boolean isFailed(Result result) {
		return result == null || result.code != ResultCodeEnum.SUCCESS.getCode();
	}

}

@Getter
enum ResultCodeEnum {

    SUCCESS(0);

    int code;

    public int getCode() {
        return code;
    }

    ResultCodeEnum(int code) {
        this.code = code;
    }

}