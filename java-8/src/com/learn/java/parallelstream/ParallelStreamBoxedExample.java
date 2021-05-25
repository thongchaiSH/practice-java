package com.learn.java.parallelstream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParallelStreamBoxedExample {

    public static int sequentialSum(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();

        int sum = integerList.stream()
//                .reduce(0, (a, b) -> a + b);
                .reduce(0, Integer::sum);

        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline is sequential : " + (endTime - startTime));
        return sum;
    }

    public static int parallelSum(List<Integer> integerList) {
        long startTime = System.currentTimeMillis();

        int sum = integerList.parallelStream()
//                .reduce(0, (a, b) -> a + b);
                .reduce(0, Integer::sum);

        long endTime = System.currentTimeMillis();
        System.out.println("Duration to execute the pipeline is parallel : " + (endTime - startTime));
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> integerList = IntStream.rangeClosed(1, 10000)
                .boxed()
                .collect(Collectors.toList());

        sequentialSum(integerList);
        parallelSum(integerList);
//        System.out.println("Sequential " + );
//        System.out.println("Parallel " + );
    }
}
