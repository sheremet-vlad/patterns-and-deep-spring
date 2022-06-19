package com.example.patternsanddeepspring.abstractFactory.entity.aws;

import com.example.patternsanddeepspring.abstractFactory.entity.Instance;
import com.example.patternsanddeepspring.abstractFactory.entity.Storage;

//Represents a concrete product in a family "Amazon Web services"
public class Ec2Instance implements Instance {

    //JFYI sometime better to forbid creation by new, perhaps you have some dependencies on beans etc. Try to use scope prototype for this bean
    public Ec2Instance(Capacity capacity) {
        //Map capacity to ec2 instance types. Use aws API to provision
        System.out.println("Created Ec2Instance");
    }

    @Override
    public void start() {
        System.out.println("Ec2Instance started");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Attached "+storage+" to Ec2Instance");
    }

    @Override
    public void stop() {
        System.out.println("Ec2Instance stopped");
    }

    @Override
    public String toString() {
        return "EC2Instance";
    }
}
