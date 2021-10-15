package amazon_exercises;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'goodSegment' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY badNumbers
     *  2. INTEGER lower
     *  3. INTEGER upper
     */

    public static int goodSegment(List<Integer> badNumbers, int lower, int upper) 
    {
    // Write your code here
    badNumbers.add(lower);
    badNumbers.add(upper);
    Collections.sort(badNumbers);
    Integer segment = 0; 
    
    if(segment < badNumbers.get(1) - badNumbers.get(0))
    {
        segment = badNumbers.get(1) - badNumbers.get(0);
    }
    
    for(int i = 2; i < badNumbers.indexOf(upper); i++)
    {
        if(segment < (badNumbers.get(i ) - badNumbers.get(i - 1) - 1))
        {
            segment = badNumbers.get(i) - badNumbers.get(i - 1) - 1;
        }
    }
    
     if(segment < (upper - badNumbers.get(badNumbers.indexOf(upper) - 1)))
    {
        segment = (upper - badNumbers.get(badNumbers.indexOf(upper) - 1));
    }
       
    return segment;

    }

}

public class Q1
{
	
}