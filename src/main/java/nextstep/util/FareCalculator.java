package nextstep.util;

import nextstep.domain.subway.Fare.AgeFarePolicy;
import nextstep.domain.subway.Fare.DistanceFarePolicy;
import nextstep.domain.subway.Fare.FarePolicy;
import nextstep.domain.subway.Fare.LineFarePolicy;
import nextstep.domain.subway.Line;

import java.util.List;

public class FareCalculator {
    public static int totalFare(Long distance , List<Line> lines,Integer age){
        int totalFare = 0;

        FarePolicy farePolicy = new DistanceFarePolicy(distance)
                .setNextFarePolicy(new LineFarePolicy(lines))
                .setNextFarePolicy(new AgeFarePolicy(age));


        totalFare = farePolicy.getCalculatedFare(totalFare);

        return totalFare;
    }

}
