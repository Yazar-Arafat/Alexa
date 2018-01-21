package com.amazon.hello.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazon.hello.speehlet.MyCustomSpeechlet;
import com.amazon.speech.speechlet.servlet.SpeechletServlet;

/**
 * Registers the servlet with our custom speechlet
 *
 */
@Configuration
public class SkillConfig {

	@Autowired
	private MyCustomSpeechlet mySpeechlet;

	@Bean
	public ServletRegistrationBean registerServlet() {

		SpeechletServlet speechletServlet = new SpeechletServlet();
		speechletServlet.setSpeechlet(mySpeechlet);

		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(speechletServlet, "/alexa");
		return servletRegistrationBean;
	}

}
