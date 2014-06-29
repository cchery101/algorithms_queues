
public class StackOfStrings
{
    private StringNode firstnode;

    public StackOfStrings()
        { firstnode = null; }

    public String pop()
    {
        if (firstnode == null)
            { throw new java.lang.IndexOutOfBoundsException(); }
        String popitem = firstnode.getdata();
        firstnode = firstnode.getnext();
        return popitem;
    }

    public void push(String s)
        { firstnode = new StringNode(s, firstnode); }

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
}

