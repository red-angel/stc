package ru.kruglov.task20;

public enum Messages {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "exit - for closing the application \n" +
            "get - to send GET request and save data locally" +
            "print - to print saved data in terminal window"
            ),
    GOODBYE("Application is  closing.\n"),
    ERROR_APP_HANDLER("Error during the handling of user input commands \n"),
    WRONG_INPUT("Wrong input parameter \n"),
    ERROR_CONVERT_STRING_TO_FLOAT("Error during conversion from String to float"),
    SUCCESSFUL_GET_REQUEST("GET  request was sent successfuly");

    private String text;

    Messages(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}