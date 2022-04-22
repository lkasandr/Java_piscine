package ex02;

public class CalculateSum extends Thread{
    private int first;
    private int last;
    private int[] array;
    private int index;
    private int sum;

    CalculateSum(int index, int first, int last, int[] array)
    {
        this.first = first;
        this.last = last;
        this.array = array;
        this.index = index;
        setSum();
    }

    private void setSum()
    {
        int begin = first;
        while(begin != last + 1)
        {
            this.sum += this.array[begin];
            begin++;
        }
    }

    public int getSum()
    {
        return this.sum;
    }

    public void run()
    {
        System.out.println("Thread " + index + ": from " + first + " to " + last + " sum is " + sum);
    }
}
