
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item>
{
    private Node<Item> first;
    private Node<Item> last;
    // construct an empty deque
    public Deque()
    {

    }
    // is the deque empty?
    public boolean isEmpty()
        { return first == null; }
    // return the number of items on the deque
    public int size()
    {
        if (first == null) return 0;
        int itemcount = 1;
        Node<Item> current = first;
        while (current.next != null)
        {
            current = current.next;
            itemcount++;
        }
        return itemcount;
    }
    // insert the item at the front
    public void addFirst(Item item)
    {
        if (item == null) throw new NullPointerException();
        Node<Item> newnode = new Node<Item>();
        newnode.item = item;
        newnode.next = first;
        newnode.prev = null;
        if (first != null)  first.prev = newnode;
        first = newnode;
        if (last == null)   last = newnode;
    }
    // insert the item at the end
    public void addLast(Item item)
    {
        if (item == null) throw new NullPointerException();
        Node<Item> newnode = new Node<Item>();
        newnode.item = item;
        newnode.next = null;
        newnode.prev = last;
        if (last != null) last.next = newnode;
        last = newnode;
        if (first == null)  first = newnode;
    }
    // delete and return the item at the front
    public Item removeFirst()
    {
        if (first == null) throw new java.util.NoSuchElementException();
        Item item = first.item;
        first = first.next;
        if (first != null)  first.prev = null;
        else                last = null;
        return item;
    }
    // delete and return the item at the end
    public Item removeLast()
    {
        if (last == null) throw new java.util.NoSuchElementException();
        Item item = last.item;
        last = last.prev;
        if (last != null)   last.next = null;
        else                first = null;
        return item;
    }
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator()
        { return new DequeIterator(); }
    private class DequeIterator implements Iterator<Item>
    {
        private Node<Item> current = first;
        public boolean hasNext()    { return (current != null); }
        public void remove()        { throw new UnsupportedOperationException(); }
        public Item next()
        {
            if (current == null) throw new java.util.NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    // item storage
    private class Node<Item>
    {
        private Item item;
        private Node<Item> next;
        private Node<Item> prev;
    }
    // unit testing
    public static void main(String[] args)
    {
        Deque<Integer> deque = new Deque<Integer>();
        // testing add/remove from start/end
        System.out.println("********** Testing Sequence Start @ First **********");
        for (int i = 1; i <= 5; i++) {
            deque.addFirst(i);
            deque.addLast(-i);
        }
        System.out.println("Expect 5 to -5");
        while (deque.size() > 0)
            System.out.print(String.format("%d ", deque.removeFirst()));
        System.out.println("");
        System.out.println("********** Testing Sequence Start @ Last **********");
        for (int i = 1; i <= 5; i++) {
            deque.addLast(-i);
            deque.addFirst(i);
        }
        System.out.println("Expect -5 to 5");
        while (deque.size() > 0)
            System.out.print(String.format("%d ", deque.removeLast()));
        System.out.println("");
        // testing iterator
        System.out.println("********** Testing ForEach Iterator **********");
        for (int i = 1; i <= 5; i++) {
            deque.addFirst(i);
            deque.addLast(-i);
        }
        System.out.println("Expect 5 to -5");
        for (int value: deque)
            System.out.print(String.format("%d ", value));
        // testing iterator
        System.out.println("");
        System.out.println("********** Testing Parralel Iterators **********");
        Iterator<Integer> iterator1 = deque.iterator();
        Iterator<Integer> iterator2 = deque.iterator();
        while (iterator1.hasNext())
            System.out.println(String.format("%1$d %2$d",
                iterator1.next(), iterator2.next()));
        System.out.println("");
    }
}
