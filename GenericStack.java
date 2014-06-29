
public class GenericStack<Item>
{
    private Node<Item> first;

    public Item pop()
    {
        if (first == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        Item firstval = first.item;
        first = first.next;
        return firstval;
    }

    public void push(Item s)
    {
        Node<Item> newfirst = new Node<Item>();
        newfirst.item = s;
        newfirst.next = first;
        first = newfirst;
    }

    public static void main(String[] args)
    {
        GenericStack<String> stack = new GenericStack<String>();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            //StdOut.print(s);
            if (s.equals("-"))  System.out.println(stack.pop());
            else                stack.push(s);
        }
    }

    private class Node<Item>
    {
        Item item;
        Node<Item> next;
    }
}

