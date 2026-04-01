package akz.news.exception;

import akz.news.utils.enums.EError;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Custom exception class that extends RuntimeException to include an HTTP status and an error ID.
 */
@Getter
public class CustomException extends RuntimeException {


  /**
   * The HTTP status associated with the exception.
   */
  private final HttpStatus status;
  /**
   * The error ID associated with the exception.
   */
  private final String id;

  /**
   * Constructs a new CustomCommonException with the specified HTTP status and error enum.
   * @param status    the HTTP status associated with the exception
   * @param errorEnum the error enum containing the message and ID
   */
  public CustomException(HttpStatus status, EError errorEnum) {
    super(errorEnum.getMessage());
    this.status = status;
    this.id = errorEnum.getId();
  }

  /**
   * Constructs a new CustomCommonException with the specified error enum and a default HTTP status of INTERNAL_SERVER_ERROR.
   * @param errorEnum the error enum containing the message and ID
   */
  public CustomException(EError errorEnum) {
    this(HttpStatus.INTERNAL_SERVER_ERROR, errorEnum);
  }

  /**
   * Constructs a new CustomCommonException with a default HTTP status of INTERNAL_SERVER_ERROR and a general error message.
   */
  public CustomException() {
    this(HttpStatus.INTERNAL_SERVER_ERROR, EError.GENERAL_MESSAGE);
  }
}
