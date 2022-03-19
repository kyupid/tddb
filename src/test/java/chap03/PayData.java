package chap03;

import java.time.LocalDate;

public class  PayData {
    private LocalDate billingDate;
    private int payAmount;

    public PayData(LocalDate billingDate, int payAmount) {
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }
}
