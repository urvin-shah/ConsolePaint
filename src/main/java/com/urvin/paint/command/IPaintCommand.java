package com.urvin.paint.command;

/**
 * This is a IPaintCommand interface which will be implemented by other Command tools.
 */

@FunctionalInterface
public interface IPaintCommand {
    void execute();
}
