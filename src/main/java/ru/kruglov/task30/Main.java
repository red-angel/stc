package ru.kruglov.task30;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Application uiHandler = new Application();
            uiHandler.appHandler();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
