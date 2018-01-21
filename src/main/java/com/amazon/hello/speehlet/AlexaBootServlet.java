/**
 * 
 */
package com.amazon.hello.speehlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import com.amazon.speech.speechlet.servlet.SpeechletServlet;

/**
 * invoking service methods
 * 
 */
public class AlexaBootServlet extends SpeechletServlet {

	private static final long serialVersionUID = 1L;
	
	private Logger LOG = LoggerFactory.getLogger(AlexaBootServlet.class);

	private static final Set<String> supportedApplicationIds = new HashSet<String>();
	static {
		/*
		 * This Id can be found on https://developer.amazon.com/edw/home.html#/ "Edit"
		 * the relevant Alexa Skill and put the relevant Application Ids in this Set.
		 */
		supportedApplicationIds.add("amzn1.ask.skill.*********************");
	}

	private ApplicationContext appContext;
	private MyCustomSpeechlet mySpeechlet;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init();
		appContext = (ApplicationContext) config.getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		mySpeechlet = (MyCustomSpeechlet) appContext.getBean("mySpeechlet");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getOutputStream().write("Hello !!".getBytes());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

		LOG.debug("Executing doPost method ");

		try {
			this.setSpeechlet(mySpeechlet);
		} catch (Exception exp) {
			LOG.error("Failed and got exception..");
			exp.printStackTrace();
		}

		super.doPost(request, response);
	}
}
