package chap07;

import java.time.LocalDateTime;

public class AutoDebitRegister {
    private CardNumberValidator validator;
    private AutoDebitInfoRepository repository;

    public AutoDebitRegister (CardNumberValidator validator,
                                 AutoDebitInfoRepository repository) {
        this.validator = validator;
        this.repository = repository;
    }

    public RegisterResult register(AutoDebitReq req) {
        CardValidity validity = validator.validate(req.getCardNumber()); // 외부 API를 통해 validity를 체크한다

        if(validity != CardValidity.VALID) {
            return RegisterResult.error(validity); // 유효하지않다는 결과를 내보낸다
        }
        AutoDebitInfo info = repository.findOne(req.getUserId()); // 디비에 AutoDebit정보가 있는지체크
        if (info != null) {
            info.changeCardNumber(req.getCardNumber()); // 있으면 업데이트
        } else {
            AutoDebitInfo newInfo =
                    new AutoDebitInfo(req.getUserId(), req.getCardNumber(),
                            LocalDateTime.now());
            repository.save(newInfo); // 없으면 저장해준다
        }
        return RegisterResult.success();
    }
}
