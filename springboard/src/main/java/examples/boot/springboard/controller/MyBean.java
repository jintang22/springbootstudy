package examples.boot.springboard.controller;

import org.springframework.stereotype.Component;

@Component
public class MyBean {

    public MyBean() {

        System.out.println("MyBean 생성");
    }
}
