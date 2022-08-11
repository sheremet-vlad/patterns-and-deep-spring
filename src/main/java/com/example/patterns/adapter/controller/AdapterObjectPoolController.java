package com.example.patterns.adapter.controller;

import com.example.patterns.adapter.BusinessCardDesigner;
import com.example.patterns.adapter.entity.Employee;
import com.example.patterns.adapter.entity.EmployeeObjectAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AdapterObjectPoolController
{
   @Resource
   private BusinessCardDesigner businessCardDesigner;

   @GetMapping("/adapter")
   public String factoryMethod() throws CloneNotSupportedException
   {
      final Employee employee = new Employee();
      populateEmployeeData(employee);
      final EmployeeObjectAdapter adapter = new EmployeeObjectAdapter(employee);

      StringBuilder resultLog = new StringBuilder("Adapter: \n");
      resultLog.append(businessCardDesigner.designCard(adapter));

      return resultLog.toString();
   }

   private static void populateEmployeeData(Employee employee) {
      employee.setFullName("Elliot Alderson");
      employee.setJobTitle("Security Engineer");
      employee.setOfficeLocation("Allsafe Cybersecurity, New York City, New York");
   }
}

