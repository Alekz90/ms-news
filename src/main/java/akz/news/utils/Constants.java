package akz.news.utils;

import akz.news.exception.CustomException;
import akz.news.utils.enums.EError;

public final class Constants {

  public static final String CACHING_TOP_HEADLINES = "top-headlines";
  public static final String CACHING_EVERYTHING_NEWS = "everything-news";
  public static final String CACHING_SOURCES = "sources";
  public static final String TEST_PROFILE = "test";
  public static final String NOT_TEST_PROFILE = "!test";
  public static final String SUCCESS_STATUS_RESPONSE = "ok";
  public static final String ERROR_STATUS_RESPONSE = "error";

  private Constants() {
    throw new CustomException(EError.UTILITY_CLASS);
  }
}
