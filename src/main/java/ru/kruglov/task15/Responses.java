package ru.kruglov.task15;

public enum Responses {
    WELCOME ("Select action \n" +
            "Type \"help\" for getting more info."),
    HELP("Use these commands: \n" +
            "create - for create new file \n" +
            "rename - for rename file \n" +
            "delete - for deleting file \n"+
            "copy - for copy file to new place\n"),
    GOODBYE("Application is  closing.\n"),
    CREATE_FILE_SUCCESS("File was successully created\n"),
    COPY_FROM_ORIGIN_PATH ("Enter path of file which you want to copy"),
    COPY_TO_NEW_PATH ("Enter a new destination of copied file"),
    WRONG_INPUT("Wrong input parameter\n"),
    RENAME_ORIGIN_NAME("Enter path of file, which you want to rename"),
    RENAME_NEW_NAME("Enter new name of file"),
    SUCCESSFUL_OPERATION("Operation has been successfully finished"),
    DELETE_FILE_NAME("Enter path of file which you want to delete");

    private String text;

    Responses(String text) {
        this.text = text;
    }

    public String getMessage() {
        return text;
    }

    public void printMessage() {
        System.out.println(text);
    }
}
