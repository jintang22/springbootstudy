package examples.spring.di;


public class Test02 {

    public static void main(String [] args) throws Exception{

        Class.forName("examples.spring.di.MyDriver2");
        Class.forName("examples.spring.di.MyDriver");
        System.out.println(MyDriverManager.getName());

    }
}

class MyDriver{
    static{
        MyDriverManager.setName("홍길동");
    }
}

class MyDriver2{
    static{
        MyDriverManager.setName("김진태");
    }
}

class MyDriverManager{
    private static String name;

    public  static  void setName(String name){
        MyDriverManager.name = name;
    }

    public static String getName(){
        return MyDriverManager.name;
    }
}