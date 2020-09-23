package com.pranav.maven.SpringAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired
	//@Qualifier("snapdragon")
	@Qualifier("mediaTech")
	MobileProcessor mobpro;
	
	public void config() {
		System.out.println("Octa Core,4GB RAM,12MP Camera");
		mobpro.process();
	}

	public MobileProcessor getMobpro() {
		return mobpro;
	}

	public void setMobpro(MobileProcessor mobpro) {
		this.mobpro = mobpro;
	}
}
