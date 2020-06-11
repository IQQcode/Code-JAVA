package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:43
 * @Description:����ʽ����---�̲߳���ȫ
 * �ص�: ����һ��ȥʹ��Singleton�����ʱ��Ż�Ϊ�����ʵ��������Ĳ���.
 */
class Singleton03 {

    private static Singleton03 single;

    //private �����޲ι���
    private Singleton03() { }

    //��̬���з�������ʹ�õ��÷���ʱ���Ŵ�������(����ʽ)
    public static Singleton03 getSingleton(){
        if(single == null) {
            single = new Singleton03();
        }
        return single;
    }

    public void print() {
        System.out.println("����ʽ����(�̲߳���ȫ)���õ�ʱ����new�������󡭡�");
    }
}

public class LazySingleton03 {
    public static void main(String[] args) {
        Singleton03 single = Singleton03.getSingleton();
        Singleton03 single1 = Singleton03.getSingleton();
        System.out.println(single == single1);
        single.print();
    }
}
