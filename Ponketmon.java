import java.util.HashSet;

public class Ponketmon {
    public static void main(String[] args) throws Exception {
        int[] numbers = {3, 3, 3, 2, 2, 4};
        int result = solution(numbers);
        // System.out.println(result);
    }

    public static int solution(int[] nums) {
        int maxNum = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        return Math.min(maxNum, set.size());
    }
}
