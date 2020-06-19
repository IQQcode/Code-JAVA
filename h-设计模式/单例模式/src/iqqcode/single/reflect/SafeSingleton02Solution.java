package iqqcode.single.reflect;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Author: Mr.Q
 * @Date: 2020-06-14 22:45
 * @Description:���˫���䱬��DCL
 */
class SafeSingleton03 {

    //ʹ��volatile�ؼ��ֱ���ɼ���
    private volatile static SafeSingleton03 single = null;
    //��ӱ�־λ
    private static boolean flag = false;

    private SafeSingleton03() {
        synchronized (SafeSingleton03.class) {
            if (flag == false) {
                flag = true;
            }else {
                throw new RuntimeException("Don't destroy by reflection");
            }
        }
    }

    //ͬ�����������
    public static SafeSingleton03 getInstance() {
        if(single == null) {
            synchronized (SafeSingleton03.class) {
                //˫�ؼ��
                if (single == null) {
                    single = new SafeSingleton03();
                }
            }
        }
        return single;
    }

    public static void main(String[] args) throws Exception {
        Constructor<SafeSingleton03> dc = SafeSingleton03.class.getDeclaredConstructor();
        dc.setAccessible(true);
        SafeSingleton03 single = dc.newInstance();

        //�ٴ�ͨ�������޸�����ֵ
        Field flag = SafeSingleton03.class.getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(dc,false);

        SafeSingleton03 singleCopy = dc.newInstance();

        System.out.println(single);
        System.out.println(singleCopy);
        System.out.println(single == singleCopy);
    }
}

