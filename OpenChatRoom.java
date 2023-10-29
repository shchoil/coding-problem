import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OpenChatRoom {
    public static void main(String[] args) throws Exception {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = solution(record);

        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] record) {
        Map<String, String> tempNamesMap = new HashMap<>();
        List<String> message = new ArrayList<>();

        for (String str : record) {
            String[] splitRecord = str.split(" ");
            String userId = splitRecord[1];

            if (splitRecord[0].equals("Enter")) {
                String userName = splitRecord[2];

                message.add(userId + " 님이 들어왔습니다.");
                tempNamesMap.put(userId, userName);
            } else if (splitRecord[0].equals("Leave")) {
                message.add(userId + " 님이 나갔습니다.");
            } else if (splitRecord[0].equals("Change")) {
                String userName = splitRecord[2];

                tempNamesMap.put(userId, userName);
            }
        }

        String[] answer = new String[message.size()];

        for (int i = 0; i < message.size(); i++) {
            String messageElement = message.get(i);
            int firstSpace = messageElement.indexOf(" ");
            String userId = messageElement.substring(0, firstSpace);
            String actionMessage = messageElement.substring(firstSpace + 1);
            String tempName = tempNamesMap.get(userId);
            String userIdsName = tempNamesMap.replace(userId, tempName);

            answer[i] = userIdsName + actionMessage;
        }

        return answer;
    }
}
