package nextstep.domain.member;

public class NullMember extends AbstractMember{

    private final int NON_LOGIN_AGE = 30;
    @Override
    public boolean isNull() {
        return true;
    }

    @Override
    public Integer getAge() {
        return NON_LOGIN_AGE;
    }
}
