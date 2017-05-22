package  com.itour.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务异常
 */
@SuppressWarnings("serial")
public class BusinessException extends RuntimeException {
	protected String code;
	protected String message;
	protected Map<String, String> errors;

	public BusinessException(String message) {
		this("", message);
	}

	public BusinessException(String paramString1, String paramString2) {
		this(paramString2, new HashMap<String, String>());
	}

	public BusinessException(Map<String, String> paramMap) {
		this("", paramMap);
	}

	public BusinessException(String paramString, Map<String, String> paramMap) {
		super(paramString);
		this.message = paramString;
		this.errors = paramMap;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

	public Map<String, String> getErrors() {
		return this.errors;
	}
}