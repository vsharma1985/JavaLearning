package com.sample.learning;

public class Employee {
	
	private String name;
    private String account;
    private Integer salary;
 
    public Employee(String name, String account, Integer salary) {
        super();
        this.name = name;
        this.account = account;
        this.salary = salary;
    }
 
    @Override
    public String toString() {
 
        return "name: "+ this.name +" | account: "+ this.account +" | salary: "+this.salary;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getAccount() {
        return account;
    }
 
    public void setAccount(String account) {
        this.account = account;
    }
 
    public Integer getSalary() {
        return salary;
    }
 
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
