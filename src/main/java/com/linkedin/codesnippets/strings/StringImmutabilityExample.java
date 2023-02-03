package com.linkedin.codesnippets.strings;

/*@author: pedrolopesdev at 2023-02-02
 https://www.linkedin.com/in/pedro-lopes-dev//
 https://twitter.com/pedro_lopes3
 https://pedrolopesdev.com */
public class StringImmutabilityExample {

    /* Explanation: We should use core concepts of Java String to answer this question:
      - Strings are immutable, so trying to modify `hello` using `concat` doesn't work like on line `28`.
         Thus, line `35` prints false.
      - The `equals` method compares the content of two String objects.
         Thus, lines `36` prints true.
      - The `==` operator compares the objects' addresses, not their content. Using `new String()` and `new StringBuilder()` instantiates new addresses in memory.
         Therefore, lines `38` and `39` print false.
      - The particular case for the `==` operator is when the two Strings are created using double quotes, aka literals.
         In that case, the String Pool assigns the same memory address to both variables. Thus, line `40` prints true. */

    /* Check out useful resources:
     https://pedrolopesdev.com/post/java-string-pool
     https://pedrolopesdev.com/post/string-concatenation-in-java/ */


    public static void main(String[] args) {
        String hello = "Hello";
        String world = " World";
        hello.concat(world);

        String helloWorld1 = "Hello World";
        String helloWorld2 = new String("Hello World");
        String helloWorld3 = new StringBuilder("Hello World").toString();
        String helloWorld4 = "Hello World";

        System.out.println(hello.equals(helloWorld1)); // false
        System.out.println(helloWorld3.equals(helloWorld1)); //true
        System.out.println(helloWorld1 == helloWorld2); // false
        System.out.println(helloWorld3 == helloWorld2); //false
        System.out.println(helloWorld1 == helloWorld4); // true
    }
}
