package DisjointSet;

/**
 * @author Hyper
 * @date 2022/03/12
 * <p>
 * 使用rank对合并过程进行优化
 * 注意合并时的两个分量不应相同
 * 待回看
 */
public class Q200_岛屿数量 {
    private final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int m, n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;

        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    for (int[] dir : dirs) {
                        int row = i + dir[0];
                        int col = j + dir[1];
                        if (isIn(row, col) && grid[row][col] == '1') {
                            uf.union(i * n + j, row * n + col);
                        }
                    }
                }
            }
        }

        return uf.getCnt();
    }

    private boolean isIn(int row, int col) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }

    class UnionFind {
        int cnt;
        int[] parent;
        int[] rank;

        public int getCnt() {
            return cnt;
        }

        public UnionFind(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            cnt = 0;
            parent = new int[m * n];
            rank = new int[m * n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        cnt++;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }

            return parent[i];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootX] = rootY;
                    rank[rootY]++;
                }
                cnt--;
            }
        }
    }
}
