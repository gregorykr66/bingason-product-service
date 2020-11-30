package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class Main {

    @RequestMapping("/")
    String index() {
        return "Running";
    }

    public static void main(String[] args) throws Exception {
        Service.service(new Subscription[]{
                new Subscription("product", "fetch-product", (body, sender) -> {
                    System.out.println("product: fetch-product");
                    sender.send("display", "SESSION_ID,product,PRODUCT_ID,Coffee");
                })
        });

        SpringApplication.run(Main.class, args);
    }

}
