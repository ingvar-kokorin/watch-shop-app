package org.watchshop.view;

public class View {
    ViewInputReader viewInputReader;
    ViewOutputWriter viewOutputWriter;

    public View(ViewInputReader viewInputReader, ViewOutputWriter viewOutputWriter) {
        this.viewInputReader = new ConsoleInputReader();
        this.viewOutputWriter = new ConsoleOutputWriter();
    }

    public String getInputFromUser() {
        return viewInputReader.getInputFromUser();
    }

    public void printMessage(String msg) {
        viewOutputWriter.printMessage(msg);
    }
}
