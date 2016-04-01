package com.jingzing.abby;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Louis Wang on 2016/4/1.
 */
@Component
public class MyBean implements CommandLineRunner{

    @Value("${name}")
    private String name;

    public void run(String... strings) throws Exception {
        System.out.println("MyBean.run....");
    }
}
