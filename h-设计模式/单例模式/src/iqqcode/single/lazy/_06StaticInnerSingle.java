package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:46
 * @Description:��̬�ڲ���---�̰߳�ȫ
 */
class StaticInner {

    private StaticInner() { }

    //��̬�ڲ���
    private static class Singleton {
        private static final StaticInner INSTANCE = new StaticInner();
    }

    public static StaticInner getSingleton() {
        return Singleton.INSTANCE;
    }

    public void print() {
        System.out.println("��̬�ڲ���ʵ�ֵ�--->�̰߳�ȫ������ʽ����");
    }
}

public class _06StaticInnerSingle {
    public static void main(String[] args) {
        StaticInner single = StaticInner.getSingleton();
        single.print();
    }
}