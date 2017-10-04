package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class StudentClient
{
  public static void main(String[] args) throws Exception{
	
	//create configuration object
    Configuration c = new Configuration();
    c.configure("/hibernate.cfg.xml");
    
    //create session factory object
    SessionFactory sf=c.buildSessionFactory();
    
    //create session object
    Session s = sf.openSession();
                           
    //create transaction object
    Transaction tx = s.beginTransaction();
 
    try
    {
      Student std1=new Student();
   
      std1.setSname("Ganesh");
      std1.setSmarks(70);

 
    
 
      s.save(std1);                              
   
      tx.commit(); // con.commit();
      System.out.println("Records inserted");
    }
    catch(Exception e)
    {
      tx.rollback();                           
    }
  }
}

