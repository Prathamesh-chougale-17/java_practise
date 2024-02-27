//Astar algorithm for path finding

import java.util.*;

public class temp {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 1},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1}
        };
        int[] start = new int[]{0, 0};
        int[] end = new int[]{4, 5};
        int[][] path = findPath(grid, start, end);
        for (int[] p : path) {
            System.out.println(Arrays.toString(p));
        }
    }

    public static int[][] findPath(int[][] grid, int[] start, int[] end) {
        int[][] path = new int[grid.length * grid[0].length][2];
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] parent = new int[grid.length][grid[0].length];
        int[][] cost = new int[grid.length][grid[0].length];
        int[][] heuristic = new int[grid.length][grid[0].length];
        int[][] total = new int[grid.length][grid[0].length];
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return total[a[0]][a[1]] - total[b[0]][b[1]];
            }
        });
        pq.offer(start);
        visited[start[0]][start[1]] = 1;
        cost[start[0]][start[1]] = 0;
        heuristic[start[0]][start[1]] = Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
        total[start[0]][start[1]] = cost[start[0]][start[1]] + heuristic[start[0]][start[1]];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] == end[0] && cur[1] == end[1]) {
                break;
            }
            for (int[] dir : directions) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 1 || visited[x][y] == 1) {
                    continue;
                }
                visited[x][y] = 1;
                cost[x][y] = cost[cur[0]][cur[1]] + 1;
                heuristic[x][y] = Math.abs(x - end[0]) + Math.abs(y - end[1]);
                total[x][y] = cost[x][y] + heuristic[x][y];
                parent[x][y] = cur[0] * grid[0].length + cur[1];
                pq.offer(new int[]{x, y});
            }
        }
        int[] cur = end;
        int index = 0;
        while (cur[0] != start[0] || cur[1] != start[1]) {
            path[index++] = cur;
            int p = parent[cur[0]][cur[1]];
            cur[0] = p / grid[0].length;
            cur[1] = p % grid[0].length;
        }
        path[index] = start;
        int[][] res = new int[index + 1][2];
        for (int i = 0; i <= index; i++) {
            res[i] = path[index - i];
        }
        return res;
    }
}
