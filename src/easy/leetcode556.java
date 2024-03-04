package easy;

import java.util.Arrays;

public class leetcode556 {
    // 566. 重塑矩阵
    public static void main(String[] args) {
        int[][] mat = { { 1, 2 }, { 3, 4 } };
        int r = 1;
        int c = 4;
        int[][] result = matrixReshape(mat, r, c);
        Arrays.stream(result).forEach(a -> System.out.println(Arrays.toString(a)));
    }

    // 定义一个方法 matrixReshape，输入参数为一个二维整数数组 mat、两个整数 r 和 c，分别表示重塑后矩阵的行数和列数
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        // 获取原矩阵 mat 的行数 m
        int m = mat.length;
        // 获取原矩阵 mat 的列数 n
        int n = mat[0].length;

        // 检查原矩阵元素数量（m * n）是否等于新矩阵所需元素数量（r * c）
        // 若不相等，则无法进行重塑操作，直接返回原矩阵
        if (m * n != r * c) {
            return mat;
        }

        // 创建一个新的 r x c 的二维数组 ans 用于存储重塑后的矩阵
        int[][] ans = new int[r][c];

        // 遍历原矩阵的所有元素，索引值从0到 m*n - 1
        for (int x = 0; x < m * n; ++x) {
            // 计算新矩阵中元素的位置：行号由 x 除以新矩阵的列数 c 取整得到，列号由 x 对新矩阵的列数 c 取模得到
            // 同时计算原矩阵中对应位置的元素，并将其赋值给新矩阵中的相应位置
            ans[x / c][x % c] = mat[x / n][x % n];
        }

        // 重塑完成后，返回新的二维数组 ans
        return ans;
    }
}
