package com.linkedin.codesnippets.strings;

public class StringImmutabilityExample {

    //Explanation: We should use core concepts of Java String to answer this question:
    //  - Strings are immutable, so trying to modify `hello` using `concat` doesn't work like on line `9`.
    //     Thus, line `16` prints false.
    //  - The `equals` method compares the content of two String objects.
    //     Thus, lines `17` and `18` prints true.
    //  - The `==` operator compares the objects' addresses, not their content. Using `new String()` and `new StringBuilder()` instantiates new addresses in memory.
    //     Therefore, lines `19` and `20` print false.
    //  - The particular case for the `==` operator is when the two Strings are created using double quotes, aka literals.
    //     In that case, the String Pool assigns the same memory address to both variables. Thus, line `21` prints true.
    public static void main(String[] args) {
        String hello = "Hello";
        String world = " World";
        hello.concat(world);

        String helloWorld1 = "Hello World";
        String helloWorld2 = new String("Hello World");
        String helloWorld3 = new StringBuilder("Hello World").toString();
        String helloWorld4 = "Hello World";

        System.out.println(hello.equals(helloWorld1)); // false
        System.out.println(helloWorld1.equals(helloWorld2)); // true
        System.out.println(helloWorld3.equals(helloWorld1)); //true
        System.out.println(helloWorld1 == helloWorld2); // false
        System.out.println(helloWorld3 == helloWorld2); //false
        System.out.println(helloWorld1 == helloWorld4); // true
    }
}
