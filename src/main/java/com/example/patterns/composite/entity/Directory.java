package com.example.patterns.composite.entity;

import java.util.ArrayList;
import java.util.List;

//Composite in the composite pattern
public class Directory extends File{
	private List<File> files;

   public Directory(String name)
   {
      super(name);
      this.files = new ArrayList<>();
   }

   @Override
   public void ls()
   {
      System.out.println("name: " + getName());
      files.forEach(File::ls);
   }

   @Override
   public void addFile(File file)
   {
      files.add(file);
   }

   @Override
   public File[] getFiles()
   {
      return files.toArray(File[]::new);
   }

   @Override
   public boolean removeFile(File file)
   {
      return files.remove(file);
   }

   public void setFiles(List<File> files)
   {
      this.files = files;
   }
}
