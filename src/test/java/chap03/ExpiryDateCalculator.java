package chap03;

import java.time.LocalDate;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(LocalDate billingDate, int payAmount) {
        return calculateExpiryDate(new PayData(billingDate, payAmount));
    }

    public LocalDate calculateExpiryDate(PayData payData) {
        return payData.getBillingDate().plusMonths(1);
    }
}
