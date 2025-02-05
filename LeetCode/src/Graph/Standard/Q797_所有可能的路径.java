package Graph.Standard;

import java.util.*;

/**
 * @author Hyper
 * @date 2022/03/12
 * 1. dfs
 * 使用双端队列作替代时，应指定插入和删除的位置
 * 2. bfs
 * 注意是编号从0开始的有向图DAG
 */
public class Q797_所有可能的路径 {
    private int[][] graph;
    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> stk = new ArrayDeque<>();
    int len;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        len = graph.length;
        stk.offerLast(0);

        dfs(0);

        return res;
    }

    private void dfs(int idx) {
        if (idx == len - 1) {
            res.add(new ArrayList<>(stk));
            return;
        }
        for (int next : graph[idx]) {
            stk.offerLast(next);
            dfs(next);
            stk.pollLast();
        }
    }

    private class Node {
        int idx;
        List<Integer> path;

        public Node(int idx) {
            this.idx = idx;
            this.path = new ArrayList<Integer>() {{
                add(idx);
            }};
        }

        public Node(int idx, List<Integer> path) {
            this.idx = idx;
            this.path = new ArrayList<>(path);
            this.path.add(idx);
        }
    }

    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        int len = graph.length;
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.idx == len - 1) {
                res.add(node.path);
                continue;
            }
            if (node.idx >= len || graph[node.idx].length == 0) {
                continue;
            }
            for (int point : graph[node.idx]) {
                queue.offer(new Node(point, node.path));
            }
        }

        return res;
    }
}
