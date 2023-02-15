package com.linkedin.codesnippets.concurrency;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

/*@author: pedrolopesdev at 2023-02-15
 https://www.linkedin.com/in/pedro-lopes-dev//
 https://twitter.com/pedro_lopes3
 https://pedrolopesdev.com */

/*
        What's true about the following program?
        A) All lines always print 100
        B) Line 2 and 4 always print 100
        C) Line 2 always print 100
        D) None of the above

        More Resources:
        https://pedrolopesdev.com/post/deadlock-livelock-starvation-in-java/
        https://pedrolopesdev.com/post/create-thread-runnable-in-java/
     */
public class ThreadConcurrentVariableModification {

    static long value1 = 10;

    public static void main(String args[]) {
        var value2 = new AtomicLong(0);
        final long[] value3 = {0};
        final long[] value4 = {0};
        IntStream.range(1, 100).parallel().forEach(a -> value1++);
        System.out.println(value1);//1
        IntStream.range(1, 100).parallel().forEach(a -> value2.incrementAndGet());
        System.out.println(value2);//2
        IntStream.range(1, 100).parallel().forEach(a -> value3[0]++);
        System.out.println(value3[0]);//3
        IntStream.range(1, 100).parallel().forEach(a -> value4[0] = incrementAndGet(value4[0]));
        System.out.println(value4[0]);//4
    }

    private static synchronized Long incrementAndGet(Long number) {
        return ++number;
    }
}

/*
The answer is None of the above.
Explanation:
Line 1 modifies the value of a global static variable in a parallel stream. Static variables are not atomic,
    so we can't guarantee that the numbers are incremented in the correct order. Thus, we can expect any result.
Line 2 modifies an AtomicLong variable which implements atomicity. Thus, the program increments the value2 variable in the same
    order as the stream. However, the code has a "gotcha" since the stream uses the .range method, not .rangeClosed.
    Therefore, the stream stops at 99, and value2 always equals 99 at the end of the program.
Line 3 modifies the value of a non-atomic local variable. Thus, again, any result is expected here.
Line 4 uses a synchronized method to increment the variable value4. The synchronized keyword means that only one
    thread can execute the method at a given time. However, that doesn't mean the threads will
    atomically read and increment the variable value4. Thus, any result is expected here too.
 */
