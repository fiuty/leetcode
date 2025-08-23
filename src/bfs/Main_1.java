package bfs;

import java.util.*;

/**
 输入：
 5 5
 0 1 0 0 0
 0 1 0 1 0
 0 0 0 0 0
 0 1 1 1 0
 0 0 0 1 0
 输出：
 最短路径长度: 8
 路径坐标:
 (0, 0)
 (1, 0)
 (2, 0)
 (2, 1)
 (2, 2)
 (2, 3)
 (3, 3)
 (4, 3)
 (4, 4)
 * @date: 2025/8/19 22:41
 * @author: dd
 */
public class Main_1 {

    // 方向向量：上、右、下、左
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 读取迷宫尺寸
        System.out.print("输入迷宫行数和列数: ");
        int rows = sc.nextInt();
        int cols = sc.nextInt();

        // 创建迷宫
        int[][] maze = new int[rows][cols];
        System.out.println("输入迷宫矩阵 (0=通路, 1=障碍):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        // 计算最短路径
        List<Point> path = findShortestPath(maze);

        // 输出结果
        if (path.isEmpty()) {
            System.out.println("没有可行路径!");
        } else {
            System.out.println("\n最短路径长度: " + (path.size() - 1));
            System.out.println("路径坐标:");
            for (Point p : path) {
                System.out.println("(" + p.x + ", " + p.y + ")");
            }
        }
    }

    // BFS寻找最短路径
    private static List<Point> findShortestPath(int[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;

        // 起点和终点
        Point start = new Point(0, 0);
        Point end = new Point(rows - 1, cols - 1);

        // 队列用于BFS
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);

        // 记录访问状态和前驱节点
        boolean[][] visited = new boolean[rows][cols];
        Point[][] prev = new Point[rows][cols];

        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            // 到达终点
            if (current.equals(end)) {
                return reconstructPath(prev, end);
            }

            // 探索四个方向
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 检查是否有效移动
                if (isValid(nx, ny, rows, cols) && maze[nx][ny] == 0 && !visited[nx][ny]) {
                    Point next = new Point(nx, ny);
                    queue.add(next);
                    visited[nx][ny] = true;
                    prev[nx][ny] = current; // 记录前驱节点
                }
            }
        }

        return Collections.emptyList(); // 无路径
    }

    // 检查坐标是否有效
    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    // 重建路径（从终点回溯到起点）
    private static List<Point> reconstructPath(Point[][] prev, Point end) {
        LinkedList<Point> path = new LinkedList<>();
        Point current = end;

        while (current != null) {
            path.addFirst(current); // 添加到开头
            current = prev[current.x][current.y]; // 回溯
        }

        return path;
    }

    // 表示坐标的内部类
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Point point = (Point) obj;
            return x == point.x && y == point.y;
        }
    }
}
