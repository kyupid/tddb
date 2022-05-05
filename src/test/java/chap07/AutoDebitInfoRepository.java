package chap07;

import java.util.Map;

/**
 * 인터페이스로 사용하여 JpaAutoDebitInfoRepository와
 * Memory...Repository로 분리
 */
public interface AutoDebitInfoRepository {
    void save(AutoDebitInfo newInfo);

    AutoDebitInfo findOne(String userId);
}
