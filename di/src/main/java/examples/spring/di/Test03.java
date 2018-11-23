package examples.spring.di;

import java.lang.reflect.Method;

public class Test03 {

    public static void main(String[] args) throws Exception {
        // MyItem myItem = new MyItem();
        // myItem.setName("홍길동");
        // System.out.println(myItem.getName());

        Class clazz = Class.forName("examples.spring.di.MyItem");

        Object obj = clazz.newInstance();
        String methodName = "setName";
        Method setNameMethod = clazz.getMethod(methodName, String.class);

        setNameMethod.invoke(obj, "홍길동");

        String getMethodName = "getName";
        Method getNameMethod = clazz.getMethod(getMethodName, null);

        Object result = getNameMethod.invoke(obj, null);

        System.out.println(result);
    }
}

class MyItem {
    private String name;
    private String value;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}