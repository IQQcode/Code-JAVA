package com.iqqcode;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author: Mr.Q
 * @Date: 2020-02-06 10:42
 * @Description:
 */
public class MergeTwoArrays_Three {
    //����һ��
    private static void method1(int a[],int b[],int array[]) {
        //����c���飬����a��ӽ�ȥ
        int c[]= Arrays.copyOf(a, a.length+b.length);
        //��b������ӵ��Ѿ�����a�����c������ȥ
        System.arraycopy(b, 0, c, a.length, b.length);
        //��c�����������
        Arrays.sort(c);
        System.out.println("����һ��");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i]+" ");
        }
    }

    //������:���Ϸ���  ʹ��LinkedList ����
    private static void method2(int array[], LinkedList<Integer> queue_a, LinkedList<Integer> queue_b ) {
        //ÿѭ��һ�Σ����һ����СԪ�ؽ���arrays
        for (int i = 0; i < array.length; i++) {
            //�������ж���Ϊ��ʱ��˭Сȡ��˭
            if (!queue_a.isEmpty()&&!queue_b.isEmpty()) {
                if (queue_a.peek()<queue_b.peek()) {
                    array[i]=queue_a.poll();
                    continue;
                }else {
                    array[i]=queue_b.poll();
                    continue;
                }
            }
            //������aΪ��ʱ��ȡ����b��Ԫ��
            if (queue_a.isEmpty()&&!queue_b.isEmpty()) {
                array[i]=queue_b.poll();
                continue;
            }
            //������bΪ��ʱ��ȡ����a��Ԫ��
            if (queue_b.isEmpty()&&!queue_a.isEmpty()) {
                array[i]=queue_a.poll();
                continue;
            }
        }
        System.out.println("��������");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
    }
    //���������ݹ鷽��
    private static int [] method3(int a[],int a_start,int b[],int b_start,int array[],int array_start) {

        //������a�е�Ԫ�ض��Ѿ��ŵ�array�����У�������bδȫ���ŵ�array�У�
        //��ô��b��ʣ���Ԫ�طŵ�array��
        if (a_start>=a.length) {
            for (int i = array_start; i < array.length; i++) {
                array[array_start]=b[b_start++];
            }
            return array;
        }
        //������b�е�Ԫ�ض��Ѿ��ŵ�array�����У�������aδȫ���ŵ�array�У�
        //��ô��a��ʣ���Ԫ�طŵ�array��
        if (b_start>=b.length) {
            for (int i = array_start; i < array.length; i++) {
                array[array_start]=a[a_start++];
            }
            return array;
        }
        //�������ͷԪ��,b����ͷԪ�� �е���Сֵ�����array
        if (a[a_start]<b[b_start]) {
            array[array_start]=a[a_start];
            return	  method3(a, a_start+1, b, b_start,  array, array_start+1);
        }else {
            array[array_start]=b[b_start];
            return	  method3(a, a_start, b, b_start+1, array, array_start+1);
        }

    }


    public static void main(String[] args) {
        int a[]={0,1,5,6,7,9,14};
        int b[]={2,4,8,10,13};
        LinkedList<Integer> queue_a=new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            queue_a.offer(a[i]);
        }
        LinkedList<Integer> queue_b=new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            queue_b.offer(b[i]);
        }
        int array[]=new int[a.length+b.length];

        method1(a, b, array);
        System.out.println();
        method2(array, queue_a, queue_b);
        System.out.println("\n��������");
        int all[]=method3(a, 0, b, 0, array, 0);
        for (int i : all) {
            System.out.print(i+" ");
        }
    }
}
