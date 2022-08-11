package com.example.patterns.command.entity;

//A Concrete implementation of Command.
public class AddMemberCommand implements Command{
		private String contact;
      private String group;
      private EWSService ewsService;

   public AddMemberCommand(String contact, String group,
            EWSService ewsService)
   {
      this.contact = contact;
      this.group = group;
      this.ewsService = ewsService;
   }

   @Override
   public void execute()
   {
      ewsService.addMember(contact, group);
   }
}
