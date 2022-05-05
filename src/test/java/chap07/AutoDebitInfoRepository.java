package chap07;

import java.util.Map;

public class AutoDebitInfoRepository {
    private Map<String, AutoDebitInfo> autoDebitInfo;

    public void save(AutoDebitInfo newInfo) {
        this.autoDebitInfo.put(newInfo.getUserId(), newInfo);
    }

    public AutoDebitInfo findOne(String userId) {
        return this.autoDebitInfo.get(userId);
    }
}
