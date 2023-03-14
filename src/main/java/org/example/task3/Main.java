package org.example.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array 1: ");
        int size_first = sc.nextInt();

        System.out.print("Enter the elements of array 1: ");
        int[] arr_first = new int[size_first];
        for (int i = 0; i < size_first; i++) {
            arr_first[i] = sc.nextInt();
        }

        System.out.print("Enter the size of array 2: ");
        int size_second = sc.nextInt();

        System.out.print("Enter the elements of array 2: ");
        int[] arr_second = new int[size_second];
        for (int i = 0; i < size_second; i++) {
            arr_second[i] = sc.nextInt();
        }

        List<Integer> intersection = new ArrayList<>();
        for (int i = 0; i < size_first; i++) {
            for (int j = 0; j < size_second; j++) {
                if (arr_first[i] == arr_second[j]) {
                    intersection.add(arr_first[i]);
                    break;
                }
            }
        }

        System.out.print("Intersection of the two arrays: ");
        for (int i : intersection) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.print("Input value what you want add: ");
        int add = sc.nextInt();
        intersection.add(add);
        System.out.println(intersection);

        System.out.print("Input value what you want remove: ");
        int remove = sc.nextInt();
        intersection.remove(intersection.indexOf(remove));
        System.out.println(intersection);

        System.out.print("Input value to be changed: ");
        int what = sc.nextInt();
        int where = intersection.indexOf(what);
        System.out.print("Input value to be set: ");
        int set = sc.nextInt();
        intersection.set(where, set);

        System.out.print("Array before sort: ");
        System.out.println(intersection);

        Collections.sort(intersection);

        System.out.print("Array after sort: ");
        System.out.println(intersection);
    }
}
