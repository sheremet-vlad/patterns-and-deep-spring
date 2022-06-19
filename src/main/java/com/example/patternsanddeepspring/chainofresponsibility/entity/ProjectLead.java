package com.example.patternsanddeepspring.chainofresponsibility.entity;

//A concrete handler
//It's not a handler. It's DTO or model. Bad idea to have business logic here
public class ProjectLead extends Employee{

	public ProjectLead(LeaveApprover successor) {
		super("Project Lead", successor);
	}
	
	@Override
	protected boolean processRequest(LeaveApplication application) {
		//type is sick leave & duration is less than or equal to 2 days
		if(application.getType() == LeaveApplication.Type.Sick) {
			if(application.getNoOfDays() <= 2) {
				application.approve(getApproverRole());
				return true;
			}
		}
		return false;
	}

	
	
}
