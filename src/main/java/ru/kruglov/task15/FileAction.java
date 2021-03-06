package ru.kruglov.task15;

import ru.kruglov.localLibs.InputDataHandle;

import java.io.*;

class FileAction {
    private File file;
    BufferedReader buff;

    public FileAction(BufferedReader buff) {
        this.buff = buff;
    }

    void createFile() {
        try {
            ConsoleMessages.CREATE_NEW_FILE_NAME.printMessage();
            String pathToFile = InputDataHandle.getDataFromSystemIn(buff);
            file = new File (pathToFile);
            if (!file.exists() && !file.isDirectory()) {
                file.createNewFile();
                ConsoleMessages.SUCCESSFUL_OPERATION.printMessage();
            } else {
                ConsoleMessages.UNSECCESSFUL_OPERATION.printMessage();
            }
        } catch (IOException e) {
            System.out.println("Error during creating file");
        }
    }

    void renameFile() {
        try {
            ConsoleMessages.RENAME_ORIGIN_NAME.printMessage();
            String originName = InputDataHandle.getDataFromSystemIn(this.buff);
            ConsoleMessages.RENAME_NEW_NAME.printMessage();
            String newName = InputDataHandle.getDataFromSystemIn(this.buff);
            file = new File(originName);
            if (file.exists() && !file.isDirectory()) {
                File tempFile = new File(newName);
                file.renameTo(tempFile);
                ConsoleMessages.SUCCESSFUL_OPERATION.printMessage();
            } else {
                ConsoleMessages.UNSECCESSFUL_OPERATION.printMessage();
            }
        } catch (IOException e) {
            System.out.println("Error during renaming file");
        }
    }

    void deleteFile() {
        try {
            ConsoleMessages.DELETE_FILE_NAME.printMessage();
            String name = InputDataHandle.getDataFromSystemIn(this.buff);
            file = new File(name);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
                ConsoleMessages.SUCCESSFUL_OPERATION.printMessage();
            } else {
                ConsoleMessages.UNSECCESSFUL_OPERATION.printMessage();
            }
        } catch (IOException e) {
            System.out.println("Error during deleting file");
        }
    }

    void copyFile() {
        try {
            ConsoleMessages.COPY_FROM_ORIGIN_PATH.printMessage();
            String originPath = InputDataHandle.getDataFromSystemIn(buff);
            file = new File(originPath);
            if (file.exists() && !file.isDirectory()) {
                ConsoleMessages.COPY_TO_NEW_PATH.printMessage();
                String newPath = InputDataHandle.getDataFromSystemIn(buff);
                FileCopier.fileCopier(file, newPath);
                ConsoleMessages.SUCCESSFUL_OPERATION.printMessage();
            }   else {
                ConsoleMessages.UNSECCESSFUL_OPERATION.printMessage();
            }
        } catch (IOException e) {
            System.out.println("Error durring getting data from system input");
        }
    }
}
