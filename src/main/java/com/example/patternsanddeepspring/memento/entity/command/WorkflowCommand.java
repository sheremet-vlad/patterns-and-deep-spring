package com.example.patternsanddeepspring.memento.entity.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}
