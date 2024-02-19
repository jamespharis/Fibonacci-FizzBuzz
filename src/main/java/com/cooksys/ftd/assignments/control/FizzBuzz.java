package com.cooksys.ftd.assignments.control;

import java.util.Arrays;

/**
 * FizzBuzz is an old programming exercise.
 * The goal is to iterate over a range of numbers and print a message about each number's divisibility.
 * <p>
 * The message is generated the following way:
 * *) if the number is divisible by three, the message is `Fizz`
 * *) if the number is divisible by five, the message is `Buzz`
 * *) if the number is divisible by both three and five, the message is `FizzBuzz`
 * *) otherwise, no message is produced
 * <p>
 * The exact message format for this assignment is specified in the `message(n)` method.
 */
public class FizzBuzz {

    /**
     * Checks whether a given int `a` is evenly divisible by a given int `b` or not.
     * For example, `divides(4, 2)` returns `true` and `divides(4, 3)` returns `false`.
     *
     * @param a the number to be divided
     * @param b the number to divide by
     * @return `true` if a is evenly divisible by b, `false` otherwise
     * @throws IllegalArgumentException if b is zero
     */
    public static boolean divides(int a, int b) throws IllegalArgumentException {
        if(b==0) { throw new IllegalArgumentException(); }
        else { return a%b == 0; } // this will give us a true or false statement anyway
    }

    /**
     * Generates a divisibility message for a given number. Returns null if the given number is not divisible by 3 or 5.
     * Message formatting examples:
     * 1 -> null // not divisible by 3 or 5
     * 3 -> "3: Fizz" // divisible by only 3
     * 5 -> "5: Buzz" // divisible by only 5
     * 15 -> "15: FizzBuzz" // divisible by both three and five
     *
     * @param n the number to generate a message for
     * @return a message according to the format above, or null if n is not divisible by either 3 or 5
     */
    public static String message(int n) {
    	String out = n + ": ";
    	if (divides(n,3) == true) { out += "Fizz"; } // adds 'Fizz' to out if divisible by 3
    	if (divides(n,5) == true) { out += "Buzz"; } // adds 'Buzz' to out if divisible by 5
    	if (out.equals(n + ": ")) { return null; } // if 'out' is the same as when it was initialized, return null
    	return out;
    }
//    	String out = "";
//    	if (divides(n,3) == false && divides(n,5) == false) { return null; }
//    	else if (divides(n,3) == true && divides(n,5) == true) { out = n+": FizzBuzz"; }
//    	else if (divides(n,3) == true) { out =  n+": Fizz"; }
//    	else if (divides(n,5) == true) { out =  n+": Buzz"; }
//    	return out;


    /**
     * Generates an array of messages to print for a given range of numbers.
     * If there is no message for an individual number (i.e., `message(n)` returns null),
     * it should be excluded from the resulting array.
     *
     * @param start the number to start with (inclusive)
     * @param end the number to end with (exclusive)
     * @return an array of divisibility messages
     * @throws IllegalArgumentException if the given end is less than the given start
     */
    public static String[] messages(int start, int end) throws IllegalArgumentException {
    	if(end<start) { throw new IllegalArgumentException(); }
    	// because it is exclusive, we can't include numbers that do not have a message
    	String[] result = new String[0];
    	for (int i = start; i < end; i++) {
    		if (message(i) != null) {
    			result = Arrays.copyOf(result, result.length+1); // copy old array, make it one size larger
    			result[result.length - 1] = message(i); // add the new value to our array
    		}
    	}
    	return result;
    }
//        int duration = end - start;
//        String[] temp = new String[duration];
//        int j = 0;
//        for(int i=0; i<duration; i++) {
//        	if(message(start) == null) { start++; }
//        	else {
//        		temp[j] = message(start);
//        		j++;
//        		start++;
//        	}
//        }
//        String[] printing = new String[j];
//        for(int i = 0; i < j; i++) {
//        	printing[i] = temp[i];
//        }
//        return printing;

    //For this main method, iterate over the numbers 1 through 115 and print the relevant messages to sysout
    public static void main(String[] args) {
    	for (String msg : messages(1, 116)) { // for each String 'msg' in the 'result' String array of the messages method, passing in 1-116 
    		System.out.println(msg); // for each message I get out of the above Loop, print the RELEVANT message to the console
    	}
//        for(int i=1; i<=115; i++)	{ System.out.println(message(i)); } // to get all messages, even null
    }
}
