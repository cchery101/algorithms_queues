public class WrapTest {
// add this to resizing array queue to avoid re-running array: can still use start and end in exactly the same way??
    private static int wrapincrement(int i, int start, int end, int length) {
        if (start > end && i >= start) {
            if (i < length) return i+1;
            else            return 0;
        }
        else {
            if (i <= length) return i+1;
            else            return 0;
        }
    }

    private static boolean wrapend(int i, int start, int end) {
        if (start > end && i >= start) return true;
        else                           return i <= end;
    }

    public static void main(String[] args) {
        int start = Integer.parseInt(args[0]);
        int end = Integer.parseInt(args[1]);
        int length = Integer.parseInt(args[2]);
        for (int i = start; wrapend(i, start, end); i = wrapincrement(i, start, end, length))
            { System.out.println(i); }
        //System.out.println(wrapincrement(5, 10));
    }
}