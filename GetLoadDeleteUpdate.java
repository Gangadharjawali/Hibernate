package com.hibernate.example;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javassist.tools.rmi.ObjectNotFoundException;

public class GetLoadDeleteUpdate {
	public static void main(String args[]) throws Exception{
		
		//create configuration object
		Configuration con=new Configuration();
		con.configure("/hibernate.cfg.xml");
		
		//create Session-factory object
		SessionFactory sf=con.buildSessionFactory();
		
		//create session object
		Session s=sf.openSession();
		
		//get method
		Object obj=s.get(Student.class, new Integer(100));
		if(obj!= null)
		{
			System.out.println(obj.getClass().getName());
			Student std=(Student) obj;
			System.out.println();
			System.out.println(std.getSid());
			System.out.println(std.getSname());
			System.out.println(std.getSmarks());
		}
		else{
			System.out.println("records not found");
		}
		
		/*
		//load method
		Object obj1=s.load(Student.class,new Integer(101));
		Student std1=(Student) obj1;
		System.out.println(obj1.getClass().getName());
		
		System.out.println();
		System.out.println(std1.getSid());
		System.out.println(std1.getSname());
		System.out.println(std1.getSmarks());
		
		//Object not found Exception
		System.out.println("----------object2------");
		Object obj2=s.load(Student.class, new Integer(110));
		Student std2=(Student) obj2;
		System.out.println(std2.getSid());
		try{
			System.out.println(std2.getSid());
			System.out.println(std2.getSname());
			System.out.println(std2.getSmarks());
			
		}catch(Exception e){
			System.out.println("file not found"+e);
		}
		
		
		//Delete 
		org.hibernate.Transaction t1=s.beginTransaction();
		Object obj3=s.load(Student.class, new Integer(101));
		Student s3=(Student)obj3;
		s.delete(s3);
		t1.commit();
		System.out.println("record has been deleted");*/
	
		
		//update
		org.hibernate.Transaction t2=s.beginTransaction();
		Object obj4=s.load(Student.class, new Integer(100));
		Student s4=(Student)obj4;		
		s4.setSid(105);
		s4.setSname("imran");
		s4.setSmarks(200);
		s.update(s4);
		t2.commit();
		System.out.println("updated");
		
		
		
		
		
		
	}	

}
