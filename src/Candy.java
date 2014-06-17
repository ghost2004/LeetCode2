/*
 * There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?
 */
public class Candy {
    public int candy(int[] ratings) {
        
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        if (ratings.length == 1)
            return 1;
        int length  = ratings.length;
        int leftS[] = new int[length];
        
        leftS[0] = 1;
        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i-1]) {
                leftS[i] = leftS[i-1]+1;
            } else {
                leftS[i] = 1;
            }
        }
        
        int right = 1;
        int minC = Math.max(right, leftS[length-1]);
        for (int i = length-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                right += 1;
            } else {
                right = 1;  
            }
            
            minC += Math.max(right, leftS[i]);
        }
        
        
        return minC;
    }
}
