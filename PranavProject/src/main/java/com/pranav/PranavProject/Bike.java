package com.pranav.PranavProject;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
	
   public void drive() {
	   System.out.println("Bike is working..");
   }
}
