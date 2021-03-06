package com.shop.watch.controller;

import com.shop.watch.model.Model;
import com.shop.watch.model.entity.Clock;
import com.shop.watch.model.entity.Colour;
import com.shop.watch.model.entity.Sex;
import com.shop.watch.model.entity.MechanismType;
import com.shop.watch.view.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.shop.watch.view.MessageConstants.APPLICATION_COMMAND_MENU;
import static com.shop.watch.view.MessageConstants.BACK_TO_MAIN_MENU_OR_EXIT;
import static com.shop.watch.view.MessageConstants.CHOOSE_COLOUR;
import static com.shop.watch.view.MessageConstants.CHOOSE_SEX;
import static com.shop.watch.view.MessageConstants.CHOOSE_MECHANISM_TYPE;
import static com.shop.watch.view.MessageConstants.ENTER_BAND_MATERIAL;
import static com.shop.watch.view.MessageConstants.ENTER_BRAND_NAME;
import static com.shop.watch.view.MessageConstants.ENTER_CLOCK_HEIGHT;
import static com.shop.watch.view.MessageConstants.ENTER_CLOCK_WIDTH;
import static com.shop.watch.view.MessageConstants.ENTER_GUARANTEE_PERIOD;
import static com.shop.watch.view.MessageConstants.ENTER_LIGHTING_PRESENCE;
import static com.shop.watch.view.MessageConstants.ENTER_TICKTOCK_PRESENCE;
import static com.shop.watch.view.MessageConstants.ENTER_MODEL_NAME;
import static com.shop.watch.view.MessageConstants.ENTER_PRICE;
import static com.shop.watch.view.MessageConstants.ENTER_PRODUCING_COUNTRY;
import static com.shop.watch.view.MessageConstants.ENTER_RECEIPT_DATE;
import static com.shop.watch.view.MessageConstants.GREETING;
import static com.shop.watch.view.MessageConstants.NEW_CLOCK_ADDED;
import static com.shop.watch.view.MessageConstants.SELECT_CLOCK_TYPE;
import static com.shop.watch.view.MessageConstants.SOMETHING_GOES_WRONG;
import static com.shop.watch.view.MessageConstants.WRONG_NUMBER_SELECTED;

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
                showAllClocks(model.getAllClocks());
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
            view.printMessage(WRONG_NUMBER_SELECTED);
            userInput = view.getInputFromUser();
        }
        return userInput;
    }

    private void showAllClocks(List<Clock> clocks) {
        clocks.forEach(clock -> view.printMessage(clock.toString()));
    }

    private void printAllClocksSortedByPrice() {
        showAllClocks(model.sortClocksByPrice());
    }

    private void printAllClocksSortedByColour() {
        showAllClocks(model.sortClocksByColour());
    }

    private void printAllClocksSortedByReceipt() {
        showAllClocks(model.sortClocksByReceiptDate());
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
            MechanismType clockType = MechanismType.values()[Integer.parseInt(view.getInputFromUser()) - 1];
            view.printMessage(ENTER_PRICE);
            BigDecimal price = BigDecimal.valueOf(Double.parseDouble(view.getInputFromUser()));
            view.printMessage(CHOOSE_COLOUR);
            Colour colour = Colour.values()[Integer.parseInt(view.getInputFromUser()) - 1];
            view.printMessage(ENTER_PRODUCING_COUNTRY);
            String producingCountry = view.getInputFromUser();
            view.printMessage(ENTER_RECEIPT_DATE);
            LocalDate receiptDate = LocalDate.parse(view.getInputFromUser(), DateTimeFormatter.ofPattern("d/M/yyyy"));
            view.printMessage(ENTER_GUARANTEE_PERIOD);
            int guarantee = Integer.parseInt(view.getInputFromUser());

            if (userMessage.equals("1")) {
                addBracketClock(brand, modelName, clockType, price, colour, producingCountry,
                        receiptDate, guarantee);
            } else if (userMessage.equals("2")) {
                addWallClock(brand, modelName, clockType, price, colour, producingCountry,
                        receiptDate, guarantee);
            } else {
                addWristWatch(brand, modelName, clockType, price, colour, producingCountry,
                        receiptDate, guarantee);
            }
            view.printMessage(NEW_CLOCK_ADDED);
        } catch (Exception e) {
            view.printMessage(SOMETHING_GOES_WRONG);
        }
    }

    private void addBracketClock(String brand,
                                 String modelName,
                                 MechanismType clockType,
                                 BigDecimal price,
                                 Colour colour,
                                 String producingCountry,
                                 LocalDate receiptDate,
                                 int guarantee) {
        view.printMessage(ENTER_CLOCK_HEIGHT);
        double height = Double.parseDouble(view.getInputFromUser());
        view.printMessage(ENTER_CLOCK_WIDTH);
        double width = Double.parseDouble(view.getInputFromUser());
        view.printMessage(ENTER_LIGHTING_PRESENCE);
        String lighting = view.getInputFromUser();

        model.addBracketClockToStorage(brand, modelName, clockType, price, colour, producingCountry,
                receiptDate, guarantee, height, width, lighting);
    }

    private void addWallClock(String brand,
                              String modelName,
                              MechanismType clockType,
                              BigDecimal price,
                              Colour colour,
                              String producingCountry,
                              LocalDate receiptDate,
                              int guarantee) {
        view.printMessage(ENTER_CLOCK_HEIGHT);
        double height = Double.parseDouble(view.getInputFromUser());
        view.printMessage(ENTER_CLOCK_WIDTH);
        double width = Double.parseDouble(view.getInputFromUser());
        view.printMessage(ENTER_TICKTOCK_PRESENCE);
        String tickTockSound = view.getInputFromUser();

        model.addWallClockToStorage(brand, modelName, clockType, price, colour, producingCountry,
                receiptDate, guarantee, height, width, tickTockSound);
    }

    private void addWristWatch(String brand,
                               String modelName,
                               MechanismType clockType,
                               BigDecimal price,
                               Colour colour,
                               String producingCountry,
                               LocalDate receiptDate,
                               int guarantee) {
        view.printMessage(ENTER_BAND_MATERIAL);
        String bandMaterial = view.getInputFromUser();
        view.printMessage(CHOOSE_SEX);
        int sexIndex = Integer.parseInt(view.getInputFromUser()) - 1;
        Sex sex = Sex.values()[sexIndex];

        model.addWristWatchToStorage(brand, modelName, clockType, price, colour, producingCountry,
                receiptDate, guarantee, bandMaterial, sex);
    }

    private boolean isValidInput(String userInput) {
        List<String> validAddCommands = List.of("1", "2", "3");

        if (!validAddCommands.contains(userInput)) {
            view.printMessage(WRONG_NUMBER_SELECTED);
            return false;
        }

        return true;
    }
}
