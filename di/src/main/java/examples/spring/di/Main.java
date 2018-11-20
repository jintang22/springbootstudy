package examples.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args){

        // XML 설정 파일을ㄹ 읽어들이는 Spring ApplicationContext를 생성한다.
        // resources, java폴더는 CLASSPATH에 해당한다.
        // ClassLoader를 이용하면 CLASSPATH에 있는 파일을 읽어들일 수 있다.

        ApplicationContext applicationiContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        //Dice dice = applicationiContext.getBean("dice", Dice.class);
        //System.out.println(dice.getNumber());

        //applicationiContext.getBean("kim", Player.class).roll();
        //applicationiContext.getBean("lee", Player.class).roll();
        //applicationiContext.getBean("hong", Player.class).roll();
        applicationiContext.getBean("game", Game.class).play();
        applicationiContext.getBean(Game.class).play();

    }
}
