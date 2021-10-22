package function;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c");
        List<String> collected = stream.collect(Collectors.toList());
    }
}
