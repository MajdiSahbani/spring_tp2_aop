package com.esprit.bootstap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.esprit.IServices.Authenticator;
import com.esprit.Providers.MockAuthenticationProvider;
import com.esprit.Services.AuthenticatorAgent;
import com.esprit.entities.User;



public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		User admin = (User) context.getBean("admin");
		System.out.println("ADMIN:\n"+admin+"\n");
		User user = (User) context.getBean("user");
		System.out.println("USER:\n"+user+"\n");
		System.out.println("*******************************************\n");
		
		//AuthenticatorAgent authenticationAgentSpring = (AuthenticatorAgent) context.getBean("AuthenticatorAgent");
		// AOP
		Authenticator authenticationAgentSpring = (Authenticator) context.getBean("AuthenticatorAgent");
		System.out.println("AUTHENTICATING ADMIN USING SPRING AUTHENTICATION PROVIDER: " +authenticationAgentSpring.authenticate("admin", "adminpassword"));
		System.out.println("AUTHENTICATING USER USING SPRING AUTHENTICATION PROVIDER: " +authenticationAgentSpring.authenticate("user", "userpassword"));
		System.out.println("AUTHENTICATING ADMIN USING SPRING AUTHENTICATION PROVIDER WITH WRONG CREDENTIALS: " +authenticationAgentSpring.authenticate("adminS", "adminpassword"));
		System.out.println("AUTHENTICATING USER USING SPRING AUTHENTICATION PROVIDER WITH WRONG CREDENTIALS: " +authenticationAgentSpring.authenticate("userS", "userpassword"));
		System.out.println("*********************************************\n");
		
		/*
		AuthenticatorAgent authenticationAgentMock =  (AuthenticatorAgent) context.getBean("AuthenticatorAgent");
		System.out.println("AUTHENTICATING ADMIN USING MOCK AUTHENTICATION PROVIDER: " +authenticationAgentMock.authenticate("akram", "akrampassword"));
		System.out.println("AUTHENTICATING USER USING MOCK AUTHENTICATION PROVIDER: " +authenticationAgentMock.authenticate("nemesis", "nemesispassword"));
		System.out.println("AUTHENTICATING ADMIN USING MOCK AUTHENTICATION PROVIDER: " +authenticationAgentMock.authenticate("Sakram", "akrampassword"));
		System.out.println("AUTHENTICATING USER USING MOCK AUTHENTICATION PROVIDER: " +authenticationAgentMock.authenticate("Snemesis", "nemesispassword"));
		*/
		

	}

}
