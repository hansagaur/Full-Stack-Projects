package com.greatlearning.main;

import java.util.Scanner;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;
import com.greatlearning.service.CredentialService;

public class AppMain {

	public static void main(String[] args) {
		//Entry point
		Employee demoEmployee = new Employee("Taylor" , "Swift");
		ICredentials credentialService = new CredentialService();
		
		//user input options for department
        System.out.println("Please choose the department from the following: ");
        System.out.println("1. Technical");
        System.out.println("2. Administration");
        System.out.println("3. Human Resourse");
        System.out.println("4. Legal");
        
        Scanner userInput = new Scanner(System.in);
        int option = userInput.nextInt();
        
        String generatedEmail = null;
        String generatedPassword = null;
        
        switch(option)
        {
        case 1: 
        {
        	//this is technical dept and short as tech.
        	generatedEmail = credentialService.generateEmailAddress(demoEmployee.getFirstName().toLowerCase(), 
        			                     demoEmployee.getLastName().toLowerCase(),"tech");
        	generatedPassword = credentialService.generatePassword();
        	break;
        }
        case 2: 
        {
        	//this is administration department and short as admin.
        	generatedEmail = credentialService.generateEmailAddress(demoEmployee.getFirstName().toLowerCase(), 
        			                     demoEmployee.getLastName().toLowerCase(),"admin");
        	generatedPassword = credentialService.generatePassword();
        	break;
        }
        case 3: 
        {
        	//this is Human Resource department and short as hr.
        	generatedEmail = credentialService.generateEmailAddress(demoEmployee.getFirstName().toLowerCase(), 
        			                     demoEmployee.getLastName().toLowerCase(),"hr");
        	generatedPassword = credentialService.generatePassword();
        	break;
        }
        case 4: 
        {
        	//this is legal dept and short as lg.
        	generatedEmail = credentialService.generateEmailAddress(demoEmployee.getFirstName().toLowerCase(), 
        			                     demoEmployee.getLastName().toLowerCase(),"lg");
        	generatedPassword = credentialService.generatePassword();
        	break;
        }
        default :
        {
        	System.out.println("Enter valid department option!");
        }
        }
        
        demoEmployee.setEmail(generatedEmail);
        demoEmployee.setDepartment(generatedPassword);
        credentialService.showCredentials(demoEmployee);
        
	}

}
