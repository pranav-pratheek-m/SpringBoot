package com.pranav.maven.SpringAnnotations;

import org.springframework.stereotype.Component;

@Component
public class MediaTech implements MobileProcessor {

	public void process() {
		System.out.println("Competitor for the top processor..");

	}

}
