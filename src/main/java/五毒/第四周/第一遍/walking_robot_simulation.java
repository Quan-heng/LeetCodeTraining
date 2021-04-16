package 五毒.第四周.第一遍;

import java.util.HashSet;
import java.util.Set;

public class walking_robot_simulation {
    /**
     * 关键点：
     * 1.遇到obstacle要break;
     * 2.将obsbacle转换成set效率更高
     * @param commands
     * @param obstacles
     * @return
     */
    public static int robotSim(int[] commands, int[][] obstacles) {
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{1, 0, -1, 0};
        Set<String> obstacleSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstacleSet.add(obstacles[i][0]+","+obstacles[i][1]);
        }
        int direction = 0;
        int x = 0;
        int y = 0;
        int max = 0;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -1) {
                direction = (direction + 1) % 4;

            } else if (commands[i] == -2) {
                direction = (direction + 3) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    int tempX = x + dx[direction];
                    int tempY = y + dy[direction];
                    if (!obstacleSet.contains(tempX+","+tempY)) {
                        x = tempX;
                        y = tempY;
                        max = Math.max(x * x + y * y, max);
                    } else {
                        break; //没必要进入后面的移动
                    }
                }
            }
        }
        return max;
    }



    public static void main(String[] args) {
        int[] commands = new int[]{4, -1, 3};
        int[][] obstacle = new int[][]{};
        System.out.println(robotSim(commands, obstacle));
    }
}
