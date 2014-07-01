
import java.util.Arrays;

public class GenericQueueArrayResize<Item>
{
    private int first;
    private int numelements;
    private Object[] data;

    public GenericQueueArrayResize()
    {
        data = new Object[1];
        first = 0;
        numelements = 0;
    }

    private void resize(int newsize)
    {
        System.out.println(String.format("Resizing array to %d", newsize));
        // resize the array
        Object[] newdata = new Object[newsize];
        for (int i = 0; i < numelements; i++)
        {
            newdata[i] = data[(first + i) % data.length];
            data[i] = null;   // is this necessary?
        }
        first = 0;
        data = newdata;  // or does this make all of data go out of scope?
    }

    public Item dequeue()
    {
        if (numelements == 0)
            { throw new java.lang.IndexOutOfBoundsException(); }
        Item firstval = (Item)data[first];
        data[first] = null;
        numelements -= 1;
        // check if this is the last item
        if (numelements == 0) first = 0;
        else
        {
            first = (first + 1) % data.length;
            if (numelements <= data.length / 4) resize(data.length / 2);
        }
        return firstval;
    }

    public void enqueue(Item s)
    {
        // check if array is full
        if (numelements >= data.length) resize(data.length * 2);
        data[(first + numelements) % data.length] = s;
        numelements += 1;
    }

    public static void main(String[] args)
    {
        GenericQueueArrayResize<Integer> queue = new GenericQueueArrayResize<Integer>();
        System.out.println(Arrays.toString(queue.data));
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            //StdOut.print(s);
            if (s.equals("-"))  queue.dequeue();
            else                queue.enqueue(Integer.parseInt(s));
            System.out.println(Arrays.toString(queue.data));
            System.out.println(String.format(
                "First: %1$d    NumElements: %2$d   ArrayLength: %3$d",
                queue.first, queue.numelements, queue.data.length));
        }
    }
}
