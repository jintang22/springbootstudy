package examples.spring.di;

public class Test01 {

    static{
        System.out.println("hello");
    }
    public Test01(){
        System.out.println("world");
    }

    public static void main(String[] args){
        System.out.println("!!!");
        Test01 test01 =new Test01();

        StaticBean staticBean = new StaticBean();
        StaticBean staticBean1 = new StaticBean();
    }

}

class StaticBean {
    static {
        System.out.println("StaticBean");
    }
}