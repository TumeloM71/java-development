package com.pluralsight;

import java.util.Arrays;

public class TestStatistics {

    public static void main(String[] args) {
        int[] testScores = new int[10];
        for(int i=0;i< testScores.length;i++){
            testScores[i] = (int)(Math.random()*100);
        }
        Arrays.sort(testScores);
        System.out.println(Arrays.toString(testScores));
        System.out.println();
        int avg = getAverage(testScores);
        int highest = testScores[testScores.length-1];
        int lowest = testScores[0];
        int median = getMedian(testScores);
        System.out.printf("Average: %d  Lowest: %d  Highest: %d Median: %d",avg,lowest,highest,median);

    }


    public static int getAverage(int[] scores){
        int sum = 0;
        for (int n : scores){
            sum+=n;
        }
        return sum/scores.length;
    }

    //Median of an even set is the mean of the two middle values
    public static int getMedian(int[] scores){
        int midValueOne = scores[scores.length/2];
        int midValueTwo = scores[scores.length/2-1];
        return (midValueOne+midValueTwo)/2 ;
    }
}
