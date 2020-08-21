package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:33
 * @Description:ö��ʵ�ֵ���ģʽ
 */
enum Singleton {
    INSTANCE; //����

    public static Singleton getInstance() {
        return Singleton.INSTANCE;
    }
}

public class _07Enum {
    public static void main(String[] args) {
        Singleton single = Singleton.getInstance();
        Singleton single1 = Singleton.getInstance();
        System.out.println(single == single1);
    }
}
