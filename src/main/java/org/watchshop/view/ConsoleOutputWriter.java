package org.watchshop.view;

public class ConsoleOutputWriter implements ViewOutputWriter {
    @Override
    public void printMessage(String msg) {
        System.out.println(msg);
    }
}
