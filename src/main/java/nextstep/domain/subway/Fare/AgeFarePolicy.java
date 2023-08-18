package nextstep.domain.subway.Fare;

public class AgeFarePolicy extends FarePolicy{
    private Integer age;

    public AgeFarePolicy(Integer age) {
        this.age = age;
    }

    @Override
    public int calculateFare(int fare) {
        return AgeFareType.getAgeFareType(this.age).getDiscountFee(fare);
    }
}
