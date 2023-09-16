package medium;

import java.util.Arrays;

public class leetcode59 {
    // 59. 螺旋矩阵 II
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(3)));
    }

    public static int[][] generateMatrix(int n) {
        // 循环次数
        int loop = 0;
        // 循环开始点
        int start = 0;
        // 填充数字
        int count = 1;
        // 结果
        int res[][] = new int[n][n];
        // 坐标
        int i, j;

        while (loop++ < n / 2) {
            // 上侧从左至右
            for (j = start; j < n - loop; j++) {
                res[start][j] = count++;
            }
            // 右侧从上至下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }
            // 下侧从右至左
            for (; j >= loop; j--) {
                res[i][j] = count++;
            }
            // 左侧从下至上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }
        // 如果为奇数
        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }
}