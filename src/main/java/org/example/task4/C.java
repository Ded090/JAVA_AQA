package org.example.task4;

import java.util.Arrays;

public class C {
//    Create a generic method that takes an array of elements of any type, and prints them out using T[] and forEach().

    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] floatArray = {1.01, 2.02, 3.03, 4.04, 5.05};

        printArray(intArray);
        printArray(floatArray);
    }

    public static <T> void printArray(T[] array) {
        Arrays.stream(array).forEach(System.out::println);
    }
}
