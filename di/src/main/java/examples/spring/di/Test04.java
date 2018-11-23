package examples.spring.di;

import java.lang.reflect.Method;

public class Test04 {

    public static void main(String[] args) throws Exception {

        int i = 2;

        String className = "examples.spring.di.MyChild"+i;


        Class clazz = Class.forName(className);

        Object object = clazz.newInstance();

        Method printmethod = clazz.getMethod("print", null);

        printmethod.invoke(object, null);

    }
}

class MyChild1{
    public void print(){
        System.out.println("child1");
    }
}

class MyChild2{
    public void print(){
        System.out.println("child2");
    }
}