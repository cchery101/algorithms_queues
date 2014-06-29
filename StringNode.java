
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
        StringNode mynode = new StringNode(args[0], null);
        System.out.println(mynode.getdata());
    }
}