public class RandomizedQueue<Item> implements Iterable<Item> {
   public RandomizedQueue()                 // construct an empty randomized queue
   public boolean isEmpty()                 // is the queue empty?
   public int size()                        // return the number of items on the queue
   private void resize(int newsize)         // resize array as needed
   public void enqueue(Item item)           // add the item
   // enqueue: insert before first if possible, otherwise after end + resize as needed
   public Item dequeue()                    // delete and return a random item
   // dequeue: return random item between first and last, move last element into its place - does this create bias?
   public Item sample()                     // return (but do not delete) a random item
   // sample: randomise index between first and last
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   // iterators used the same as python - is this an iterator that just calls sample?
   public static void main(String[] args)   // unit testing
}