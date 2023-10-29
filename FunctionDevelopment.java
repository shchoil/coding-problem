import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment {
    public static void main(String[] args) throws Exception {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] result = solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> resultList = new ArrayList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
    
        for (int i = 0; i < progresses.length; i++) {
            int completedDay = complete(progresses[i], speeds[i]);
            queue.offer(completedDay);
        }
    
        int count = 1;
        int prevDay = queue.poll();
    
        while (!queue.isEmpty()) {
            int currentDay = queue.poll();
    
            if (currentDay <= prevDay) {
                count++;
                continue;
            }
            resultList.add(count);
            count = 1;
            prevDay = currentDay;
        }
    
        resultList.add(count);
    
        int[] resultArray = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }
    
        return resultArray;
    }
    
    private static int complete(int progress, int speed) {
        return (int)Math.ceil((100.0 - progress) / speed);
    }


    //     List<Integer> list = new ArrayList<>();
    //     int[] completedDays = new int[progresses.length];
    //     int i = 0;

    //     while (i < progresses.length) {

    //         int completedDay = complete(progresses[i], speeds[i]);
    //         completedDays[i] = completedDay;
    //         i++;
    //     }

    //     int comparecompletedDay = completedDays[0];
    //     int completeCount = 1;

    //     for (int n = 1; n < progresses.length; n++){

    //         if (comparecompletedDay >= completedDays[n]){
    //             completeCount += 1;
    //         } else {
    //             list.add(completeCount);
    //             completeCount = 1;
    //             comparecompletedDay = completedDays[n];
    //         }
    //     }
    //     list.add(completeCount);
        
    //     int[] answer = new int[list.size()];

    //     for (int push = 0; push < list.size(); push++) {
    //         answer[push] = list.get(push);
    //     }

    //     return answer;
    // }

    // private static int complete(int progresseTime, int speedTime) {
    //     int completedDay = 0;

    //     while (progresseTime + (speedTime * completedDay) < 100) {
    //         completedDay++;
    //     }

    //     return completedDay;
    // }
}
