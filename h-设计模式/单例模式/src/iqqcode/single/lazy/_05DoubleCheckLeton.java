package iqqcode.single.lazy;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-09 22:45
 * @Description:����ʽ����---˫�ؼ��
 *
 * ��δ��뿴�������������ܿ�ϧ�����������⡣��Ҫ����instance = new Singleton()��䣬�Ⲣ����һ��ԭ�Ӳ�����
 * ��ʵ���� JVM ����仰����������� 3 �����顣 �� instance �����ڴ� ���� Singleton �Ĺ��캯������ʼ����Ա��
 * �� ��instance����ָ�������ڴ�ռ䣨ִ�����ⲽ instance ��Ϊ�� null �ˣ� ������ JVM �ļ�ʱ�������д���ָ
 * ����������Ż���Ҳ����˵����ĵڶ����͵�������˳���ǲ��ܱ�֤�ģ����յ�ִ��˳������� 1-2-3 Ҳ������ 1-3-
 * 2������Ǻ��ߣ����� 3 ִ����ϡ�2 δִ��֮ǰ�����̶߳���ռ�ˣ���ʱ instance �Ѿ��Ƿ� null �ˣ���ȴû�г�
 * ʼ�����������̶߳���ֱ�ӷ��� instance��Ȼ��ʹ�ã�Ȼ��˳����µر��� ����ֻ��Ҫ�� instance ����������
 * volatile �Ϳ�����
 */
class SafeSingleton {

    //ʹ��volatile�ؼ��ֱ���ɼ���
    private volatile static SafeSingleton single = null;

    private SafeSingleton() { }

    //ͬ�����������
    public static SafeSingleton getInstance() {
        if(single == null) {
            synchronized (SafeSingleton.class) {
                //˫�ؼ��
                if (single == null) {
                    single = new SafeSingleton();
                }
            }
        }
        return single;
    }

    public void print() {
        System.out.println("˫�ؼ������DCL����");
    }
}

public class _05DoubleCheckLeton {
    public static void main(String[] args) {
        //��̬����ȡ�������Ѿ������õĶ���
        SafeSingleton single = SafeSingleton.getInstance();
        single.print();
    }
}