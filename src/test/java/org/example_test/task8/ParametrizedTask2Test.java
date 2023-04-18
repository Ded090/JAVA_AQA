package org.example_test.task8;

import org.example.task2.Main;
import org.example.task2.Range;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizedTask2Test {
    Main main = new Main();

    @Parameters({"n", "low", "high", "expected"})
    @Test
    public void paramTask2Test(int n, int low, int high, String expected){
        Range range = new Range(low, high);
        int[] actual = main.t2(n,range);

        Assert.assertEquals(actual.toString(), expected);
    }
}
