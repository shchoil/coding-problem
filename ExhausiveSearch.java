import java.util.HashSet;

public class ExhausiveSearch {
    public static void main(String[] args) throws Exception {
        String numbers = "17";
        int result = solution(numbers);
        System.out.println(result);
    }

    public static int solution(String numbers) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        generateNumberComb(numbers, 0, "", set);

        for (int num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }
    
    private static void generateNumberComb(String numbers, int index, String current, HashSet<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            generateNumberComb(numbers.substring(0, i) + numbers.substring(i + 1), index, current + numbers.charAt(i), set);
        }
    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
