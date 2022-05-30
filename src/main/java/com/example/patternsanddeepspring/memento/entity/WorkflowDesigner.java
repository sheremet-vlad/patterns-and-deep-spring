package com.example.patternsanddeepspring.memento.entity;

public class WorkflowDesigner
{

   private Workflow workflow;

   public void createWorkflow(String name)
   {
      workflow = new Workflow(name);
   }

   public Workflow getWorkflow()
   {
      return this.workflow;
   }

   public Memento getMemento()
   {
      if (workflow == null)
      {
         return new Memento();
      }
      return new Memento(workflow.getSteps(), workflow.getName());
   }

   public void setMemento(Memento memento)
   {
      if (memento.isEmpty())
      {
         workflow = null;
      }
      else
      {
         workflow = new Workflow(workflow.getName(), workflow.getSteps());
      }
   }

   public void addStep(String step)
   {
      workflow.addStep(step);
   }

   public void removeStep(String step)
   {
      workflow.removeStep(step);
   }

   public void print()
   {
      System.out.println(workflow);
   }

   public class Memento
   {
      private String[] steps;

      private String name;

      public Memento()
      {
      }

      public Memento(String[] steps, String name)
      {
         this.steps = steps;
         this.name = name;
      }

      public String[] getSteps()
      {
         return steps;
      }

      private boolean isEmpty()
      {
         return steps == null && name == null;
      }
   }
}
