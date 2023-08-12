package nextstep.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import nextstep.domain.Path;
import nextstep.domain.Station;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class PathResponse {

    private List<Station> stations;
    private Long distance;
    private Long duration;
    private int fare;

    public static PathResponse createPathResponse(Path path){
        PathResponse pathResponse = new PathResponse();
        pathResponse.stations = path.getStations();
        pathResponse.distance = path.getDistance();
        pathResponse.duration = path.getDuration();
        pathResponse.fare = path.getFare();

        return pathResponse;
    }
}
