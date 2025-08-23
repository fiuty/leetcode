package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @date: 2025/8/19 22:57
 * @author: dd
 */
public class Main_1_temp {

    public static int[][] DIR = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

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
                int num = sc.nextInt();
                if (num == 1) {
                    num = -1;
                }
                maze[i][j] = num;
            }
        }
        Point start = new Point(0, 0);
        Queue<Point> queue = new LinkedList<>();
        queue.add(start);
        int step = 1;
        maze[0][0] = 1;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            // 到达终点
            if (point.x == rows - 1 && point.y == cols - 1) {
                System.out.println("到达终点");
                break;
            }
            step = maze[point.x][point.y];
            // 上下左右扩展
            for (int i = 0; i < 4; i++) {
                int extendX = point.x + DIR[i][0];
                int extendY = point.y + DIR[i][1];
                if (validPoint(extendX, extendY, maze)) {
                    maze[extendX][extendY] = step + 1;
                    queue.add(new Point(extendX, extendY));
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean validPoint(int x, int y, int[][] maze) {
        if (x >= maze.length || x < 0) {
            return false;
        }
        if (y >= maze[0].length || y < 0) {
            return false;
        }
        return maze[x][y] == 0;
    }

}
class Point{
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
