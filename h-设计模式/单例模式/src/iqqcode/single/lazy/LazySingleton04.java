package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:44
 * @Description:����ʽ����---ͬ������(Ч��̫��)
 */
class Singleton04 {

    private static Singleton04 single;

    //private �����޲ι���
    private Singleton04() { }

    //��̬���з�������ʹ�õ��÷���ʱ���Ŵ�������(����ʽ)
    public synchronized static Singleton04 getSingleton(){
        if(single == null) {
            single = new Singleton04();
        }
        return single;
    }

    public void print() {
        System.out.println("����ʽ����(�̰߳�ȫ)��ͬ������Ч��̫��");
    }
}

public class LazySingleton04 {
    public static void main(String[] args) {
        Singleton04 single = Singleton04.getSingleton();
        single.print();
    }
}