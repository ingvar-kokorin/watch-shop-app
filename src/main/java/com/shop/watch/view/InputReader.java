package com.shop.watch.view;

import java.util.Scanner;

public class InputReader {
    private static final Scanner INPUT_READER = new Scanner(System.in);

    public String getInputFromUser() {
        return INPUT_READER.nextLine();
    }
}
