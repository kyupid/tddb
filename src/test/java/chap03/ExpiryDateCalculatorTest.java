package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, expiryDate);
    }

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2022, 3, 19))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022, 4, 19));
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2022, 5, 1))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022, 6, 1));
    }

    @Test
    void 납부일과_만료일의_일자가_같지_않을경우() {
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2022, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2022, 2, 28));
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2019, 6, 30));
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2020, 1, 31))
                        .payAmount(10_000)
                        .build(),
                LocalDate.of(2020, 2, 29));
    }

    @Test
    void 첫_납부일과_만료일의_일자가_같이_않을때_1만원_납부하면_첫_납부일_기준으로_다음_만료일_정함() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,31))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData, LocalDate.of(2019,3,31));

        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,30))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        assertExpiryDate(payData2, LocalDate.of(2019,3,30));
    }

}
