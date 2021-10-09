package org.watchshop.controller;

import org.watchshop.model.Model;
import org.watchshop.model.entity.Colour;
import org.watchshop.model.entity.Department;
import org.watchshop.model.entity.MechanismTypes;
import org.watchshop.view.ConstantsOfMessagesToUser;
import org.watchshop.view.View;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean exitMessageReceived = false;
        view.printMessage(ConstantsOfMessagesToUser.GREETING);
        view.printMessage(ConstantsOfMessagesToUser.APPLICATION_COMMAND_MENU);
        while (!exitMessageReceived) {
            String userChoice = view.getInputFromUser();

            if (userChoice.compareToIgnoreCase("EXIT") == 0) {
                exitMessageReceived = true;
                continue;
            } else if ("1".equals(userChoice)) {
                showAllClocks();
            } else if ("2".equals(userChoice)) {
                printAllClocksSortedByPrice();
            } else if ("3".equals(userChoice)) {
                printAllClocksSortedByColour();
            } else if ("4".equals(userChoice)) {
                printAllClocksSortedByReceipt();
            } else if ("5".equals(userChoice)) {
                printCoastOfAllClocksInTheShop();
            } else if ("6".equals(userChoice)) {
                addNewClockIntoTheStorage();
            } else if ("7".equals(userChoice)) {
                view.printMessage(ConstantsOfMessagesToUser.APPLICATION_COMMAND_MENU);
            } else {
                view.printMessage(ConstantsOfMessagesToUser.WRONG_NUMBER_RECEIVED);
                continue;
            }
            view.printMessage(ConstantsOfMessagesToUser.BACK_TO_MAIN_MENU_OR_EXIT);
            while (true) {
                String receivedCommand = view.getInputFromUser();
                if (receivedCommand.equals("1")) {
                    view.printMessage(ConstantsOfMessagesToUser.APPLICATION_COMMAND_MENU);
                    break;
                } else if (receivedCommand.equals("2")) {
                    exitMessageReceived = true;
                    break;
                } else {
                    view.printMessage(ConstantsOfMessagesToUser.BACK_TO_MAIN_MENU_OR_EXIT);
                }
            }
        }
    }

    private void showAllClocks() {
        model.getClockStorageFacility().forEach(c -> view.printMessage(c.toString()));
    }

    private void printAllClocksSortedByPrice() {
        model.sortClocksByPrice();
        this.showAllClocks();
    }

    private void printAllClocksSortedByColour() {
        model.sortClocksByColour();
        this.showAllClocks();
    }

    private void printAllClocksSortedByReceipt() {
        model.sortClocksByDateOfReceipt();
        this.showAllClocks();
    }

    private void printCoastOfAllClocksInTheShop() {
        String fullCoast = Double.toString(model.coastOfAllClocksInTheStorage());
        view.printMessage(fullCoast + "$");
    }

    private void addNewClockIntoTheStorage() {
        view.printMessage(ConstantsOfMessagesToUser.SELECT_A_CLOCK_TYPE);
        try {
            String messageFromUser = view.getInputFromUser();
            if ("4".equals(messageFromUser)) {
                return;
            }
            if ("1".equals(messageFromUser) || "2".equals(messageFromUser) || "3".equals(messageFromUser)) {
                view.printMessage(ConstantsOfMessagesToUser.ENTER_BRAND_NAME);
                String brand = view.getInputFromUser();
                view.printMessage(ConstantsOfMessagesToUser.ENTER_MODEL_NAME);
                String modelName = view.getInputFromUser();
                view.printMessage(ConstantsOfMessagesToUser.CHOSE_MECHANISM_TYPE);
                MechanismTypes clockType = MechanismTypes.values()[Integer.parseInt(view.getInputFromUser()) - 1];
                view.printMessage(ConstantsOfMessagesToUser.ENTER_PRICE);
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(view.getInputFromUser()));
                view.printMessage(ConstantsOfMessagesToUser.CHOSE_COLOUR);
                Colour colour = Colour.values()[Integer.parseInt(view.getInputFromUser()) - 1];
                view.printMessage(ConstantsOfMessagesToUser.ENTER_PRODUCING_COUNTRY);
                String producingCountry = view.getInputFromUser();
                view.printMessage(ConstantsOfMessagesToUser.ENTER_DATE_OF_RECEIPT);
                LocalDate dateOfReceipt = LocalDate.parse(view.getInputFromUser(),
                        DateTimeFormatter.ofPattern("d/M/yyyy"));
                view.printMessage(ConstantsOfMessagesToUser.ENTER_GUARANTEE_PERIOD);
                int guarantee = Integer.parseInt(view.getInputFromUser());
                if ("1".equals(messageFromUser)) {
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_CLOCK_HEIGHT);
                    double height = Double.parseDouble(view.getInputFromUser());
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_CLOCK_WIDTH);
                    double width = Double.parseDouble(view.getInputFromUser());
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_IS_THE_LIGHTING_PRESENT);
                    String lighting = view.getInputFromUser();
                    model.addNewBracketClockInTheStorage(brand, modelName, clockType, price, colour, producingCountry,
                            dateOfReceipt, guarantee, height, width, lighting);
                } else if ("2".equals(messageFromUser)) {
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_CLOCK_HEIGHT);
                    double height = Double.parseDouble(view.getInputFromUser());
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_CLOCK_WIDTH);
                    double width = Double.parseDouble(view.getInputFromUser());
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_IS_TICKTOCK_SOUND_IS_PRESENT);
                    String tickTockSound = view.getInputFromUser();
                    model.addNewWallClockInTheStorage(brand, modelName, clockType, price, colour, producingCountry,
                            dateOfReceipt, guarantee, height, width, tickTockSound);
                } else {
                    view.printMessage(ConstantsOfMessagesToUser.ENTER_BAND_MATERIAL);
                    String bandMaterial = view.getInputFromUser();
                    view.printMessage(ConstantsOfMessagesToUser.CHOSE_DEPARTMENT);
                    int departmentIndex = Integer.parseInt(view.getInputFromUser()) - 1;
                    Department department = Department.values()[departmentIndex];
                    model.addNewWristClockInTheStorage(brand, modelName, clockType, price, colour, producingCountry,
                            dateOfReceipt, guarantee, bandMaterial, department);
                }
            } else {
                view.printMessage(ConstantsOfMessagesToUser.WRONG_NUMBER_SELECTED);
            }
            view.printMessage(ConstantsOfMessagesToUser.NEW_CLOCK_IS_ADDED);
        } catch (Exception e) {
            view.printMessage(ConstantsOfMessagesToUser.SOMETHING_GOES_WRONG);
        }
    }

    public Model getModel() {
        return model;
    }

    public View getView() {
        return view;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setView(View view) {
        this.view = view;
    }
}
