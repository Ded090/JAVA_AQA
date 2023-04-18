package org.example.task2;

public class Range
{
    private int low;
    private int high;

    public Range(int low, int high){
        this.low = low;
        this.high = high;
    }

    public boolean contains(int number){
        return (number >= low && number <= high);
    }


    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
