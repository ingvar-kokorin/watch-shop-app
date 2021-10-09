package org.watchshop.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInputReader implements ViewInputReader {
    private static final BufferedReader INPUT_READER = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getInputFromUser() {
        try {
            return INPUT_READER.readLine();
        } catch (IOException e) {
        }
        return "";
    }
}
