package com.codecool;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Streams {
    public static void main(String[] args) {
        /*------------------------------------------------------------------------------
         * Create a stream out of the following array.
         */

        String[] a1 = {"one", "two", "three"};
        Stream<String> s1 = Arrays.stream(a1);
//        System.err.println("------------------------------------------------");
//        System.out.println("with Arrays.stream");
//        s1.forEach(System.out::println);
        /*------------------------------------------------------------------------------
             * Create a stream containing the Strings "one" , "two" and "three"
             * without using an array
         */

        Stream<String> s2 = Stream.of("one", "two", "three");
//        System.err.println("------------------------------------------------");
//        System.out.println("Without Array");
//        s2.forEach(System.out::println);
        /*------------------------------------------------------------------------------
         * Create a stream using a stream builder.
         */

        Stream.Builder<String> b1 = Stream.builder();
        b1.add("one");
        b1.add("two");
        b1.add("three");

        Stream<String> s3 = b1.build();
//        System.err.println("------------------------------------------------");
//        System.out.println("StringBuilder");
//        s3.forEach(System.out::println);

        /*------------------------------------------------------------------------------
         * Collect one of the above defined streams into a list.
         *
         * HINT: the keyword here is "collect"
         */

        List<String> l1 = s1.collect(Collectors.toList());
        List<String> a1Converted = Arrays.stream(a1).collect(Collectors.toList());

//        System.err.println("------------------------------------------------");
//        System.out.println("Collected s1 into a List:");
//        l1.forEach(System.out::println);



        /*------------------------------------------------------------------------------
         * Streams can be infinite.  We obviously cannot create such a
         * stream by supplying all the elements ourselves.
         *
         * HINT: When looking for methods to create such streams
         * realize that:
         * - These methods cannot belong to an instance
         * - They are returning streams
         */

        /*
         * Create a stream of the powers of two.
         */

        Integer twoToTheZeroth = 1;
        UnaryOperator<Integer> doubler = (Integer x) -> 2 * x;
        Stream<Integer> s4 = Stream.iterate(twoToTheZeroth, doubler).limit(20);
//        System.err.println("------------------------------------------------");
//        System.out.println("ITERATOR: Infinite stream of the powers of two: ");
//        s4.forEach(System.out::println);


        /*------------------------------------------------------------------------------
         * Create a stream containing the first ten elements of s4.
         */
        Stream<Integer> s5 = s4.limit(10);
        s5.forEach(System.err::println);

        /*------------------------------------------------------------------------------
         * Create a stream containing the elements of the Fibonacci
         * sequence.
         *
         * HINT: You will need to create a new class for this.
         */


        Supplier<Integer> fibSupp = new Fibonacci();
        Stream<Integer> s6 = Stream.generate(fibSupp).limit(25);
        s6.forEach(System.out::println);
    }
}
