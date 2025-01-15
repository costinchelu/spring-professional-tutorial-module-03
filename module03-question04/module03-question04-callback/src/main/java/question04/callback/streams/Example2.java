package question04.callback.streams;

import java.util.stream.Stream;

public class Example2 {

    public static void main(String[] args) {
        new Example2().run();
    }

    // stream using reference to methods as callbacks
    private void run() {
        Stream.iterate(2L, this::getNext)
                .limit(5)
                .map(this::formatNumber)
                .forEach(System.out::println);
    }

    private long getNext(long i) {
        return (long) Math.pow(i, 2);
    }

    private String formatNumber(long n) {
        return String.format("Number = %d", n);
    }
}
