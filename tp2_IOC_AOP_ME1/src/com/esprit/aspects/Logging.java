package com.esprit.aspects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class Logging {
	
	File f;
	FileOutputStream fos;
	
	@PostConstruct
	public void init()
	{
		
		f = new File("logging.txt");
		
		try {
			fos = new FileOutputStream(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Before("execution(* com.esprit.Services.AuthenticatorAgent.authenticate(..))")
	   public void beforeAuth(){
		  String toLog = "LOGGING @"+(new Date()).toString()+" =>*******************BEGINNING AUTHENTICATION PROCESS********************\n";
	      System.out.println(toLog);
	      
	      try {
			fos.write(toLog.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   }
	
	@After("execution(* com.esprit.Services.AuthenticatorAgent.authenticate(..))")
	   public void afterAuth(){
		  String toLog = "LOGGING @"+(new Date()).toString()+" =>*******************END OF AUTHENTICATION PROCESS********************\n";
	      System.out.println(toLog);
	      try {
				fos.write(toLog.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	@AfterReturning(pointcut="execution(* com.esprit.Services.AuthenticatorAgent.authenticate(..))",returning="value")
	   public void afterAuth(JoinPoint jp, Object value) throws Throwable{
		String username = jp.getArgs()[0].toString();
		  String password  = jp.getArgs()[1].toString();
		  boolean success = (boolean) value;
		  String toLog = "LOGGING @"+(new Date()).toString()+" =>*******************Authentication using username: \""+username+"\" and password:\""+password+"\" "+(success == true? " SUCCESSFUL" : " FAILURE")+"********************\n"; 
	      System.out.println(toLog);
	      try {
				fos.write(toLog.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	
	@Before("execution(* com.esprit.Services.AuthenticatorAgent.authenticate(..))")
	   public void beforeAuthParameters(JoinPoint jointpoint){
		  String username = jointpoint.getArgs()[0].toString();
		  String password  = jointpoint.getArgs()[1].toString();
		  
		  String toLog = "LOGGING @"+(new Date()).toString()+" =>*******************Beginning Authentication using username: \""+username+"\" and password:\""+password+"\"********************\n";
	      System.out.println(toLog);
	      try {
				fos.write(toLog.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	
	@Around("execution(* com.esprit.Services.AuthenticatorAgent.authenticate(..))")
	   public Object executionTimeAuth(ProceedingJoinPoint  pjp) throws Throwable{
		  StopWatch interval = new StopWatch();
		  interval.start();
		  Object returnValue =	pjp.proceed();
		  interval.stop();
		  String toLog = "LOGGING @"+(new Date()).toString()+" =>******************AUTHENTICATION PROCESS EXECUTION TIME (IN SECONDS): "+interval.getTotalTimeSeconds()+"********************\n";
	      System.out.println(toLog);
	      try {
				fos.write(toLog.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	      return returnValue;
	   }

}
