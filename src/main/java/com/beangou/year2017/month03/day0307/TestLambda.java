package com.beangou.year2017.month03.day0307;

import com.beangou.year2017.Entity;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <pre>
 * 说明：
 *
 * </pre>
 *
 * @author <a href="mailto:liutongbin@loonxi.com">小彬</a>
 * @version 1.0 2017/3/7
 * @since 1.0
 */
public class TestLambda {

    @Test
    public void testMap() {
        String idsStr = "22,22,221,123,323";
        String[] idArr = idsStr.split(",");
        List<Long> idList = Arrays.stream(idArr).map(e -> Long.valueOf(e)).collect(Collectors.toList());
        System.out.println("idList=" + idList);
    }


    /**
     * Map阶段：对集合中的元素进行操作
     * Reduce阶段：将上一步得到的结果进行合并得到最终的结果
     */
    @Test
    public void testReduce() {
        final StockInfo stockInfo = Tickers.symbols.stream().map(StockUtil::getPrice)
                .filter(StockUtil.isPriceLessThan(500)).reduce(StockUtil::pickHigh).get();
        System.out.println("result=" + stockInfo);
    }

}

class StockInfo extends Entity {
    public final String ticker;
    public final BigDecimal price;
    public StockInfo(final String symbol, final BigDecimal thePrice) {
        ticker = symbol;
        price = thePrice;
    }
    public String toString() {
        return String.format("ticker: %s price: %g", ticker, price);
    }
}


class StockUtil {
    public static StockInfo getPrice(final String ticker) {
        BigDecimal big = new BigDecimal(1000 * Math.random());
        System.out.println("big=" + big);
        return new StockInfo(ticker, big);
    }

    public static Predicate<StockInfo> isPriceLessThan(final int price) {
//        System.out.println("stockInfo=" + stockInfo);
        return stockInfo -> stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;

//        return new Predicate<StockInfo>() {
//            @Override
//            public boolean test(StockInfo stockInfo) {
//                return stockInfo.price.compareTo(BigDecimal.valueOf(price)) < 0;
//            }
//        };
    }

    public static StockInfo pickHigh(
            final StockInfo stockInfo1, final StockInfo stockInfo2) {
        return stockInfo1.price.compareTo(stockInfo2.price) > 0 ? stockInfo1 : stockInfo2;
    }
}

class Tickers {
    public static final List<String> symbols = Arrays.asList(
            "AMD", "HPQ", "IBM", "TXN", "VMW", "XRX", "AAPL", "ADBE",
            "AMZN", "CRAY", "CSCO", "DELL", "GOOG", "INTC", "INTU",
            "MSFT", "ORCL", "TIBX", "VRSN", "YHOO");
}