package com.greatlearning.service;

import java.util.Random;

import com.greatlearning.interfaces.ICredentials;
import com.greatlearning.model.Employee;

public class CredentialService implements ICredentials{

	@Override
	public String generateEmailAddress(String firstName, String lastName, String department) {
		// firstName+lastName+@+dept.companyname.com
		String atSymbol = "@";
		String companyName = ".gl";
		String emailAddress = firstName+lastName+atSymbol+department+companyName+".com";
		return emailAddress;
	}

	@Override
	public String generatePassword() {
		String capitalLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String smallLetters = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "1234567890";
		String specialCharacters = "!@#$%^&*_-+=?/>.<";
		
		String allValues = capitalLetters + smallLetters + numbers + specialCharacters;
		
		Random RandomObj = new Random();
		String password = "";
		
		for(int i=0;i<8;i++)
		{
			int boundValues = allValues.length();
			int randomIndex = RandomObj.nextInt(boundValues);
			char randomChar = allValues.charAt(randomIndex);
			password += String.valueOf(randomChar);
		}
		
		return password;
	}

	@Override
	public void showCredentials(Employee employee) {
		// display email, password and some welcome message
		System.out.println("Dear"+  employee.getFirstName() +"your generated credentials are as follows:" );
		System.out.println("Email: " + employee.getEmail());
		System.out.println("Password: " + employee.getPassword());
		
	}

}
