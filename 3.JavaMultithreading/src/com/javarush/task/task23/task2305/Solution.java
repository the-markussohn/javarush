package com.javarush.task.task23.task2305;

/* 
Inner
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solutionOne = new Solution();
        Solution solutionTwo = new Solution();
        for (int i = 0; i < 2; i++) {
            solutionOne.innerClasses[i] = solutionOne.new InnerClass();
            solutionTwo.innerClasses[i] = solutionTwo.new InnerClass();
        }
        Solution[] twoSolutions = {solutionOne, solutionTwo};
        return twoSolutions;
    }

    public static void main(String[] args) {

    }
}
