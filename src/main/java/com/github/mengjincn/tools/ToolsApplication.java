package com.github.mengjincn.tools;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class ToolsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToolsApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(){
        return args -> {
            System.out.println(CountryEnum.getByName("ONE").getMessage());
            System.out.println(CountryEnum.getByName("ONE").compareTo(CountryEnum.TWO));
            System.out.println(CountryEnum.getByName("ONE").name());
            System.out.println(CountryEnum.getByName("ONE").ordinal());
            System.out.println(CountryEnum.getByName("ONE"));
            System.out.println(CountryEnum.getByOrdinal(1));

            // Caused by: java.lang.IllegalArgumentException: No enum constant com.github.mengjincn.tools.CountryEnum.THREE
            // System.out.println(CountryEnum.getByName("THREE"));
            // return null
            // System.out.println(CountryEnum.getByOrdinal(2));

            System.out.println("just start");


            BlockingQueue<String> synchronousBlockingQueue=new SynchronousQueue<>();

            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+"\t put 1");
                    synchronousBlockingQueue.put("1");

                    System.out.println(Thread.currentThread().getName()+"\t put 2");
                    synchronousBlockingQueue.put("2");

                    System.out.println(Thread.currentThread().getName()+"\t put 3");
                    synchronousBlockingQueue.put("3");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "AAA").start();

            new Thread(()->{
                try {
                    for (int i = 0; i < 3; i++) {
                        TimeUnit.SECONDS.sleep(5);
                        System.out.println(Thread.currentThread().getName()+"\t take "+ synchronousBlockingQueue.take());
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "BBB").start();
        };
    }

}
