package exercise;

import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> apartment, int count) {
        return apartment.stream()
                .sorted(Home::compareTo)
                .limit(count)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
