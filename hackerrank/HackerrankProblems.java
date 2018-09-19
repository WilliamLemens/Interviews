import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HackerrankProblems {
  
  public static void main(String args[]) {
//    // hourglassSum()
//    int[][] twodarr = { { -9, -9, -9,  1, 1, 1 },
//                        {  0, -9,  0,  4, 3, 2 },
//                        { -9, -9, -9,  1, 2, 3 },
//                        {  0,  0,  8,  6, 6, 0 },
//                        {  0,  0,  0, -2, 0, 0 },
//                        {  0,  0,  1,  2, 4, 0 } };
//    int[][] twodarr2 = { { 1, 1, 1, 0, 0, 0 },
//                         { 0, 1, 0, 0, 0, 0 },
//                         { 1, 1, 1, 0, 0, 0 },
//                         { 0, 0, 2, 4, 4, 0 },
//                         { 0, 0, 0, 2, 0, 0 },
//                         { 0, 0, 1, 2, 4, 0 } };
//    System.out.println(hourglassSum(twodarr));
//    System.out.println(hourglassSum(twodarr2));
//    // rotLeft()
    int[] arr = { 4, 6, 4, 5, 6, 2 };
//    System.out.println(java.util.Arrays.toString(rotLeft(arr, 1)));
//    System.out.println(java.util.Arrays.toString(rotLeft(arr, 2)));
//    // checkMagazine()
//    String[] sarr1 = { "two", "times", "three", "is", "not", "four" };
//    String[] sarr2 = { "two", "times", "two", "is", "four" };
//    checkMagazine(sarr1, sarr2);
//    // makeAnagram()
//    makeAnagram("fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke");
//    // minimumBribes()
    minimumBribes2(new int[] { 3, 2, 1 });
    minimumBribes2(new int[] { 2, 1, 5, 4, 3 });
//    minBribesShishir(new int[] { 3, 2, 1 });
//    minBribesShishir(new int[] { 2, 1, 5, 3, 4 });
//    // minimumAbsoluteDifference()
//    System.out.println(minimumAbsoluteDifference(new int[] { -59, -36, -13, 1, -53, -92, -2, -96, -54, 75 }));
//    // luckBalance()
//    int[][] lbarr = new int[][] { { 5, 1 }, { 2, 1 }, { 1, 1 }, { 8, 1 }, { 10, 0 }, { 5, 0 } };
//    System.out.println(luckBalance(3, lbarr));
//    // The Coin Change Problem
//    System.out.println(getWays(10,arr));
    // max arr subset
//    System.out.println(candies(arr.length, arr));
    SinglyLinkedList l1 = new SinglyLinkedList();
    l1.insertNode(1);
    l1.insertNode(2);
    l1.insertNode(3);
    SinglyLinkedList l2 = new SinglyLinkedList();
    l2.insertNode(10);
    l2.insertNode(11);
    SinglyLinkedListNode n = new SinglyLinkedListNode(100);
    SinglyLinkedListNode m = new SinglyLinkedListNode(101);
    l1.insertNode(n);
    l2.insertNode(n);
    l1.insertNode(m);
    l2.insertNode(m);
  }

  // +-======================================-+
  // |                                        |
  // |               Algorithms               |
  // |                                        |
  // +-======================================-+

  // ================ WARMUP ================

  public static int solveMeFirst(int a, int b) {
    return a + b;
  }

  public static int simpleArraySum(int[] ar) {
    int out = 0;
    for (int i : ar)
      out += i;
    return out;
  }

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    List<Integer> out = new ArrayList<>();
    int ac = 0, bc = 0;
    for (int i = 0; i < a.size(); i++)
      if (a.get(i) > b.get(i))
        ac++;
      else if (b.get(i) > a.get(i))
        bc++;
    out.add(ac);
    out.add(bc);
    return out;
  }

  /**
   * Sums an array of longs
   * 
   * Java makes this super easy, C we'd need long long
   * 
   * @param ar
   * @return the sum of all elements in ar
   */
  public static long aVeryBigSum(long[] ar) {
    long out = ar[0];
    for (int i = 1; i < ar.length; i++)
      out += ar[i];
    return out;
  }

  // ================ DYNAMIC PROGRAMMING ================
  
  /**
   * 
   * @param n > 0, n < 251
   * @param coins
   * @return
   */
  public static long getWays(int n, int[] coins) {
    long[] ways = new long[n+1];
    ways[0] = 1; // because there's one way to get 0 cents... no coins.
    for (int coin : coins) // for every coin
      for (int i = coin; i <= n; i++) // for each amount the coin will fit in
        ways[i] += ways[i-coin]; // add the number of ways for that amount-the value of the coin
    return ways[n];
  }
  /**
   * Calculates the maximum contiguous subarray sum and the
   * maximum subsequence sum
   * @param arr
   * @return [max subarray sum, max subsequence sum]
   */
  public static int[] maxSubarray(int[] arr) {
    int maxes[] = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE}; // subarray, subsequence
    int current = 0;
    for (int i = 0; i < arr.length; i++) {
      // max subarray
      current += arr[i];
      if (maxes[0] < current) maxes[0] = current;
      if (current < 0) current = 0;
      // max subsequence
      if (maxes[1] < 0 && maxes[1] < arr[i]) maxes[1] = arr[i];
      else if (arr[i] > 0) maxes[1] += arr[i];
    }
    return maxes;
  }
  
  // +-======================================-+
  // |                                        |
  // |      Interview Preparation Kit         |
  // |                                        |
  // +-======================================-+

  // ================ ARRAYS ================

  /**
   * Calculate and return the hourglass sums of arr
   * 
   * a b c d e f g
   * 
   * @param arr
   * @return the max hourglass sum
   */
  public static int hourglassSum(int[][] arr) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length - 2; i++)
      for (int j = 0; j < arr[0].length - 2; j++) {
        int val = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1]
            + arr[i + 2][j + 2];
        if (val > max)
          max = val;
      }
    return max;
  }

  /**
   * ex: rotLeft([1,2,3,4,5],2} -> [3,4,5,1,2]
   * 
   * @param a an array of integers
   * @param d the number of rotations
   * @return
   */
  public static int[] rotLeft(int[] a, int d) {
    int[] out = new int[a.length];
    for (int i = 0; i < out.length; i++)
      out[i] = a[(i + d) % a.length];
    return out;
  }

  /**
   * O(N) but requires moving values in array
   * 
   * @param q
   */
  public static void minimumBribes(int[] q) {
    int i = q.length - 1, count = 0;
    while (i > 0) {
      if (q[i] == i + 1) {
        i--;
        continue;
      } else if (q[i - 1] == i + 1) {
        count++;
        q[i - 1] = q[i];
        q[i] = i + 1;
        i--;
        continue;
      } else if (q[i - 2] == i + 1) {
        count += 2;
        q[i - 2] = q[i - 1];
        q[i - 1] = q[i];
        q[i] = i + 1;
        i--;
        continue;
      } else {
        System.out.println("Too chaotic");
        return;
      }
    }
    System.out.println(count);
  }

  /**
   * Still O(N), Doesn't require any disk manipulation
   * 
   * @param q
   */
  public static void minimumBribes2(int[] q) {
    int count = 0;
    for (int i = q.length - 1; i >= 0; i--) {
      if (q[i] - (i + 1) > 2) { // if it's more than 2 off, it's too far away
        System.out.println("Too chaotic");
        return;
      }
      int val = q[i] - 2;
      for (int j = val > 0 ? val : 0; j < i; j++) // 
        if (q[j] > q[i])
          count++;
    }
    System.out.println(count);
  }
  
//  public static void minBribesShishir(int[] q) {
//    int bribes = 0, offset = 0, ptr = 0;
//    while (ptr < q.length) {
//      if (q[ptr]- ptr != 1) {
//        if (q[ptr] - ptr > 2) System.out.println("Too chaotic");
//        else {
//          offset++;
//          for (int i = 0; i < q[ptr]-ptr; i++) {
//            ptr++;
//            if (q[ptr]-ptr > 2 + offset) System.out.println("Too chaotic");
//          }
//        }
//      }
//    }
//  }

  /**
   * 
   * @param arr
   * @return
   */
  public static int minimumSwaps(int[] arr) {
    // TODO
    return -1;
  }

  // ================ DICTIONARIES & HASHMAPS ================

  /**
   * Checks if each word in note is also in magazine
   */
  public static void checkMagazine(String[] magazine, String[] note) {
    Map<String, Integer> map = new HashMap<>();
    boolean b = true;
    int i = -1;

    for (String s : magazine)
      map.put(s, (map.containsKey(s) ? map.get(s) + 1 : 1));

    while (++i < note.length && b)
      if (!map.containsKey(note[i]))
        b = false;
      else {
        int k = map.get(note[i]) - 1;
        map.put(note[i], k);
        b = k >= 0;
      }

    System.out.println(b ? "Yes" : "No");
  }

  /**
   * Returns "YES" if s1 and s2 share a substring, "NO" otherwise
   * 
   * @return "YES" or "NO"
   */
  public static String twoStrings(String s1, String s2) {
    Set set1 = new HashSet(Arrays.asList(s1.split("")));
    set1.retainAll(new HashSet(Arrays.asList(s2.split(""))));
    return set1.size() > 0 ? "YES" : "NO";
  }

  /**
   * Returns "YES" if s1 and s2 share a substring, "NO" otherwise
   * 
   * @return "YES" or "NO"
   */
  public static String twoStringsOld(String s1, String s2) {
    char[] ca1 = s1.toCharArray();
    char[] ca2 = s2.toCharArray();
    for (char c1 : ca1)
      for (char c2 : ca2)
        if (c1 == c2)
          return "YES";
    return "NO";
  }

  // ================ SORTING ================

  /**
   * Sort a. Print the number of swaps, first element, and last element.
   * 
   * @param a = input array
   */
  public static void countSwaps(int[] a) {
    int count = 0;
    for (int i = 0; i < a.length; i++)
      for (int j = 0; j < a.length - 1; j++)
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
          int temp = a[j];
          a[j] = a[j + 1];
          a[j + 1] = temp;
          count++;
        }
    System.out.println("Array is sorted in " + count + " swaps.");
    System.out.println("First Element: " + a[0]);
    System.out.println("Last Element: " + a[a.length - 1]);
  }

  /**
   * Returns the max number of toys that we can buy with $k. Each toy's price is
   * in prices
   */
  public static int maximumToys(int[] prices, int k) {
    Arrays.sort(prices);
    int count = 0;
    for (int i : prices) {
      k -= i;
      if (k > 0) count++;
      else break;
    }
    return count;
  }

  // ================ STRING MANIPULATION ================

  /**
   * Finds the minimum number of deletions required to turn string a into string b
   */
  public static int makeAnagram(String a, String b) {
    int out = 0,
        freq[] = new int[26];
    for (char c : a.toCharArray()) freq[c-97]++;
    for (char c : b.toCharArray()) freq[c-97]--;
    for (int i : freq) out += Math.abs(i);
    return out;
  }
  /**
   * Finds minimum number of deletions to make a string of 'A's and 'B's alternate
   */
  public static int alternatingCharacters(String s) {
    int[] out = new int[2];
    boolean b = true;
    for (int i = 0; i < 2; i++) { // two cases. first char = 'A' or first char = 'B'
      b = i == 0;
      for (char c : s.toCharArray()) // iterate through and alternate 'A' and 'B'
        if ((b && c == 'A') || (!b && c == 'B')) b = !b;
        else out[i]++;
    }
    return Math.min(out[0], out[1]); // get min deleted chars of the 2 cases
  }

  // ================ GREEDY ALGORITHMS ================

  /**
   * Finds the minimum absolute difference between any two numbers in the array.
   * 
   * @param arr
   * @return minimum absolute difference
   */
  public static int minimumAbsoluteDifference(int[] arr) {
    int min = Integer.MAX_VALUE;
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i++) {
      int val = Math.abs(arr[i - 1] - arr[i]);
      if (val < min)
        min = val;
    }
    return min;
  }

  /**
   * O(NlogN) because of sort
   */
  public static int luckBalance(int k, int[][] contests) {
    int out = 0, important = 0;
    int[] helper = new int[contests.length];
    for (int i = 0; i < contests.length; i++)
      if (contests[i][1] == 0) // unimportant, we can just collect the luck
        out += contests[i][0];
      else { // important, need to track it to see if we have to do it
        helper[i] = contests[i][0];
        important++;
      }

    Arrays.sort(helper);

    int i = helper.length - important, // skips initial 0s if all comps weren't important
        split = helper.length - k; // index where we go from winning to losing
    while (i < split)
      out -= helper[i++]; // subtract luck for comps we must win
    while (i < helper.length)
      out += helper[i++]; // add luck for comps we can lose
    return out;
  }
  // ================ SEARCH ================

  // ================ DYNAMIC PROGRAMMING ================
  /**
   * Finds the maximum sum of non-consecutive integers
   * @param arr
   * @return maximum sum
   */
  public static int maxSubsetSum(int[] arr) {
    arr[0] = Math.max(0, arr[0]);
    arr[1] = Math.max(arr[0], arr[1]);
    for (int i = 2; i < arr.length; i++)
      arr[i] = Math.max(arr[i-1], arr[i]+arr[i-2]);
    return arr[arr.length-1];
  }
  /**
   * Ayn Rand, eat your heart out.
   * Only the best of children get the most candies!
   * Minimize the number of candies each kid gets.
   * @param n number of children
   * @param arr children's rankings
   * @return minimum number of candies needed
   */
  static long candies(int n, int[] arr) {
    if (arr == null || arr.length == 0) return 0;
    long total = 1;
    int prev = 1, countDown = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= arr[i-1]) {
        if (countDown > 0) {
          total += countDown*(countDown+1)/2; // arithmetic progression
          if (countDown >= prev) total += countDown - prev + 1;
          countDown = 0;
          prev = 1;
        }
        prev = arr[i] == arr[i-1] ? 1 : prev+1;
        total += prev;
      } else countDown++;
    }
    if (countDown > 0) { // if we were descending at the end
      total += countDown*(countDown+1)/2;
      if (countDown >= prev) total += countDown - prev + 1;
    }
    return total;
  }

  // ================ TREES ================
  /**
   * Finds the height of a binary tree
   */
  public static int height(Node root) {
    if (root == null) return -1;
    return 1 + Math.max(height(root.left), height(root.right));
  }
  /**
   * Finds the lowest common ancestor of two values in a BST
   * @return the lca node
   */
  public static Node lca(Node root, int v1, int v2) {
    Node curr = root;
    while (curr != null)
      if (curr.data > v1 && curr.data > v2)
        curr = curr.left;
      else if (curr.data < v1 && curr.data < v2)
        curr = curr.right;
      else return curr;
    return null;
  }
  /**
   * Checks if a tree is a BST or not
   * 
   * Problem description gave node data a range of [0,10000]
   */
  public static boolean checkBST(Node root) { return checkBSTHelper(root, 0, 10000); }
  private static boolean checkBSTHelper(Node node, int min, int max) {
      if (node == null) return true; // base case
      if (node.data < min || node.data > max) return false; // if this node is out of bounds, not a BST
      // make sure both of the child nodes are within bounds, accounting for the new restrictions of the current node
      return checkBSTHelper(node.left, min, node.data-1) && checkBSTHelper(node.right, node.data+1, max);
  }
  
  //================ LINKED LISTS ================
  public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
    SinglyLinkedListNode prev = head,
        node = new SinglyLinkedListNode(data);
    if (position == 0) {
      node.next = head;
      return node;
    }
    for (int i = 0; i < position-1; i++)
      prev = prev.next;
    node.next = prev.next;
    prev.next = node;
    return head;
  }
  /**
   * It's not pretty but it works.
   * Inserts a node according to order in a doubly linked list
   */
  public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
    DoublyLinkedListNode prev = head,
        node = new DoublyLinkedListNode(data);
    if (head.data > data) {
      node.next = head;
      head.prev = node;
      return node;
    }
    while (prev.data < data)
      if (prev.next == null) {
        node.prev = prev;
        prev.next = node;
        return head;
      }
      else if (prev.next.data < data)
        prev = prev.next;
      else
        break;
    node.next = prev.next;
    node.prev = prev;
    prev.next = node;
    if (node.next != null)
      node.next.prev = node;
    return head;
  }

  public static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
    while (head != null) {
      DoublyLinkedListNode temp = head.next;
      head.next = head.prev;
      head.prev = temp;
      if (head.prev == null)
        break;
      head = head.prev;
    }
    return head;
  }
  /**
   * I really like this algorithm
   */
  public static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
    SinglyLinkedListNode n1 = head1,
        n2 = head2;
    while (n1 != n2) {
      if (n1.next == null) n1 = head2;
      else n1 = n1.next;
      
      if (n2.next == null) n2 = head1;
      else n2 = n2.next;
    }
    return n1.data;
  }
  /**
   * Tests if LinkedList has a cycle, exploiting the max list size of 100
   */
  public static boolean hasCycle1(Node head) {
    try {
      for (int i = 0; i < 101; i++)
        head = head.next;
    } catch(NullPointerException e) { return false; }
    return true;
  }
  /**
   * Tests if LinkedList has a cycle w/o exploiting max size, using Floyd's Tortoise & Hare
   */
  public static boolean hasCycle2(Node head) {
    if (head == null) return false;
    
    Node tort = head;
    Node hare = head.next;
    
    while (tort != hare) {
      if (hare == null || hare.next == null) return false;
      tort = tort.next;
      hare = hare.next.next;
    }
    return true;
  }

  // ================ RECURSION & BACKTRACKING ================
  public static int recursiveFibonacci(int n) {
    if (n == 0 || n == 1) return n;
    return recursiveFibonacci(n-1)+recursiveFibonacci(n-2);
  }
  
  // ================ MISC. ================
  static long flippingBits(long n) { return n ^ 0xffffffff; }
  /**
   * Finds the maximum sum of contiguous values in arr
   * @return sum of the maximum subarray
   */
  public static int maxSubarraySum(int[] arr) {
    int max = Integer.MIN_VALUE;
    int current = 0;
    for (int i = 0; i < arr.length; i++) {
      current += arr[i];
      if (max < current) max = current;
      if (current < 0) current = 0;
    }
    return max;
  }
  
  // -================< HELPER STUFF >================-
  private static class Node {
    // for tree nodes
    Node left;
    Node right;
    
    Node next; // for LinkedList nodes
    
    // for both
    int data;
    
    Node(int data) {
      this.data = data;
      left = null;
      right = null;
      next = null;
    }
  }
  // inserts node into BST
  public static Node insert(Node root, int data) {
    if (root == null)
        return new Node(data);
    else {
      Node cur;
      if (data <= root.data) {
          cur = insert(root.left, data);
          root.left = cur;
      } else {
          cur = insert(root.right, data);
          root.right = cur;
      }
      return root;
    }
  }
  static class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
    }
  }

  static class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
      if (this.head == null) this.head = node;
      else this.tail.next = node;
      this.tail = node;
    }
    public void insertNode(SinglyLinkedListNode node) {
      if (this.head == null)
          this.head = node;
      else
          this.tail.next = node;
      this.tail = node;
    }
  }
  
  public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
      throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));
      node = node.next;
      if (node != null)
          bufferedWriter.write(sep);
    }
  }
  static class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }

  static class DoublyLinkedList {
    public DoublyLinkedListNode head;
    public DoublyLinkedListNode tail;

    public DoublyLinkedList() {
      this.head = null;
      this.tail = null;
    }

    public void insertNode(int nodeData) {
      DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

      if (this.head == null)
        this.head = node;
      else {
        this.tail.next = node;
        node.prev = this.tail;
      }
      this.tail = node;
    }
  }

  public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter)
      throws IOException {
    while (node != null) {
      bufferedWriter.write(String.valueOf(node.data));
      node = node.next;
      if (node != null)
        bufferedWriter.write(sep);
    }
  }
}