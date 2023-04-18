package org.example_test.task8;

import org.example.task2.Main;
import org.example.task2.Range;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTask2Test {
    Main main = new Main();

    @DataProvider
    private Object[][] task2DataProvider(){
        int n = 5;
        int m = 2;
        Object[][] res = new Object[n][m];

        res[0] = new Object[]{1, new Range(3,9), new int[] {3}};
        res[1] = new Object[]{2, new Range(3,9), new int[] {3,4}};
        res[2] = new Object[]{2, new Range(5,9), new int[] {5,6}};
        res[3] = new Object[]{4, new Range(1,9), new int[] {1,2,3,4}};
        res[4] = new Object[]{3, new Range(1,2), new int[] {1,2,0}};

        return res;
    }

    @Test(dataProvider = "task2DataProvider")
    public void task2Test(int a, Range b, int[] expected) throws Exception {
        int[] actual = main.t2(a,b);

        Assert.assertEquals(actual, expected);
    }
}
