public class WrapTest {
// add this to resizing array queue to avoid re-running array: can still use start and end in exactly the same way??
    private static int wrapincrement(int i, int start, int end, int length) {
        if (i < length - 1)  return i + 1;
        else if (i < length && end == length - 1) return i+1;
        else            return 0;
    }

    private static boolean wrapend(int i, int start, int end, int length) {
        if (start > end && i >= start)  return true;
        else                            return i <= end;
    }

    private static void printsequence(int start, int end, int length) {
        for (int i = start; wrapend(i, start, end, length);
                i = wrapincrement(i, start, end, length))
            { System.out.print(String.format("%d, ", i)); }
        System.out.println("");
    }

    public static void main(String[] args) {
        // test cases
        // normal interior
        System.out.print("Interior    [3, 4, 5, 6, 7]:                     ");
        printsequence(3, 7, 10);
        // wrap around
        System.out.print("Wrap        [7, 8, 9, 0, 1, 2, 3]:               ");
        printsequence(7, 3, 10);
        // edge case 0
        System.out.print("Edge Start  [0, 1, 2, 3, 4, 5]:                  ");
        printsequence(0, 5, 10);
        // edge case N - 1
        System.out.print("Edge End    [5, 6, 7, 8, 9]:                     ");
        printsequence(5, 9, 10);
        // full sequence
        System.out.print("Full        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]:      ");
        printsequence(0, 9, 10);
        // full sequence
        System.out.print("Full Wrap   [5, 6, 7, 8, 9, 0, 1, 2, 3]:         ");
        printsequence(5, 3, 10);
        // single element
        System.out.print("Single      [9]:                                 ");
        printsequence(9, 9, 10);
        // single wrap
        System.out.print("Wrap to 0   [9, 0]:                              ");
        printsequence(9, 0, 10);
    }
}
