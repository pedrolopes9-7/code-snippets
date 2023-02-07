package com.linkedin.codesnippets.operators;

import java.util.List;

/*@author: pedrolopesdev at 2023-02-07
 https://www.linkedin.com/in/pedro-lopes-dev//
 https://twitter.com/pedro_lopes3
 https://pedrolopesdev.com */
public class ShortCircuitOperatorExample {

    /*
        What's the output of the following program?
        A) NullPointerException at line //1
        B) Printing output...
        C) IndexOutOfBoundsException at line //2
        D) Nothing

        Useful Resources:
        https://pedrolopesdev.com/post/short-circuit-operators-in-java/
     */

    public static void main(String[] args) {
        List<Integer> myList = null;

        if (isEven(10) || myList.get(0) == 2) { //1
            myList = List.of(2, 3);
        }
        if (myList.contains(4) && isEven(myList.get(6))) { //2
            System.out.println("Printing output...");
        }
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }

    /*
        Explanation:
        The answer is nothing.

        The call to `isEven(10)` evaluates to true, so the OR (||) operator short-circuits the expression and skip evaluating `myList.get(0) == 2`.
        Therefore, the whole if is true and no exception is thrown at //1.

        The call to `myList.contains(4)` is false, so the AND (&&) operator short-circuits the expression and skip the call to `isEven(myList.get(6))`.
        Therefore, the whole if is false and no exception is thrown at //2.
     */
}
