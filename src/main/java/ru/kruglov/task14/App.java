package ru.kruglov.task14;

import java.io.IOException;

import static ru.kruglov.task14.Drink.*;
import static ru.kruglov.task14.LoggerExample.LOGGER;
import java.util.logging.Level;

public class App {
    String vendingMachineName = "Coca-Cola";

    public static void main(String[] args) {
        LoggerExample.loggerConfig();
        App app = new App();
        app.start();
    }

    private void start() {
        UserInterfaceHandler vendingMachineHandler = new UserInterfaceHandler();
        VendingMachine vendingMachine = new VendingMachine(vendingMachineName, COCACOLA, PEPSI);
        try {
            LOGGER.log(Level.INFO, "Vending machine " + vendingMachineName + " started to work");
            vendingMachineHandler.start(vendingMachine);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error with starting vending machine", e);
        }
    }
}