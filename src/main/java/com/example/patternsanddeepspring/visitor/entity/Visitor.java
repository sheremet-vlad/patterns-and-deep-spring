package com.example.patternsanddeepspring.visitor.entity;

public interface Visitor {
   void visit(Programmer programmer);

   void visit(VicePresident vicePresident);

   void visit(Manager manager);

   void visit(ProjectLead projectLead);
}
