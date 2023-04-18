package org.example_test.task8;

import org.example.task2.Main;
import org.example.task2.Range;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2Test {
    Main main = new Main();

    @Test
    public void testTask2(){
        Range range = new Range(3, 10);
        int n = 4;

        int[] e = main.t2(n, range);
        int[] result = new int[]{ 3,4,5,6 };

        Assert.assertEquals(e, result);
    }
}
