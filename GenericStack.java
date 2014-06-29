
public class GenericStack<T>
{
    private Node<T> first;

    public T pop()
    {
        if (first == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        T firstval = first.item;
        first = first.next;
        return firstval;
    }

    public void push(T s)
    {
        Node<T> newfirst = new Node<T>();
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

    private class Node<T>
    {
        T item;
        Node next;
    }
}

