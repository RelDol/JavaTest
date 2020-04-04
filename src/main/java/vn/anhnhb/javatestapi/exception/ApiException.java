package vn.anhnhb.javatestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Handle Exception for API
 * @author AnhNHB
 * @version 1.0 2020/04/03
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ApiException extends Exception {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor
	 * @param message message
	 */
	public ApiException(String message) {
		super(message);
	}
}
