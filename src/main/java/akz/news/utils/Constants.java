package akz.news.utils;

import akz.news.exception.CustomException;
import akz.news.utils.enums.EError;

public final class Constants {

  public static final String CACHING_TOP_HEADLINES = "top-headlines";
  public static final String CACHING_EVERYTHING_NEWS = "everything-news";
  public static final String CACHING_SOURCES = "sources";

  private Constants() {
    throw new CustomException(EError.UTILITY_CLASS);
  }
}
