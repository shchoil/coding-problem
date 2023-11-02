import java.util.ArrayList;
import java.util.List;

public class AFailedRunner {
    public static void main(String[] args) throws Exception {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result = solution(participant, completion);

        System.out.println(result);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        List<String> participantList = new ArrayList<>();

        for (String name : participant) {
            participantList.add(name);
        }

        for (String name : completion) {
            participantList.remove(name);
        }

        if (!participantList.isEmpty()) {
            answer = participantList.get(0);
        }

        return answer;
    }
}
