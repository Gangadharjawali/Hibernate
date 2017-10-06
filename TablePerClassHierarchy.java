package com.hibernate.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TablePerClassHierarchy {

	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		cfg.configure("/hibernate.cfg.xml");

		// session factory for to get physical connection with database
		SessionFactory sessionfact = cfg.buildSessionFactory();

		Session session = sessionfact.openSession();

		Transaction transaction = session.beginTransaction();

		TemporyEmployee temporyEmployee1 = addTemporyEmployee(1, "siddu", "nilesh", 30);
		TemporyEmployee tempE2 = addTemporyEmployee(2, "nilesh", "parag", 35);
		TemporyEmployee tempE3 = addTemporyEmployee(4, "gagan", "abc", 35);

		PermanentEmployee permE1 = addPermanentEmployee(5, "abc", "dfg", "cse");
		PermanentEmployee permE2 = addPermanentEmployee(6, "adg", "kiran", "ise");
		PermanentEmployee permE3 = addPermanentEmployee(7, "sfd", "kiran", "cse");
		
		session.save(temporyEmployee1);
		session.save(tempE2);
		session.save(tempE3);
		
		session.save(permE1);
		session.save(permE2);
		session.save(permE3);
		
		transaction.commit();
		session.close();
		System.out.println("objects saved");

	}

	static TemporyEmployee addTemporyEmployee(int employeeId, String employeeName, String contractorName,
			int workingDays) {
		TemporyEmployee temporyEmployee = new TemporyEmployee();
		temporyEmployee.setEmployeeId(employeeId);
		temporyEmployee.setEmployeeName(employeeName);
		temporyEmployee.setContractorName(contractorName);
		temporyEmployee.setWorkingDays(workingDays);
		return temporyEmployee;
	}

	static PermanentEmployee addPermanentEmployee(int employeeId, String employeeName, String designation,
			String department) {
		PermanentEmployee permanentEmployee = new PermanentEmployee();
		permanentEmployee.setEmployeeId(employeeId);
		permanentEmployee.setEmployeeName(employeeName);
		permanentEmployee.setDesignation(designation);
		permanentEmployee.setDepartment(department);
		return permanentEmployee;

	}

}
