package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TreeLevelTravel {
    public static void main(String[] args) {
        int n=5;
        method(n);
        System.out.println(n);

        String str = "hello";
        method2(str);
        System.out.println(str);

        StringBuilder sb = new StringBuilder("iphone");
        method3(sb);
        System.out.println(sb);

        String string = "iphone";
        method4(string);
        System.out.println(string);

        Object o =new Object();
        o.hashCode();
        Object o2 =new Object();
        o2.hashCode();
        System.out.println(o.hashCode());
        System.out.println(o2.hashCode());


        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("obj1哈希值:"+ obj1.hashCode());
        System.out.println("obj2哈希值:"+ obj2.hashCode());
        System.out.println("obj1和obj2比较==：" + obj1.equals(obj2));//地址不同 为false
        System.out.println("obj1和obj2比较equals：" + obj1.equals(obj2));// == 为false
        String str1 ="123";
        String str2 ="123";
        String str3 = new String("123");
        String str4 = new String("123");
        System.out.println("str1哈希值:" + str1.hashCode());
        System.out.println("str2哈希值:" + str2.hashCode());
        System.out.println("str3哈希值:" + str3.hashCode());
        System.out.println("str4哈希值:" + str4.hashCode());
        System.out.println("str1和str2比较==：" + (str1 == str2));
        System.out.println("str1和str3比较==：" + (str1 == str3)); //地址不同 为false
        System.out.println("str4和str3比较==：" + (str4 == str2)); //地址不同 为false
        System.out.println("str1和str2比较equals：" + str1.equals(str2));// ==为true
        System.out.println("str1和str3比较equals：" + str1.equals(str3));// ==为flase 但string重写equals方法 比较字符发现相等 为true
        System.out.println("str4和str3比较equals：" + str4.equals(str3));// ==为false 但string重写equals方法 比较字符发现相等 为true
        Integer int1 = new Integer(100);
        Integer int2 = new Integer(100);
        System.out.println("包装类型int1哈希值:"+int1.hashCode());
        System.out.println("包装类型int2哈希值:"+int2.hashCode());
        System.out.println("包装类型int1和int2比较==：" + (int1 == int2)); //地址不同 为false
        System.out.println("包装类型int1和int2比较equal：" + (int1.equals(int2))); //重写equals方法，值相等 为true
        int a = 5;
        int b = 5;
        System.out.println("a和b比较==："+ (a == b));

        ArrayList list = new ArrayList();
        list.add(1);
        int num = (Integer) list.get(0);
        System.out.println(num);

    }
    public static void method(int a){
        a = 3;
    }

    public static void method2(String text){
        text = "f";
    }

    public static void method3(StringBuilder builder){
        builder.append(4);
    }

    public static void method4(String s){
        s = s + 5 ;
    }
}
