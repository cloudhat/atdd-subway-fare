package nextstep.domain.subway.Fare;

public class DistanceFarePolicy extends FarePolicy{

    private static final int BASE_FARE = 1250;
    private Long distance;

    public DistanceFarePolicy(Long distance) {
        this.distance = distance;
    }

    @Override
    public int calculateFare(int fare) {

        return BASE_FARE + fare + DistanceFareType.getFareByDistance(this.distance);
    }
}
