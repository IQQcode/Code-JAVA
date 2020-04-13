package iqqocde.algorithm.test;

import iqqocde.algorithm.sort.ShellSort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Mr.Q
 * @Date: 2020-04-12 15:00
 * @Description:事后分析法测试插入排序&希尔排序
 */
public class TestInsertAndShell {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        //读取reverse_arr.txt文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("reverse_arr.txt")));
        String line = null;
        while ((line=reader.readLine()) != null) {
            //把每一个数字存入到集合中
            list.add(Integer.valueOf(line));
        }
        reader.close();
        //把集合转换成数组
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        //测试插入排序
        //testInserSort(arr); //76826ms
        testShell(arr); //29ms
    }

    /**
     * 插入排序
     * @param arr
     */
    public static void testInserSort(Integer[] arr) {
        long start = System.currentTimeMillis();
        InsertSort.insertSort(arr);;
        long end= System.currentTimeMillis();
        System.out.println("使用插入排序耗时："+(end-start) + "ms");
    }

    public static void testShell(Integer[] arr){
        //使用希尔排序完成测试
        long start = System.currentTimeMillis();
        ShellSort.shellSort(arr);
        long end = System.currentTimeMillis();
        System.out.println("使用希尔排序耗时："+(end-start) + "ms");
    }
}
