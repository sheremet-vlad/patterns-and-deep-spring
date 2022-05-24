package com.example.patternsanddeepspring.composite.controller;

import com.example.patternsanddeepspring.composite.entity.BinaryFile;
import com.example.patternsanddeepspring.composite.entity.Directory;
import com.example.patternsanddeepspring.composite.entity.File;
import com.example.patternsanddeepspring.decorator.entity.HtmlEncodedMessage;
import com.example.patternsanddeepspring.decorator.entity.Message;
import com.example.patternsanddeepspring.decorator.entity.TextMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComposeController
{

   @GetMapping("/composite")
   public String composite()
   {
      final File dir1 = createTreeOne();
      final File dir2 = createTreeTwo();

      dir1.ls();
      dir2.ls();

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

