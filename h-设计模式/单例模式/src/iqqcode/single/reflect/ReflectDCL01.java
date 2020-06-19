package iqqcode.single.reflect;

import java.lang.reflect.Constructor;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 20:19
 * @Description:���䱬��DCL---����01
 */
class SafeSingleton {

    //ʹ��volatile�ؼ��ֱ���ɼ���
    private volatile static SafeSingleton single = null;

    private SafeSingleton() {
        synchronized (SafeSingleton.class) {
            if (single != null) {
                throw new RuntimeException("Don't destroy by reflection");
            }
        }
    }

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
}

public class ReflectDCL01 {
    public static void main(String[] args) throws Exception {
        SafeSingleton single = SafeSingleton.getInstance();
        Constructor<SafeSingleton> dc = SafeSingleton.class.getDeclaredConstructor();
        dc.setAccessible(true);
        SafeSingleton singleCopy = dc.newInstance();
        //false,�������ƻ�
        System.out.println(singleCopy == single);
    }
}

