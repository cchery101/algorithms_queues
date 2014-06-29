
import java.util.Arrays;

public class GenericQueueArrayResize
{
    private Integer first;
    private Integer last;
    private Integer[] data;

    public GenericQueueArrayResize()
        { data = new Integer[1]; }

    private void resize(int newsize)
    {
        System.out.println(String.format("Resizing array to %d", newsize));
        // resize the array
        Integer[] newdata = new Integer[newsize];
        for (int i = first; i <= last; i++)
        {
            newdata[i - first] = data[i];
            data[i] = null;
        }
        data = newdata;
        last = last - first;
        first = 0;
    }

    public Integer dequeue()
    {
        if (first == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        int firstval = data[first];
        data[first] = null;
        // check if this is the last item
        if (first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first + 1;
            if (last - first < data.length / 4) resize(data.length / 4);
        }
        return firstval;
    }

    public void enqueue(Integer s)
    {
        // check if array is currently empty: create one element
        if (first == null)
        {
            first = 0;
            last = 0;
        }
        else
        {
            // check if array end has been reached (array may need resizing)
            if (last == data.length - 1)
            {
                if (last - first >= data.length - 1) resize(data.length * 2);
                else                                 resize(data.length);
                // could use wrapping to avoid resize to same size??
            }
            last = last + 1;
        }
        data[last] = s;
    }

    public static void main(String[] args)
    {
        GenericQueueArrayResize queue = new GenericQueueArrayResize();
        System.out.println(Arrays.toString(queue.data));
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            //StdOut.print(s);
            if (s.equals("-"))  queue.dequeue();
            else                queue.enqueue(Integer.parseInt(s));
            System.out.println(Arrays.toString(queue.data));
            System.out.println(String.format("First:%d Last:%d", queue.first, queue.last));
        }
    }
}
