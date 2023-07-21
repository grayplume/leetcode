package other;

import java.util.ArrayList;

public class BasicSearch {
    // 基本查找
    public static void main(String[] args) {

        int[] arr = { 123, 323, 123, 222, 543, 112 };
        int number = 123;

        System.out.println(basicSearch(arr, number));
        System.out.println(basicSearch2(arr, number));
    }



    // 返回查找的索引，包含重复值
    public static ArrayList<Integer> basicSearch2(int[] arr, int number) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                arrayList.add(i);
            }
        }
        return arrayList;
    }


    // 返回查找的索引
    public static int basicSearch(int[] arr, int number) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }
}
