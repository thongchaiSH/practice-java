package com.learn.java.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class method {
    //REF https://medium.com/swlh/java-collectors-and-its-20-methods-2fc422920f18
    public static void main(String[] args) {
        List<Integer> integers= Arrays.asList(1,2,3,4,5,6,6);
        List<String> strings = Arrays.asList("a","alpha","beta","gamma");
        List<Long> longValues = Arrays.asList(100l,200l,300l);
        List<Double> doubles = Arrays.asList(1.1,2.0,3.0,4.0,5.0,5.0);
        //1.Creating list: toList()
        System.out.println(integers.stream().map(x-> x*x).collect(Collectors.toList()));

        //2. Creating set: toSet()
        System.out.println(integers.stream().map(x->x*x).collect(Collectors.toSet()));

        //3. Creating specific collection: toCollection()
        LinkedList result=integers
                .stream()
                .filter(x-> (x>2))
                .collect(Collectors.toCollection(LinkedList::new));
        System.out.println(result);

        //4. Counting elements: Counting()
        Long collect=integers
                .stream()
                .filter(x->x<4)
                .collect(Collectors.counting());
        System.out.println(collect);

        //5. Finding minimum/Maximum value: minBy(),maxBy()
        System.out.println(
            integers
                    .stream()
                    .collect(Collectors.minBy(Comparator.naturalOrder()))
                    .get()
        );
        System.out.println(
            strings
                    .stream()
                    .collect(Collectors.maxBy(Comparator.naturalOrder()))
                    .get()
        );


        //7. Partitioning a list: partitioningBy()
        Map<Boolean, List<String>> collect1 = strings
                .stream()
                .collect(Collectors.partitioningBy(x -> x.length() > 2));
        System.out.println(collect1);
        // output: {false=[a], true=[alpha, beta, gamma]}


        //8. Creating unmodifiable list: toUnmodifiableList()
        List<String> collect2 = strings
                .stream()
                .collect(Collectors.toUnmodifiableList());
//        collect2.set(1,"2"); //unmodifiable for java 11+

        //9. Creating unmodifiable set: toUnmodifiableSet()
        Set<String> readOnlySet = strings
                .stream()
                .sorted()
                .collect(Collectors.toUnmodifiableSet());

        //10. Joining elements: joining()
        String collect3 = strings
                .stream()
                .distinct()
                .collect(Collectors.joining(","));
        // output: alpha,beta,gamma
        System.out.println(collect3);
        String collect4 = strings
                .stream()
                .map(s -> s.toString())
                .collect(Collectors.joining(",","[","]"));
        // output: [alpha,beta,gamma]
        System.out.println(collect4);


        //11. Averaging long: averagingLong()
        Double d1 = longValues
                .stream()
                .collect(Collectors.averagingLong(x -> x * 2));
        System.out.println(d1);  // output: 400.0

        //12. Averaging int: averagingInt()
        Double d2 = integers
                .stream()
                .collect(Collectors.averagingInt(x -> x*2));
        System.out.println(d2);  // output: 7.714285714285714

        //13. Averaging Double: averagingDouble()
        Double d3= doubles
                .stream()
                .collect(Collectors.averagingDouble(x->x));
        System.out.println(d3); // output: 3.35

        //14. Creating Map: toMap()
        Map<String,Integer> map=strings
                .stream()
                .collect(Collectors
                .toMap(Function.identity(), String::length));
        System.out.println(map); // output: {alpha=5, beta=4, gamma=5}

        //16. Summing Integers: summingInt()
        Integer collect5 = strings
                .stream()
                .collect(Collectors.summingInt(String::length));
        System.out.println(collect5);
        //or direct list value sum
        Integer collect6 = integers
                .stream()
                .collect(Collectors.summingInt(x->x));
        System.out.println(collect6);

        //17. Summing Doubles: summingDouble()
        Double sum =doubles
                .stream()
                .collect(Collectors.summingDouble(x->x));
        System.out.println(sum);

        //18. Summing Long: summingLong()
        Long sum2 = longValues
                .stream()
                .collect(Collectors.summingLong(x->x));
        System.out.println(sum2);

        //19. Summarizing Integer: summarizingInt()
        IntSummaryStatistics stats=integers
                .stream()
                .collect(Collectors.summarizingInt(x->x));
        System.out.println(stats);

        //20. GroupingBy method: groupingBy()
        Map<Integer, List<String>> collect7 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length));
        System.out.println(collect7);   // output: {4=[beta], 5=[alpha, gamma]}

        Map<Integer, LinkedList<String>> collect8 = strings
                .stream()
                .collect(Collectors.groupingBy(String::length,
                        Collectors.toCollection(LinkedList::new)));
        System.out.println(collect8);
    }


}
