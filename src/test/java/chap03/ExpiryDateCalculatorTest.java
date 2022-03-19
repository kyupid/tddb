package chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        assertExpiryDate(LocalDate.of(2022, 3, 19), 10_000,
                LocalDate.of(2022, 4, 19));
        assertExpiryDate(LocalDate.of(2022, 5, 1), 10_000,
                LocalDate.of(2022, 6, 1));

    }

    @Test
    void 납부일과_만료일의_일자가_같지_않을경우() {
        assertExpiryDate(LocalDate.of(2022, 1, 31), 10_000,
                LocalDate.of(2022, 2, 28));
        assertExpiryDate(LocalDate.of(2019, 5, 31), 10_000,
                LocalDate.of(2019, 6, 30));
        assertExpiryDate(LocalDate.of(2020, 1, 31), 10_000,
                LocalDate.of(2020, 2, 29));
    }

    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);
        assertEquals(expectedExpiryDate, expiryDate);
    }
}
