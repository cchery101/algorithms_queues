
import java.util.Iterator;

public class Subset {
    public static void main(String[] args)
    {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randqueue = new RandomizedQueue<String>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            randqueue.enqueue(s);
        }
        Iterator<String> iterator = randqueue.iterator();
        for (int i = 0; i < k; i++)
            System.out.println(iterator.next());
    }
}
