
public class StackOfStrings
{
    private Node first;

    public String pop()
    {
        if (first == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        String firstval = first.item;
        first = first.next;
        return firstval;
    }

    public void push(String s)
    {
        Node newfirst = new Node();
        newfirst.item = s;
        newfirst.next = first;
        first = newfirst;
    }

    public static void main(String[] args)
    {
        StackOfStrings stack = new StackOfStrings();
        while (!StdIn.isEmpty())
        {
            String s = StdIn.readString();
            //StdOut.print(s);
            if (s.equals("-"))  System.out.println(stack.pop());
            else                stack.push(s);
        }
    }

    private class Node
    {
        String item;
        Node next;
    }
}

