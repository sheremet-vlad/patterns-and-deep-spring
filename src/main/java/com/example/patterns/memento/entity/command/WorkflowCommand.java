package com.example.patterns.memento.entity.command;

public interface WorkflowCommand {

    void execute();

    void undo();
}
