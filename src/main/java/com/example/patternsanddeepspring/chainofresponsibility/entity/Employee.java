package com.example.patternsanddeepspring.chainofresponsibility.entity;

//Abstract handler
//why abstract?
public abstract class Employee implements LeaveApprover{

	private String role;// protected
	
	private LeaveApprover successor; // protected
	
	public Employee(String role, LeaveApprover successor) {
		this.role = role;
		this.successor = successor;
	} // so you need this constructor if protected fields?
	
	@Override
	public void processLeaveApplication(LeaveApplication application) { // could be a default method inside interface
		if(!processRequest(application) && successor != null) {
			successor.processLeaveApplication(application);
		}
	}

	protected abstract boolean processRequest(LeaveApplication application); // why not a part of interface?
	
	@Override
	public String getApproverRole() {
		return role;
	}

	
}