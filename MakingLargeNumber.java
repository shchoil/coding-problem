public class MakingLargeNumber {
    public static void main(String[] args) throws Exception {
        String numbers = "4177252841";
        int k = 4;
        String result = solution(numbers, k);

        System.out.println(result);
    }

    public static String solution(String number, int k) {
        int len = number.length();
        int remain = len - k;
        int start = 0;
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < remain; i++) {
            char maxDigit = findMaxDigit(number, start, len - remain + i);
            int maxIndex = number.indexOf(maxDigit, start);

            answer.append(maxDigit);
            start = maxIndex + 1;
        }

        return answer.toString();
    }

    private static char findMaxDigit(String number, int start, int end) {
        char maxDigit = '0';

        for (int i = start; i <= end; i++) {
            if (number.charAt(i) > maxDigit) {
                maxDigit = number.charAt(i);
            }
        }

        return maxDigit;
    }
}
