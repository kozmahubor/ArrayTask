package com.jk.homework.java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class NumberPairChecker {

    // Original method with two loops
    public static boolean hasPairWithSumOriginal(int[] array1, int[] array2, int targetSum) {
        for (int num1 : array1) {
            for (int num2 : array2) {
                if (num1 + num2 == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }

    // Variable method using a c-a = b method
    public static boolean variableOptimization(int[] array1, int[] array2, int targetSum) {
        for (int num : array1) {
            if (Arrays.stream(array2).anyMatch(sum -> sum == (targetSum - num))) {
                return true;
            }
        }
        return false;
    }

    // Parallel optimized method using Java streams
    public static boolean parallelOptimization(int[] array1, int[] array2, int targetSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : array2) {
            set.add(num);
        }
        return IntStream.of(array1).parallel().anyMatch(num -> set.contains(targetSum - num));
    }
}