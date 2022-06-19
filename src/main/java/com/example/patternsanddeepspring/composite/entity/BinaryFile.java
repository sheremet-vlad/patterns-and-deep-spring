package com.example.patternsanddeepspring.composite.entity;

//Leaf node in composite pattern
public class BinaryFile extends File{
	private int size; // protected field for File

   public BinaryFile(String name, int size)
   {
      super(name);// super(name, size)
      this.size = size;
   }

   @Override
   public void ls()
   {
      System.out.println(String.format("file: %s - %s", getName(), size));
   } //String -> MessageFormat

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
