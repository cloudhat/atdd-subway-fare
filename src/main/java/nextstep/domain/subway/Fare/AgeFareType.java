package nextstep.domain.subway.Fare;

import nextstep.domain.member.Member;

import java.util.Arrays;
import java.util.function.Function;

public enum AgeFareType {
    TODDLER(1, 5, fee -> 0),
    CHILDREN(6, 13, fee -> (int) ((fee - 350) * 0.5)),
    TEENAGER(13, 19, fee -> (int) ((fee - 350) * 0.8)),
    ADULT(19, Integer.MAX_VALUE, fee -> fee),
    ANONYMOUS(-1, -1, fee -> fee);

    private final int startAge;
    private final int endAge;
    private final Function<Integer, Integer> expression;

    AgeFareType(int startAge, int endAge, Function<Integer, Integer> expression) {
        this.startAge = startAge;
        this.endAge = endAge;
        this.expression = expression;
    }

    public int getDiscountFee(int fee) {
        return expression.apply(fee);
    }

    public static AgeFareType getAgeFareType(Integer age) {
        if(age==null){
            return ANONYMOUS;
        }

        return Arrays.stream(values()).filter(ageFeeType -> ageFeeType.startAge <= age && ageFeeType.endAge > age)
                .findAny().orElse(ADULT);
    }
}
