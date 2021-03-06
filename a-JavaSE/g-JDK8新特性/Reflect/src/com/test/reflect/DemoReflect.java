package com.test.reflect;

import	java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class DemoReflect {
    public static void main(String[] args) {
        String path = "com.test.reflect.User";
        try {
            Class<User> cls2 = User.class;//拿到类的对象

            Class<?> cls1 = path.getClass();
            Class<?> cls3 = Class.forName("java.util.Date");
            System.out.println(cls3);
            System.out.println(cls1);
            System.out.println(cls2);

            //取得类的属性
            Field[] fields = cls2.getDeclaredFields();
            System.out.println(fields.length);

            //通过反射API调用构造方法

            /**
             * newInstance()也是用来创建新的对象,其与new()的区别是:
             *
             * newInstance():弱类型,效率低,只能调用无参构造
             *
             * new():强类型,高效率,能调用任何public构造器
             */
            User u = cls2.newInstance();
            System.out.println(u);
            //指定构造器
            Constructor<User> use = cls2.getDeclaredConstructor(int.class, int.class,String.class);
            User u2 = use.newInstance(2019,21,"Mr.Q");
            System.out.println("\n" + u2.getName());



            //通过反射API来调用普通方法
            //----> 正向调用   u3.setName("IQQCode")

            /**
             * 反射的好处是只传入方法名，传入的方法和参数都是变量，就可以动态的调用相关的方法
             */
            User u3 = cls2.newInstance();
            Method method = cls2.getDeclaredMethod("setName", String.class);
            method.invoke(u3,"IQQCode");
            System.out.println(u3.getName());



            //通过反射API操作属性
            User u4 = cls2.newInstance();
            Field field = cls2.getDeclaredField("name");
            field.setAccessible(true);  //直接访问到私有属性，跳过安全检查
            field.set(u4,"犹梦");  //通过反射直接写属性
            System.out.println(field.get(u4));  //通过反射直接读属性


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
