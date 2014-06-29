
public class QueueOfStrings
{
    private Node first;
    private Node last;

    public String dequeue()
    {
        if (first == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        String firstval = first.item;
        // check if this is the last item
        if (first.next == null) { first = null; last = null; }
        else                      first = first.next;
        return firstval;
    }

    public void enqueue(String s)
    {
        Node newlast = new Node();
        newlast.item = s;
        newlast.next = null;
        if (first == null) first = newlast;
        else               last.next = newlast;
        last = newlast;
    }

    public static void main(String[] args)
    {
        QueueOfStrings queue = new QueueOfStrings();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            //StdOut.print(s);
            if (s.equals("-"))  System.out.println(queue.dequeue());
            else                queue.enqueue(s);
        }
    }

    private class Node
    {
        String item;
        Node next;
    }
}
