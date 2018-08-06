import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopInterviewQuestions {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
	}
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target-nums[i];
			if (map.containsKey(complement))
				return new int[] {map.get(complement),i};
			map.put(nums[i], i);
		}
		return null;
    }
	public static int[] twoSumNaive(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++)
			for (int j = 0; j < nums.length; j++)
				if (nums[i]+nums[j]==target)
					return new int[] {i, j};
        return null;
    }
}
