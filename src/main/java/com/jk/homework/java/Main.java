package com.jk.homework.java;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array1 = new int[1000];
        int[] array2 = new int[1000];
        Random random = new Random();

        // Fill arrays with random integers
        for (int i = 0; i < 1000; i++) {
            array1[i] = random.nextInt(1000) + 1;
            array2[i] = random.nextInt(1000) + 1;
        }

        int targetSum = 1500;

        // Measure execution time for the original method
        long startTime = System.nanoTime();
        boolean originalResult = NumberPairChecker.hasPairWithSumOriginal(array1, array2, targetSum);
        long endTime = System.nanoTime();
        System.out.println("Original Method Result: " + originalResult +
                ", Time: " + (endTime - startTime) + " ns");

        // Measure execution time for the variable method
        startTime = System.nanoTime();
        boolean variabledResult = NumberPairChecker.variableOptimization(array1, array2, targetSum);
        endTime = System.nanoTime();
        System.out.println("Variable Method Result: " + variabledResult +
                ", Time: " + (endTime - startTime) + " ns");

        // Measure execution time for the parallel optimized method
        startTime = System.nanoTime();
        boolean parallelResult = NumberPairChecker.parallelOptimization(array1, array2, targetSum);
        endTime = System.nanoTime();
        System.out.println("Parallel Optimized Method Result: " + parallelResult +
                ", Time: " + (endTime - startTime) + " ns");
    }
}