package com.pranav.PranavProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/pranav/PranavProject/spring.xml");
    	
//    	Vehicle obj = (Vehicle)context.getBean("car");
//    	obj.drive();
//    	
//    	obj = (Vehicle)context.getBean("bike");
//    	obj.drive();
//    	
//    	Tyre tyre = (Tyre)context.getBean("tyre");
//    	System.out.println(tyre);
    	
    	Car car = (Car)context.getBean("car");
    	car.drive();
    }
}
