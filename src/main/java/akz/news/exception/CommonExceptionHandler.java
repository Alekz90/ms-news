package akz.news.exception;

import lombok.extern.log4j.Log4j2;

/**
 * Global exception handler for common exceptions.
 */
@Log4j2
public class CommonExceptionHandler {

  /**
   * Default constructor.
   */
  public CommonExceptionHandler(){}

  /**
   * Handles CustomCommonException and returns a structured response.
   * @param exception the CustomCommonException to handle
   * @return ResponseEntity containing the ResultDto with error details
   */
//  protected ResponseEntity<ResultDto<Object>> handleCustomCommonException(CustomCommonException exception) {
//      return ResponseEntity.status(exception.getStatus()).body(new ResultDto<>(exception));
//  }

  /**
   * Handles HttpMessageNotReadableException and returns a structured response.
   * @param exception the HttpMessageNotReadableException to handle
   * @return ResponseEntity containing the ResultDto with error details
   */
//  protected ResponseEntity<ResultDto<Object>> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) {
//      return this.handleCustomCommonException(new CustomCommonException(HttpStatus.BAD_REQUEST, ECommonError.BAD_REQUEST));
//  }

  /**
   * Handles MethodArgumentNotValidException and returns a structured response.
   * @param exception the MethodArgumentNotValidException to handle
   * @return ResponseEntity containing the ResultDto with error details
   */
//  protected ResponseEntity<ResultDto<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
//      List<ModelValidationDto.FieldValidation> listErrors =
//              exception.getBindingResult().getFieldErrors()
//                  .stream()
//                  .map(ModelValidationDto.FieldValidation::from)
//                  .toList();
//
//      return ResponseEntity
//          .status(HttpStatus.BAD_REQUEST)
//          .body(new ResultDto<>(listErrors, new CustomCommonException(HttpStatus.BAD_REQUEST, ECommonError.BAD_REQUEST)));
//  }

  /**
   * Handles ConstraintViolationException and returns a structured response.
   * @param exception the ConstraintViolationException to handle
   * @return ResponseEntity containing the ResultDto with error details
   */
//  protected ResponseEntity<ResultDto<Object>> handleConstraintViolationException(ConstraintViolationException exception) {
//      List<ModelValidationDto.ConstraintValidation> listErrors =
//              exception.getConstraintViolations()
//                  .stream()
//                  .map(ModelValidationDto.ConstraintValidation::from)
//                  .toList();
//      return ResponseEntity
//          .status(HttpStatus.BAD_REQUEST)
//          .body(new ResultDto<>(listErrors, new CustomCommonException(HttpStatus.BAD_REQUEST, ECommonError.BAD_REQUEST)));
//  }

  /**
   * Handles NoResourceFoundException and returns a structured response.
   * @param exception the NoResourceFoundException to handle
   * @return ResponseEntity containing the ResultDto with error details
   */
//  protected ResponseEntity<ResultDto<Object>> handleNoResourceFoundException(NoResourceFoundException exception) {
//      return this.handleCustomCommonException(new CustomCommonException(HttpStatus.NOT_IMPLEMENTED, ECommonError.RESOURCE_NOT_FOUND));
//  }
}
