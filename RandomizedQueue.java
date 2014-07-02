
import java.util.Arrays;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int numelements;
    private Object[] data;

    // construct an empty randomized queue
    public RandomizedQueue()
    {
        numelements = 0;
        data = new Object[1];
    }
    // is the queue empty?
    public boolean isEmpty()
        { return numelements == 0; }
    // return the number of items on the queue
    public int size()
        { return numelements; }
    // resize array as needed
    private void resize(int newsize)
    {
        Object newdata[] = new Object[newsize];
        for (int i = 0; i < numelements; i++)
        {
            newdata[i] = data[i];
            data[i] = null;
        }
        data = newdata;
    }
    // add the item
    public void enqueue(Item item)
    {
        if (numelements == data.length) resize(data.length * 2);
        data[numelements] = item;
        numelements += 1;
    }
    // delete and return a random item
    public Item dequeue()
    {
        if (numelements == 0)
            { throw new java.lang.IndexOutOfBoundsException(); }
        int idx = StdRandom.uniform(numelements);
        Item randval = (Item)data[idx];
        data[idx] = data[numelements - 1];
        data[numelements - 1] = null;
        numelements -= 1;
        return randval;
    }
    // return (but do not delete) a random item
    public Item sample()
    {
        if (numelements == 0)
            { throw new java.lang.IndexOutOfBoundsException(); }
        return (Item)data[StdRandom.uniform(numelements)];
    }
    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
        { return new RandomizedQueueIterator(); }
    private class RandomizedQueueIterator<Item> implements Iterator<Item>
    {
        int current;
        public RandomizedQueueIterator()
        {
            StdRandom.shuffle(data, 0, numelements - 1);
            current = 0;
        }
        public boolean hasNext()   { return current < numelements; }
        public void remove()    { /* not supported */           }
        public Item next()
        {
            Item item = (Item)data[current];
            current = current + 1;
            return item;
        }
    }
    // unit testing
    public static void main(String[] args)
    {
        RandomizedQueue<Integer> randqueue = new RandomizedQueue<Integer>();
        // testing enqueue-dequeue
        System.out.println("********** Testing Enqueue-Dequeue **********");
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            if (s.equals("-"))  System.out.println(randqueue.dequeue());
            else                randqueue.enqueue(Integer.parseInt(s));
            System.out.println(Arrays.toString(randqueue.data));
        }
        // testing sample
        System.out.println("********** Testing Sampling **********");
        for (int i = 0; i < 10; i++)
        {
            System.out.println(randqueue.sample());
            System.out.println(Arrays.toString(randqueue.data));
        }
        // testing iterator
        System.out.println("********** Testing Iterator **********");
        for (Integer value: randqueue) System.out.println(value);
    }
}