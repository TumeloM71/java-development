package com.pluralsight;

/*
Step 1
You will program the application will roll a pair of dice 20 times. Display the
value of the two dice each time they are rolled. Count how many times the
numbers 2, 4, 6 and 7 are rolled and display the result.
To make this work, you need to create a class named Dice and add a method
named roll() that generates a random number between 1 and 6. You can
generate a random number within a range using the following algorithm:
int randomNumber = (int)(Math.random() * maxValue) + minValue;
Now switch back to your main() function:
1. Create an instance of Dice named dice. Also create integer variables for
roll1, roll2, and four different counters for the number of times 2, 4, 6
and 7 are rolled
2. Create a loop that executes 100 times.
3. Within the loop, call your dice's roll() method two times:
roll1 = dice.roll();
roll2 = dice.roll();
4. Print the value of each roll of the dice formatted like this:
Roll 1: 4 - 6 Sum: 10
5. Determine if the sum of roll1 and roll2 is 2, and if so increment the
twoCounter.
6. Determine if the sum of roll1 and roll2 is 4, and if so increment the
fourCounter.
7. Determine if the sum of roll1 and roll2 is 6, and if so increment the
sixCounter.
8. Determine if the sum of roll1 and roll2 is 7, and if so increment the
sevenCounter.
9. When the loop terminates, display your counters!

 */
public class RollTheDice {

    public static void main(String[] args) {
        int twoCount =0,fourCount=0,sixCount=0,sevenCount=0;
        int roll1,roll2;

        for (int i = 1;i<=100;i++){
            roll1 = Dice.roll();
            roll2 = Dice.roll();
            switch (roll1+roll2) {
                case 2:
                    twoCount++;
                case 4:
                    fourCount++;
                case 6:
                    sixCount++;
                case 7:
                    sevenCount++;
            }
            System.out.printf("Roll %d: %d - %d Sum: %d \n",i,roll1,roll2,roll1+roll2);

        }
        System.out.println("Two count: "+twoCount);
        System.out.println("Four count: "+fourCount);
        System.out.println("Six count: "+sixCount);
        System.out.println("Seven count: "+sevenCount);
    }
}
