public class WrapTest {
// add this to resizing array queue to avoid re-running array: can still use start and end in exactly the same way??
    private static void printsequence(int start, int numelements, int arraylength) {
        for (int i = 0; i < numelements; i++)
        {
            System.out.print(String.format("%d, ", (start + i) % arraylength));
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        // test cases
        // normal interior
        System.out.print("Interior    [3, 4, 5, 6, 7]:                     ");
        printsequence(3, 5, 10);
        // wrap around
        System.out.print("Wrap        [7, 8, 9, 0, 1, 2, 3]:               ");
        printsequence(7, 7, 10);
        // edge case 0
        System.out.print("Edge Start  [0, 1, 2, 3, 4, 5]:                  ");
        printsequence(0, 6, 10);
        // edge case N - 1
        System.out.print("Edge End    [5, 6, 7, 8, 9]:                     ");
        printsequence(5, 5, 10);
        // full sequence
        System.out.print("Full        [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]:      ");
        printsequence(0, 10, 10);
        // full sequence
        System.out.print("Full Wrap   [5, 6, 7, 8, 9, 0, 1, 2, 3, 4]:      ");
        printsequence(5, 10, 10);
        // single element
        System.out.print("Single      [9]:                                 ");
        printsequence(9, 1, 10);
        // single wrap
        System.out.print("Wrap to 0   [9, 0]:                              ");
        printsequence(9, 2, 10);
    }
}
