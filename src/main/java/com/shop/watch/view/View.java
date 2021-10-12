package com.shop.watch.view;

public class View {
    InputReader InputReader;
    OutputWriter outputWriter;

    public View(InputReader inputReader, OutputWriter outputWriter) {
        this.InputReader = new InputReader();
        this.outputWriter = new OutputWriter();
    }

    public String getInputFromUser() {
        return InputReader.getInputFromUser();
    }

    public void printMessage(String message) {
        outputWriter.printMessage(message);
    }
}
