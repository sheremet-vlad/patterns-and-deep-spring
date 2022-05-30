package com.example.patternsanddeepspring.memento.controller;

import com.example.patternsanddeepspring.mediator.entity.Label;
import com.example.patternsanddeepspring.mediator.entity.Slider;
import com.example.patternsanddeepspring.mediator.entity.TextBox;
import com.example.patternsanddeepspring.mediator.entity.UIMediator;
import com.example.patternsanddeepspring.memento.entity.WorkflowDesigner;
import com.example.patternsanddeepspring.memento.entity.command.AddStepCommand;
import com.example.patternsanddeepspring.memento.entity.command.CreateCommand;
import com.example.patternsanddeepspring.memento.entity.command.WorkflowCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class MementoController
{

   @GetMapping("/memento")
   public String mediator()
   {
      WorkflowDesigner designer = new WorkflowDesigner();
      LinkedList<WorkflowCommand> commands = runCommands(designer);
      designer.print();
      undoLastCommand(commands);
      designer.print();
      undoLastCommand(commands);
      designer.print();
      undoLastCommand(commands);
      designer.print();
      undoLastCommand(commands);
      designer.print();
      undoLastCommand(commands);
      designer.print();

      return "result printed to the console";
   }


   private void undoLastCommand(LinkedList<WorkflowCommand> commands) {
      if(!commands.isEmpty())
         commands.removeLast().undo();
   }

   private LinkedList<WorkflowCommand> runCommands(WorkflowDesigner designer) {
      LinkedList<WorkflowCommand> commands = new LinkedList<>();

      WorkflowCommand cmd = new CreateCommand(designer,"Leave Workflow");
      commands.addLast(cmd);
      cmd.execute();

      cmd = new AddStepCommand(designer,"Create Leave Application");
      commands.addLast(cmd);
      cmd.execute();

      cmd = new AddStepCommand(designer,"Submit Application");
      commands.addLast(cmd);
      cmd.execute();

      cmd = new AddStepCommand(designer,"Application Approved");
      commands.addLast(cmd);
      cmd.execute();

      return commands;
   }
}

