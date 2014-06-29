
public class GenericQueue<Item>
{
    private Node<Item> first;
    private Node<Item> last;

    public Item dequeue()
    {
        if (first == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        Item firstval = first.item;
        // check if this is the last item
        if (first.next == null) { first = null; last = null; }
        else                      first = first.next;
        return firstval;
    }

    public void enqueue(Item s)
    {
        Node<Item> newlast = new Node<Item>();
        newlast.item = s;
        newlast.next = null;
        if (first == null) first = newlast;
        else               last.next = newlast;
        last = newlast;
    }

    public static void main(String[] args)
    {
        GenericQueue<Integer> queue = new GenericQueue<Integer>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            //StdOut.print(s);
            if (s.equals("-"))  System.out.println(queue.dequeue());
            else                queue.enqueue(Integer.parseInt(s));
        }
    }

    private class Node<Item>
    {
        Item item;
        Node<Item> next;
    }
}
