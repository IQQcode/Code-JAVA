package top.iqqcode.basic01;

import top.iqqcode.domain.Coffee;

/**
 * @Author: iqqcode
 * @Date: 2020-12-23 15:30
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        CoffeeHub hub = new CoffeeHub();
        Coffee coffee = hub.orderCoffee("latte");
        System.out.println(coffee);
    }
}
