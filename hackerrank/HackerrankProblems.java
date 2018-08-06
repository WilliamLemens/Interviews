import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HackerrankProblems {
	public static void main(String args[]) {
		int[][] twodarr =  {{-9, -9, -9,  1, 1, 1},
				 		{ 0, -9,  0,  4, 3, 2},
				 		{-9, -9, -9,  1, 2, 3},
				 		{ 0,  0,  8,  6, 6, 0},
				 		{ 0,  0,  0, -2, 0, 0},
				 		{ 0,  0,  1,  2, 4, 0}};
		int[][] twodarr2 = {{1, 1, 1, 0, 0, 0},
						{0, 1, 0, 0, 0, 0},
						{1, 1, 1, 0, 0, 0},
						{0, 0, 2, 4, 4, 0},
						{0, 0, 0, 2, 0, 0},
						{0, 0, 1, 2, 4, 0}};
		System.out.println(hourglassSum(twodarr));
		System.out.println(hourglassSum(twodarr2));

		int[] arr = {1,2,3,4,5};
		System.out.println(java.util.Arrays.toString(rotLeft(arr,1)));
		System.out.println(java.util.Arrays.toString(rotLeft(arr,2)));

		String[] sarr1 = {"two", "times", "three", "is", "not", "four"};
		String[] sarr2 = {"two", "times", "two", "is", "four"};
		checkMagazine(sarr1, sarr2);

		makeAnagram("fcrxzwscanmligyxyvym","jxwtrhvujlmrpdoqbisbwhmgpmeoke");

		minimumBribes2(new int[] {3,2,1});
		minimumBribes2(new int[] {2, 1, 5, 3, 4});

		System.out.println(minimumAbsoluteDifference(new int[] {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));
	}

	// +-======================================-+
	// |										|
	// |				Algorithms				|
	// |										|
	// +-======================================-+

	// ================ WARMUP ================

	public static int solveMeFirst(int a, int b) { return a+b; }

	public static int simpleArraySum(int[] ar) {
        int out = 0;
        for (int i : ar) out += i;
        return out;
    }

	public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        List<Integer> out = new ArrayList<>();
        int ac=0, bc=0;
        for (int i = 0; i < a.size(); i++)
        	if (a.get(i)>b.get(i)) ac++;
        	else if (b.get(i)>a.get(i)) bc++;
        out.add(ac);
        out.add(bc);
        return out;
    }

	// +-======================================-+
	// |										|
	// |		Interview Preparation Kit		|
	// |										|
	// +-======================================-+

    // ================ ARRAYS ================

    /**
     * Calculate and return the hourglass sums of arr
     *
     * a b c
     *   d
     * e f g
     * @param arr
     * @return the max hourglass sum
     */
	public static int hourglassSum(int[][] arr) {
	    int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length-2; i++)
			for (int j = 0; j < arr[0].length-2; j++) {
				int val = arr[i][j]+arr[i][j+1]+arr[i][j+2]+
									arr[i+1][j+1]+
							arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
				if (val>max) max = val;
			}
		return max;
	}

	/**
	 * ex: rotLeft([1,2,3,4,5],2} -> [3,4,5,1,2]
	 * @param a an array of integers
	 * @param d the number of rotations
	 * @return
	 */
    public static int[] rotLeft(int[] a, int d) {
    	int[] out = new int[a.length];
    	for (int i = 0; i < out.length; i++)
    		out[i]=a[(i+d)%a.length];
    	return out;
    }

    /**
     * O(N) but requires moving values in array
     * @param q
     */
    public static void minimumBribes(int[] q) {
    	int i = q.length-1, count = 0;
    	while (i > 0) {
    		if (q[i] == i+1) {
    			i--;
    			continue;
    		} else if (q[i-1] == i+1) {
    			count++;
    			q[i-1] = q[i];
    			q[i] = i+1;
    			i--;
    			continue;
    		} else if (q[i-2] == i+1) {
    			count+=2;
    			q[i-2] = q[i-1];
    			q[i-1] = q[i];
    			q[i] = i+1;
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
     * @param q
     */
    public static void minimumBribes2(int[] q) {
    	int count = 0;
    	for (int i = q.length-1; i >= 0; i--) {
    		if (q[i] - (i+1) > 2) { // if it's more than 2 off, it's too far away
    			System.out.println("Too chaotic");
    			return;
    		}
    		int val = q[i]-2;
    		for (int j = val > 0 ? val : 0; j < i; j++)
    			if (q[j] > q[i]) count++;
    	}
    	System.out.println(count);
    }

    /**
     *
     * @param arr
     * @return
     */
    public static int minimumSwaps(int[] arr) {
    	//TODO
    	return -1;
    }

    // ================ DICTIONARIES & HASHMAPS ================

	/**
	 * Checks if each word in note is also in magazine
	 * @param magazine
	 * @param note
	 */
    public static void checkMagazine(String[] magazine, String[] note) {
    	Map<String, Integer> map = new HashMap<>();
    	boolean b = true;
    	int i = -1;

    	for (String s : magazine)
    		map.put(s, (map.containsKey(s) ? map.get(s)+1 : 1));

    	while (++i < note.length && b)
    		if (!map.containsKey(note[i]))
    			b = false;
    		else {
    			int k = map.get(note[i])-1;
    			map.put(note[i], k);
    			b = k >= 0;
    		}

    	System.out.println(b ? "Yes" : "No");
    }

    /**
     * Returns "YES" if s1 and s2 share a substring, "NO" otherwise
     * @param s1
     * @param s2
     * @return "YES" or "NO"
     */
    public static String twoStrings(String s1, String s2) {
    	Set set1 = new HashSet(Arrays.asList(s1.split("")));
    	set1.retainAll(new HashSet(Arrays.asList(s2.split(""))));
    	return set1.size() > 0 ? "YES" : "NO";
    }
    /**
     * Returns "YES" if s1 and s2 share a substring, "NO" otherwise
     * @param s1
     * @param s2
     * @return "YES" or "NO"
     */
    public static String twoStringsOld(String s1, String s2) {
    	char[] ca1 = s1.toCharArray();
    	char[] ca2 = s2.toCharArray();
    	for (char c1 : ca1)
    		for (char c2 : ca2)
    			if (c1 == c2) return "YES";
    	return "NO";
    }

    // ================ SORTING ================

    /**
     * Sort a.
     * Print the number of swaps, first element, and last element.
     * @param a = input array
     */
    public static void countSwaps(int[] a) {
    	int count = 0;
    	for (int i = 0; i < a.length; i++)
    	    for (int j = 0; j < a.length - 1; j++)
    	        // Swap adjacent elements if they are in decreasing order
    	        if (a[j] > a[j + 1]) {
    	        	int temp = a[j];
    	        	a[j]=a[j+1];
    	        	a[j+1]=temp;
    	        	count++;
    	        }
    	System.out.println("Array is sorted in "+count+" swaps.");
    	System.out.println("First Element: "+a[0]);
    	System.out.println("Last Element: "+a[a.length-1]);
    }

    /**
     * Returns the max number of toys that we can buy with $k.
     * Each toy's price is in prices
     * @param prices
     * @param k
     * @return
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
     *
     * @param a
     * @param b
     * @return
     */
    public static int makeAnagram(String a, String b) {
    	// TODO
    	return -1;
    }

    // ================ GREEDY ALGORITHMS ================

    /**
     * Finds the minimum absolute difference between any two numbers in the array.
     * @param arr
     * @return minimum absolute difference
     */
	public static int minimumAbsoluteDifference(int[] arr) {
		int min = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			int val = Math.abs(arr[i-1]-arr[i]);
			if (val < min) min = val;
		}
		return min;
	}
	public static int luckBalance(int k, int[][] contests) {
		// TODO
		return -1;
    }
    // ================ SEARCH ================

    // ================ DYNAMIC PROGRAMMING ================

}
