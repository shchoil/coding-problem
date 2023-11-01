import java.util.HashSet;

public class Ponketmon {
    public static void main(String[] args) throws Exception {
        int[] numbers = {3, 3, 3, 2, 2, 4};
        int result = solution(numbers);
        System.out.println(result);
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int maxNumLength = nums.length / 2;
        HashSet<Integer> set = new HashSet<>();

        generateNumberComb(nums, 0, 0, set);

        answer = Math.min(set.size(), maxNumLength);

        return answer;
    }

    private static void generateNumberComb(int[] nums, int idx, int currentNum, HashSet<Integer> set) {

        if (idx == nums.length) {
            set.add(currentNum);
            return;
        }

        generateNumberComb(nums, idx + 1, currentNum, set);

        generateNumberComb(nums, idx + 1, currentNum + nums[idx], set);
    }
}
