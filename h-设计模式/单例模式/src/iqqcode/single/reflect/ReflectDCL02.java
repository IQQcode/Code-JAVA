package iqqcode.single.reflect;

import java.lang.reflect.Constructor;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 20:19
 * @Description:˫���䱬��DCL---����02
 */
class SafeSingleton02 {

    //ʹ��volatile�ؼ��ֱ���ɼ���
    private volatile static SafeSingleton02 single = null;

    private SafeSingleton02() {
        synchronized (SafeSingleton02.class) {
            if (single != null) {
                throw new RuntimeException("Don't destroy by reflection");
            }
        }
    }

    //ͬ�����������
    public static SafeSingleton02 getInstance() {
        if(single == null) {
            synchronized (SafeSingleton02.class) {
                //˫�ؼ��
                if (single == null) {
                    single = new SafeSingleton02();
                }
            }
        }
        return single;
    }
}

public class ReflectDCL02 {
    public static void main(String[] args) throws Exception {
        Constructor<SafeSingleton02> dc = SafeSingleton02.class.getDeclaredConstructor();
        dc.setAccessible(true);
        SafeSingleton02 single = dc.newInstance();
        SafeSingleton02 singleCopy = dc.newInstance();
        //false,�������ƻ�
        System.out.println(single);
        System.out.println(singleCopy);
        System.out.println(single == singleCopy);
    }
}