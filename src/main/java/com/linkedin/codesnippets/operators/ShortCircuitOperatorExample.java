package com.linkedin.codesnippets.operators;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*@author: pedrolopesdev at 2023-02-10
 https://www.linkedin.com/in/pedro-lopes-dev//
 https://twitter.com/pedro_lopes3
 https://pedrolopesdev.com */

/*
        What's the output of the following program?
        A) NullPointerException at 1
        B) First number: 2
        C) IndexOutOfBoundsException at 2
        D) NullPointerException at 3

        Useful Resources:
        https://pedrolopesdev.com/post/short-circuit-operators-in-java/
     */
public class ShortCircuitOperatorExample {
    public static void main(String[] args) throws IOException {

        Path path = Paths.get("ShortCircuitOperatorExample.java");
        try (BufferedReader reader = Files.newBufferedReader(path)) {
        }
        List<Integer> myList = null;

        if (isEven(10) || myList.get(0) == 2 || myList.get(1) == 4) { //1
            myList = List.of(2, 3);
        }

        if (isEven(myList.get(0)) && myList.contains(4) && isEven(myList.get(3))) { //2
            myList = null;
        }

        System.out.println("First number: " + myList.get(0)); //3.
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
    /*
        Explanation:
        The program doesn't throw any exception and prints out `First Number: 2`.

        The answer is to understand that logical OR (||) short circuits when `true`, whereas logical AND (&&) short circuits when `false`

        First `if` statement:
            - The call to `isEven(10)` evaluates to true, making the whole first logical OR (||)
                expression true, skipping the call to `myList.get(0) == 2`.
            - There's another OR, so it'll also skip the call to `myList.get(1) == 4`. Therefore, the first statement
                is TRUE, and `myList` is initialized with `List.of(2,3)`.

        Second `if` statement:
            The opposite of logical OR (||) occurs with logical AND (&&). We skip the next operands of the conditional
                if the first is `false`, making the entire expression false.
            - `isEven(myList.get(1))` is false, thus `( isEven(myList.get(1)) && myList.contains(3) )` is also false.
            - Same thing for the second logical AND. The previous result is false, so it skips the call to `isEven(myList.get(3)).
     */

