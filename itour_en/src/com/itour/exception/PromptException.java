package  com.itour.exception;

/**
 * 提示类异常
 */
@SuppressWarnings("serial")
public class PromptException extends RuntimeException {
	public PromptException(String message) {
		super(message);
	}
}
