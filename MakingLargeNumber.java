import java.util.HashSet;


public class MakingLargeNumber {
    public static void main(String[] args) throws Exception {
        String numbers = "1231234";
        int k = 3;
        String result = solution(numbers, k);
        System.out.println(result);
    }

    public static String solution(String number, int k) {
        String answer = "";
        String stringChangeK = Integer.toString(k);
        String numberMinusK = number.replace(stringChangeK, "");
        HashSet<Integer> set = new HashSet<>();

        generateNumberComb(numberMinusK, 0, "", set);

        System.out.println(set);

        return answer;
    }

    private static void generateNumberComb(String numberMinusK, int index, String current, HashSet<Integer>set) {

        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numberMinusK.length(); i++) {
            generateNumberComb(numberMinusK.substring(0, i) + numberMinusK.substring(i + 1), index, current + numberMinusK.charAt(i), set);
        }
    }
}
