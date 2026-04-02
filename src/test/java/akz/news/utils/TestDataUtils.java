package akz.news.utils;

import akz.news.exception.CustomException;
import akz.news.remote.dto.ArticlesItem;
import akz.news.remote.dto.EverythingResponse;
import akz.news.remote.dto.Source;
import akz.news.utils.enums.EError;

import java.util.List;

import static akz.news.utils.Constants.SUCCESS_OK_RESPONSE;

public final class TestDataUtils {

  public static final EverythingResponse SUCCESS_EVERYTHING_RESPONSE
      = fillSuccessEverythingResponse();

  private TestDataUtils() {
    throw new CustomException(EError.UTILITY_CLASS);
  }

  private static EverythingResponse fillSuccessEverythingResponse() {
    return EverythingResponse.builder()
        .totalResults(2)
        .status(SUCCESS_OK_RESPONSE)
        .articles(List.of(
            ArticlesItem.builder()
                .author("Kyle Torpey")
                .title("Bitcoin Crashed 50% in 4 Months. Fidelity Says That’s a Good Thing")
                .description("Fidelity Digital Assets analysts do see one ray of hope for bitcoin maxis.")
                .url("https://gizmodo.com/bitcoin-crashed-50-in-4-months-fidelity-says-thats-a-good-thing-2000727284")
                .urlToImage("https://gizmodo.com/app/uploads/2025/10/bitcoin-explosion-1200x675.jpg")
                .publishedAt("2026-02-27T15:30:11Z")
                .content("Bitcoin’s price has taken a beating recently. After reaching a new all-time high above $126,000 in October, the crypto asset fell below $60,000 earlier this month before recovering to trade around $6… [+5115 chars]")
                .source(
                    Source.builder()
                        .name("Gizmodo.com")
                        .build())
                .build(),
            ArticlesItem.builder()
                .author("David Morris")
                .title("Jeffrey Epstein saw promise in Bitcoin — and its far-right supporters")
                .description("The tranche of Jeffrey Epstein emails and files released on January 30th tie the infamous pedophile, sex trafficker, and influence peddler to elite figures across the tech industry. The world of cryptocurrency is no exception. Epstein's connections are intrig…")
                .url("https://www.theverge.com/tech/885252/jeffrey-epstein-bitcoin-cryptocurrency-connections")
                .urlToImage("https://platform.theverge.com/wp-content/uploads/sites/2/2026/02/268350_Did_Jeffrey_Epstein_shape_bitcoin_or_not_understand_it_at_all__CVirginia.jpg?quality=90&strip=all&crop=0%2C10.732984293194%2C100%2C78.534031413613&w=1200")
                .publishedAt("2026-02-26T22:59:06Z")
                .content("<ul><li></li><li></li><li></li></ul>\\r\\nJeffrey Epstein saw promise in Bitcoin and its far-right supporters\\r\\nEpstein may not have fully understood crypto, but he helped shape its culture anyway.\\r\\nby\\r\\nD… [+21731 chars]")
                .source(
                    Source.builder()
                        .id("the-verge")
                        .name("The Verge")
                        .build())
                .build()
        ))
        .build();
  }
}
