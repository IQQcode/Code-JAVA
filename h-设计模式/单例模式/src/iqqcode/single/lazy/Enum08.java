package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:33
 * @Description:ö��ʵ�ֵ���ģʽ
 */
enum Singleton {
    INSTANCE; //����
    public void print() {
        System.out.println("ö��ʵ�ֵ���ģʽ...");
    }
}

public class Enum08 {
    public static void main(String[] args) {
        Singleton single = Singleton.INSTANCE;
        Singleton single1 = Singleton.INSTANCE;
        System.out.println(single == single1);
        single.print();
    }
}
