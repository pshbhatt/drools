package com.income.tax.calc;

import java.util.Scanner;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;



public class IncomeTaxCalculation {
public static void main(String[] args) {
	KieServices ks = KieServices.Factory.get();
    KieContainer kContainer = ks.getKieClasspathContainer();
	KieSession kSession = kContainer.newKieSession("ksession-dtables");
	Traits traits = new Traits();
	Scanner input = new Scanner(System.in);
	System.out.println("Enter Name: ");
	String name = input.nextLine();
	System.out.println("Enter age: ");
	int age = input.nextInt();
	traits.setAge(age);
	System.out.println("Enter income: ");
	int income  = input.nextInt();
	traits.setIncome(income);
	System.out.println("Married (Y/N):");
	String isMarried = input.next();
	traits.setIsMarried(isMarried);
	System.out.println("Enter the number of Offsprings: ");
	int numberKids = input.nextInt();
	traits.setNumberOfKids(numberKids);
	kSession.insert(traits);
	kSession.fireAllRules();
	System.out.println(traits.getRate());
}
public static class Traits {
private int age;
private int income;
private String state;
private String isMarried;
private int numberOfKids;
private int rate;

public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public int getIncome() {
	return income;
}
public void setIncome(int income) {
	this.income = income;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public int getNumberOfKids() {
	return numberOfKids;
}
public void setNumberOfKids(int numberOfKids) {
	this.numberOfKids = numberOfKids;
}
public String getIsMarried() {
	return isMarried;
}
public void setIsMarried(String isMarried) {
	this.isMarried = isMarried;
}

}
}

