
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
        if (item == null) throw new NullPointerException();
        if (numelements == data.length) resize(data.length * 2);
        data[numelements] = item;
        numelements += 1;
    }
    // delete and return a random item
    public Item dequeue()
    {
        if (numelements == 0) throw new java.util.NoSuchElementException();
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
        if (numelements == 0) throw new java.util.NoSuchElementException();
        return (Item)data[StdRandom.uniform(numelements)];
    }
    // return an independent iterator over items in random order
    public Iterator<Item> iterator()
        { return new RandomizedQueueIterator(); }
    private class RandomizedQueueIterator implements Iterator<Item>
    {
        int current = 0;
        int[] iterorder = new int[numelements];
        public RandomizedQueueIterator()
        {
            for (int i = 0; i < numelements; i++) iterorder[i] = i;
            StdRandom.shuffle(iterorder, 0, numelements - 1);
        }
        public boolean hasNext()    { return current < numelements; }
        public void remove()        { throw new UnsupportedOperationException(); }
        public Item next()
        {
            if (current >= numelements) throw new java.util.NoSuchElementException();
            Item item = (Item)data[iterorder[current]];
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
        System.out.println("********** Testing ForEach Iterator **********");
        for (Integer value: randqueue) System.out.println(value);
        // testing iterator
        System.out.println("********** Testing Parralel Iterators **********");
        Iterator<Integer> iterator1 = randqueue.iterator();
        Iterator<Integer> iterator2 = randqueue.iterator();
        while (iterator1.hasNext())
            System.out.println(String.format("%1$d %2$d", iterator1.next(), iterator2.next()));

    }
}