package chap07;

public class StubAutoDebitInfoRepository implements AutoDebitInfoRepository {
    @Override
    public void save(AutoDebitInfo newInfo) {

    }

    @Override
    public AutoDebitInfo findOne(String userId) {
        return null;
    }
}
