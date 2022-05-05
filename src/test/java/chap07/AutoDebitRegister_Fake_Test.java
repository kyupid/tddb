package chap07;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static chap07.CardValidity.INVALID;
import static chap07.CardValidity.THEFT;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoDebitRegister_Fake_Test {
    private AutoDebitRegister register;
    private StubCardNumberValidator stubValidator;
    private MemoryAutoDebitInfoRepository memoryRepository;

    @BeforeEach
    void setUp() {
        stubValidator = new StubCardNumberValidator();
        memoryRepository = new MemoryAutoDebitInfoRepository();
        register = new AutoDebitRegister(stubValidator, memoryRepository);
    }

    @Test
    void alreadyRegistered_InfoUpdated() {
        memoryRepository.save(
                new AutoDebitInfo("user1", "11112222", LocalDateTime.now())
        );

        AutoDebitReq req = new AutoDebitReq("user1", "123123123");
        RegisterResult result = this.register.register(req);

        AutoDebitInfo saved = memoryRepository.findOne("user1");
        assertEquals("123123123", saved.getCardNumber());
    }
}
