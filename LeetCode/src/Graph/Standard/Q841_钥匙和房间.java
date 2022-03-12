package Graph.Standard;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * @author Hyperspace
 * @date 2022/03/12
 * <p>
 * 思路
 * 1. dfs -- O(n+m)，n为房间的数目，m为钥匙的总数目
 * 注意题目已经限定了只能从第0间房间进入
 * 即给定了dfs的入口条件
 * 2. bfs -- O(n+m)
 */
public class Q841_钥匙和房间 {
    List<List<Integer>> rooms;
    boolean[] visited;
    int cnt = 0, len;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        this.rooms = rooms;
        len = rooms.size();
        visited = new boolean[len];

        dfs(0);

        return cnt == len;
    }

    private void dfs(int key) {
        visited[key] = true;
        for (int room : rooms.get(key)) {
            if (!visited[room]) {
                dfs(room);
            }
        }
        cnt++;
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        len = rooms.size();
        visited = new boolean[len];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int key = queue.poll();
            cnt++;
            for (int room : rooms.get(key)) {
                if (!visited[room]) {
                    visited[room] = true;
                    queue.offer(room);
                }
            }
        }

        return cnt == len;
    }
}
