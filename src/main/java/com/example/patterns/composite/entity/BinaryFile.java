package com.example.patterns.composite.entity;

//Leaf node in composite pattern
public class BinaryFile extends File{
	private int size;

   public BinaryFile(String name, int size)
   {
      super(name);
      this.size = size;
   }

   @Override
   public void ls()
   {
      System.out.println(String.format("file: %s - %s", getName(), size));
   }

   @Override
   public void addFile(File file)
   {
      throw new UnsupportedOperationException();
   }

   @Override
   public File[] getFiles()
   {
      throw new UnsupportedOperationException();
   }

   @Override
   public boolean removeFile(File file)
   {
      throw new UnsupportedOperationException();
   }

   public int getSize()
   {
      return size;
   }

   public void setSize(int size)
   {
      this.size = size;
   }
}
