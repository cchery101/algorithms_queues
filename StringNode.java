
public class StringNode
{
    private String data;
    private StringNode nextnode;

    public StringNode(String inputdata, StringNode inputnext)
    {
        data = inputdata;
        nextnode = inputnext;
    }

    public StringNode getnext()
        { return nextnode; }

    public String getdata()
        { return data; }

    public static void main(String[] args)
    {
        StringNode lastnode = new StringNode("End", null);
        StringNode firstnode = new StringNode("Start", lastnode);
        StdOut.print(firstnode.getdata());
        StdOut.print(firstnode.getnext().getdata());
    }
}