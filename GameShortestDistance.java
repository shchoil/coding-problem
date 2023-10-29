import java.util.LinkedList;
import java.util.Queue;

public class GameShortestDistance {
    public static void main(String[] args) throws Exception {
        int[][] maps = {
            {1, 0, 1, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 1},
            {1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1}
        };
        int result = solution(maps);
        System.out.println(result);
    }

    static class Node {
        int currentX;
        int currentY;
        int distance;

        public Node(int currentX, int currentY, int distance) {
            this.currentX = currentX;
            this.currentY = currentY;
            this.distance = distance;
        }
    }

    public static int solution(int[][] maps) {
        int answer = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int maxWidth = maps.length;
        int maxLength = maps[0].length;

        // Queue<int[]> queue = new LinkedList<>();
        // queue.add(new int[]{0, 0, 1});

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));

        while (!queue.isEmpty()) {
            // int[] current = queue.poll();
            // int currentX = current[0];
            // int currentY = current[1];
            // int distance = current[2];
            
            Node current = queue.poll();
            int currentX = current.currentX;
            int currentY = current.currentY;
            int distance = current.distance;

            if (currentX == maxWidth - 1 && currentY == maxLength - 1) {
                answer = distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextX < maxWidth && nextY >= 0 && nextY < maxLength && maps[nextX][nextY] == 1) {
                    maps[nextX][nextY] = 0;
                    // queue.add(new int[]{nextX, nextY, distance + 1});
                    queue.add(new Node(nextX, nextY, distance + 1));
                }
            }
        }

        return (answer == 0) ? -1 : answer;
    }
}