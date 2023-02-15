package com.linkedin.codesnippets.streams;

import java.util.stream.Stream;

public class StreamsExamples {
    public static void main(String[] args) {

        var stats = Stream.of(1,2,3,4,5,6).mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(stats);
    }
}
