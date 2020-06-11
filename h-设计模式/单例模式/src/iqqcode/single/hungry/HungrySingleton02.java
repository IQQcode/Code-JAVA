package iqqcode.single.hungry;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:42
 * @Description:����ʽ����---��̬�����
 */
class Singleton02 {
    private static Singleton02 single;

    private Singleton02() { }

    static {
        single = new Singleton02();
    }

    public static Singleton02 getSingleton(){
        return single;
    }

    public void print() {
        System.out.println("����ʽ����,��̬����鷽ʽ");
    }
}

public class HungrySingleton02 {
    public static void main(String[] args) {
        Singleton02 single = Singleton02.getSingleton();
        Singleton02 single1 = Singleton02.getSingleton();
        System.out.println(single == single1);
        single.print();
    }
}