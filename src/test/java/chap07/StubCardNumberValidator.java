package chap07;

/**
 * 외부 API를 사용하는게 아니라 Stub으로 유효한 거랑 유효하지 않을걸 만들어준다
 */
public class StubCardNumberValidator extends CardNumberValidator {
    private String invalidNo;
    private String theftNo;

    public StubCardNumberValidator(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public StubCardNumberValidator() {
    }

    @Override
    public CardValidity validate(String cardNumber) {
        if (invalidNo != null && invalidNo.equals(cardNumber)) {
            return CardValidity.INVALID;
        }
        if (theftNo != null && theftNo.equals(cardNumber)) {
            return CardValidity.THEFT;
        }

        return CardValidity.VALID;
    }

    public void setInvalidNo(String invalidNo) {
        this.invalidNo = invalidNo;
    }

    public void setTheftNo(String theftNo) {
        this.theftNo = theftNo;
    }
}
