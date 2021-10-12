package com.shop.watch.controller;

import com.shop.watch.model.Model;
import com.shop.watch.model.entity.Clock;
import com.shop.watch.model.entity.Colour;
import com.shop.watch.model.entity.Sex;
import com.shop.watch.model.entity.Mechanism;
import com.shop.watch.view.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.shop.watch.view.MessageConstants.*;

public class Controller {
    private final Model model;
    private final View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean isExit = false;
        view.printMessage(GREETING);
        while (!isExit) {
            view.printMessage(APPLICATION_COMMAND_MENU);
            String userChoice = getCommandFromUser();
            if (userChoice.equalsIgnoreCase("EXIT")) {
                return;
            } else if (userChoice.equals("1")) {
                showAllClocks(model.getClocks());
            } else if (userChoice.equals("2")) {
                printAllClocksSortedByPrice();
            } else if (userChoice.equals("3")) {
                printAllClocksSortedByColour();
            } else if (userChoice.equals("4")) {
                printAllClocksSortedByReceipt();
            } else if (userChoice.equals("5")) {
                printTotalClocksCost();
            } else if (userChoice.equals("6")) {
                addNewClockIntoTheStorage();
            }
            isExit = bringBackMenu();
        }
    }

    private boolean bringBackMenu() {
        while (true) {
            view.printMessage(BACK_TO_MAIN_MENU_OR_EXIT);
            String receivedCommand = view.getInputFromUser();
            if (receivedCommand.equals("1")) {
                return false;
            } else if (receivedCommand.equals("2")) {
                return true;
            }
        }
    }

    private String getCommandFromUser() {
        List<String> allowedCommands = List.of("1", "2", "3", "4", "5", "6", "EXIT");
        String userInput = view.getInputFromUser();
        while (userInput == null || !allowedCommands.contains(userInput.toUpperCase())) {
            view.printMessage(WRONG_NUMBER_RECEIVED);
            userInput = view.getInputFromUser();
        }
        return userInput;
    }

    private void showAllClocks(List<Clock> clocks) {
        clocks.forEach(c -> view.printMessage(c.toString()));
    }

    private void printAllClocksSortedByPrice() {
        showAllClocks(model.sortClocksByPrice());
    }

    private void printAllClocksSortedByColour() {
        showAllClocks(model.sortClocksByColour());
    }

    private void printAllClocksSortedByReceipt() {
        showAllClocks(model.sortClocksByDateOfReceipt());
    }

    private void printTotalClocksCost() {
        String totalCost = model.getTotalCost().toString();
        view.printMessage(totalCost + "$");
    }

    private void addNewClockIntoTheStorage() {
        view.printMessage(SELECT_CLOCK_TYPE);
        try {
            String userMessage = view.getInputFromUser();
            if (userMessage.equals("4") || !isValidInput(userMessage)) {
                return;
            }

            view.printMessage(ENTER_BRAND_NAME);
            String brand = view.getInputFromUser();
            view.printMessage(ENTER_MODEL_NAME);
            String modelName = view.getInputFromUser();
            view.printMessage(CHOOSE_MECHANISM_TYPE);
            Mechanism clockType = Mechanism.values()[Integer.parseInt(view.getInputFromUser()) - 1];
            view.printMessage(ENTER_PRICE);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(view.getInputFromUser()));
            view.printMessage(CHOOSE_COLOUR);
            Colour colour = Colour.values()[Integer.parseInt(view.getInputFromUser()) - 1];
            view.printMessage(ENTER_PRODUCING_COUNTRY);
            String producingCountry = view.getInputFromUser();
            view.printMessage(ENTER_DATE_OF_RECEIPT);
            LocalDate dateOfReceipt = LocalDate.parse(view.getInputFromUser(),
                    DateTimeFormatter.ofPattern("d/M/yyyy"));
            view.printMessage(ENTER_GUARANTEE_PERIOD);
            int guarantee = Integer.parseInt(view.getInputFromUser());

            if (userMessage.equals("1")) {
                view.printMessage(ENTER_CLOCK_HEIGHT);
                double height = Double.parseDouble(view.getInputFromUser());
                view.printMessage(ENTER_CLOCK_WIDTH);
                double width = Double.parseDouble(view.getInputFromUser());
                view.printMessage(ENTER_IS_THE_LIGHTING_PRESENT);
                String lighting = view.getInputFromUser();
                model.addNewBracketClockInTheStorage(brand, modelName, clockType, price, colour, producingCountry,
                        dateOfReceipt, guarantee, height, width, lighting);
                view.printMessage(NEW_CLOCK_IS_ADDED);
            } else if (userMessage.equals("2")) {
                view.printMessage(ENTER_CLOCK_HEIGHT);
                double height = Double.parseDouble(view.getInputFromUser());
                view.printMessage(ENTER_CLOCK_WIDTH);
                double width = Double.parseDouble(view.getInputFromUser());
                view.printMessage(ENTER_IS_TICKTOCK_SOUND_IS_PRESENT);
                String tickTockSound = view.getInputFromUser();
                model.addNewWallClockInTheStorage(brand, modelName, clockType, price, colour, producingCountry,
                        dateOfReceipt, guarantee, height, width, tickTockSound);
                view.printMessage(NEW_CLOCK_IS_ADDED);
            } else {
                view.printMessage(ENTER_BAND_MATERIAL);
                String bandMaterial = view.getInputFromUser();
                view.printMessage(CHOOSE_DEPARTMENT);
                int sexIndex = Integer.parseInt(view.getInputFromUser()) - 1;
                Sex sex = Sex.values()[sexIndex];
                model.addNewWristClockInTheStorage(brand, modelName, clockType, price, colour, producingCountry,
                        dateOfReceipt, guarantee, bandMaterial, sex);
                view.printMessage(NEW_CLOCK_IS_ADDED);
            }
        } catch (Exception e) {
            view.printMessage(SOMETHING_GOES_WRONG);
        }
    }

    private boolean isValidInput(String userInput) {
        List<String> validAddCommands = List.of("1", "2", "3");
        if (validAddCommands.contains(userInput)) {
            view.printMessage(WRONG_NUMBER_SELECTED);
            return false;
        }
        return true;
    }
}
