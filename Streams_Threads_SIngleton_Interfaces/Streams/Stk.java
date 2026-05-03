package Streams_Threads_SIngleton_Interfaces.Streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Stk {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1, 2, 3, 4, 5);

        l1.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);


        // Map() - Transform elements

        List<String> l2 = Arrays.asList("java", "stream", "code");

        l2.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);


        List<Integer> lengths = l2.stream()
                .map(String::length)
                .toList();

        System.out.println(lengths);


//        List<String> data = Arrays.asList("John", "Jane", "Doe");


//        FlatMap () - Flatten Nested Structure
        List<List<Integer>> l3 = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4)
        );

        l3.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);


        // Sorting () - Sorting
        List<Integer> l4 = Arrays.asList(1, 5, 3, 2, 7, 4, 2);

        l4.stream()
                .sorted()
                .forEach(System.out::print);




        // custom sorting
        System.out.println();
        l4.stream()
                .sorted((a, b) -> b - a) //descending
                .forEach(System.out::print);
        System.out.println();




        //Distinct () - Remove duplicates
        System.out.println("Duplicate removal:");
        l4.stream()
                .distinct()
                .forEach(System.out::print);

        System.out.println();




        //Limit() and skip() - slicing

        l4.stream().limit(3) //first 3 elements
//        l4.stream().skip(2) //skip first 2 elements
                .forEach(System.out::print);


        System.out.println();

        //Collect() - convert to collection
        List<Integer> result = l4.stream()
                .filter(n -> n > 2)
                .toList();

        System.out.println("result is " + result);





        //reduce() - combine into one value
        int sum = l4.stream()
                .reduce(0,(a,b)->a+b);
        System.out.println("sum all :" +sum);


        // count () - total elements
        long c = l4.stream()
                .count();
        System.out.println("count of array elements :" + c);


        Optional<Integer> ans = l4.stream()
                .findFirst();
        System.out.println(ans);



        Optional<Integer> ans2 = l4.stream()
                .findAny();
        System.out.println(ans2);

    }

}
