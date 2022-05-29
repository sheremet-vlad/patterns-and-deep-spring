package com.example.patternsanddeepspring.command.controller;

import com.example.patternsanddeepspring.command.entity.AddMemberCommand;
import com.example.patternsanddeepspring.command.entity.Command;
import com.example.patternsanddeepspring.command.entity.EWSService;
import com.example.patternsanddeepspring.command.entity.MailTasksRunner;
import com.example.patternsanddeepspring.composite.entity.BinaryFile;
import com.example.patternsanddeepspring.composite.entity.Directory;
import com.example.patternsanddeepspring.composite.entity.File;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CommandController
{
   @Resource
   private MailTasksRunner mailTasksRunner;

   @Resource
   private EWSService ewsService;

   @GetMapping("/command")
   public String command() throws InterruptedException
   {
      final Command command1 = new AddMemberCommand("a", "aGroup", ewsService);
      final Command command2 = new AddMemberCommand("b", "bGroup", ewsService);

      mailTasksRunner.addCommand(command1);
      mailTasksRunner.addCommand(command2);

      Thread.sleep(3000);
      mailTasksRunner.shutdown();

      return "result was print to the console";
   }

   private static File createTreeOne() {
      File file1 = new BinaryFile("File1", 1000);
      Directory dir1 = new Directory("dir1");
      dir1.addFile(file1);
      File file2 = new BinaryFile("file2", 2000);
      File file3 = new BinaryFile("file3", 150);
      Directory dir2 = new Directory("dir2");
      dir2.addFile(file2);
      dir2.addFile(file3);
      dir2.addFile(dir1);
      return dir2;
   }

   private static File createTreeTwo() {
      return new BinaryFile("Another file", 200);
   }
}

