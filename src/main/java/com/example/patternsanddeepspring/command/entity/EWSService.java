package com.example.patternsanddeepspring.command.entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

//This class is the receiver.
@Service
@Scope("prototype")
public class 	EWSService {

	//Add a new member to mailing list
	public void addMember(String contact, String contactGroup) {
		//contact exchange
		System.out.println("Added "+contact +" to "+contactGroup);
	}
	
	//Remove member from mailing list
	public void removeMember(String contact, String contactGroup) {
		//contact exchange
		System.out.println("Removed "+contact +" from "+contactGroup);
	}
}
