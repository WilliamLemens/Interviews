import java.util.HashMap;
import java.util.Map;

public class RedditProblems {
    public static void main(String[] args) {
        System.out.println(mostFrequentInt(new int[] { 1, 2, 3, 4, 1, 2, 3, 2, 1, 2, 2, 5 }));
    }

    public static int mostFrequentInt(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxVal = arr[0];
        for (int i : arr) {
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
            if (map.get(i) > map.get(maxVal))
                maxVal = i;
        }
        return maxVal;
    }
}
