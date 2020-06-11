package iqqcode.single.hungry;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:41
 * @Description:����ʽ����---��̬����
 * ����ʽ�����������
 *    1.���췽��˽�л�
 *    2.���ڲ��ṩ��̬˽����
 *    3.���ڲ��ṩ��̬��������Ψһ����
 */
class Singletons {
    //Ψһ�Ķ����������ʱ����
    private final static Singletons single = new Singletons();

    //���췽��˽�л�

    private Singletons() { }

    //��̬����-----Ϊʲô�Ǿ�̬��������
    //��Ϊ������ⲿ�޷�������������޷����ö��󷽷�
    //ͨ��getter����ȡ��Ψһ�Ķ���
    public static Singletons getSingleton(){
        return single;
    }

    public void print() {
        System.out.println("����ʽ����,����ֱ��new����");
    }
}

public class HungrySingleton01 {
    public static void main(String[] args) {
        //����ֱ��new,����ͨ�� Singleton.getSingleton()��̬����ȡ�������Ѿ������õĶ���
        Singletons single = Singletons.getSingleton();
        Singletons single1 = Singletons.getSingleton();
        System.out.println(single == single1);
        single.print();
    }
}
