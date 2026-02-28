package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context =  new ClassPathXmlApplicationContext("spring.xml");
        Vehicle obj = (Vehicle) context.getBean("car");
        obj.Drive();

        Vehicle obj2 =(Vehicle) context.getBean("bike");
        obj2.Drive();

        Tyre t1 =(Tyre) context.getBean("tyre");
        System.out.println(t1);



    }
}
