package com.example.patternsanddeepspring.adapter.controller;

import com.example.patternsanddeepspring.adapter.BusinessCardDesigner;
import com.example.patternsanddeepspring.adapter.entity.Employee;
import com.example.patternsanddeepspring.adapter.entity.EmployeeObjectAdapter;
import com.example.patternsanddeepspring.objectPool.ObjectPool;
import com.example.patternsanddeepspring.objectPool.entity.Image;
import com.example.patternsanddeepspring.objectPool.entity.PngImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdapterObjectPoolController
{
   @Resource
   private BusinessCardDesigner businessCardDesigner;


   //See comment for abstractFactory. Make it more real
   @GetMapping("/adapter")
   public String factoryMethod() throws CloneNotSupportedException
   {

      //Try to combine already created patterns with the current one. For e.g. you can use factory here to get initialized objects
      final Employee employee = new Employee();
      populateEmployeeData(employee);
      final EmployeeObjectAdapter adapter = new EmployeeObjectAdapter(employee);

      StringBuilder resultLog = new StringBuilder("Adapter: \n");
      resultLog.append(businessCardDesigner.designCard(adapter)); // replace businessCardDesigner by JSON use Jakson lib and make spring convert object to JSON automatically

      return resultLog.toString();//return employee as a JSON
   }

   private static void populateEmployeeData(Employee employee) {
      employee.setFullName("Elliot Alderson");
      employee.setJobTitle("Security Engineer");
      employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
   }
}

