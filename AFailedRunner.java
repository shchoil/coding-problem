import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AFailedRunner {
    public static void main(String[] args) throws Exception {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String result = solution(participant, completion);

        System.out.println(result);
    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> participantMap = new HashMap<>();

        for (String name : participant) {
            participantMap.put(name, participantMap.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            participantMap.put(name, participantMap.get(name) - 1);
        }

        for (String name : participant) {
            if (participantMap.get(name) != 0) {
                answer = name;
                break;
            }
        }

        return answer;

        // 처음 풀이 - 효율성 테스트에서 걸림
        // String answer = "";
        // List<String> participantList = new ArrayList<>();

        // for (String name : participant) {
        //     participantList.add(name);
        // }
 
        // for (String name : completion) {
        //     participantList.remove(name);
        // }

        // if (!participantList.isEmpty()) {
        //     answer = participantList.get(0);
        // }

        // return answer;
    }
}
