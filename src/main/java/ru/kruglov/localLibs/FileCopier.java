package ru.kruglov.localLibs;

import java.io.*;

public class FileCopier {
    public static void fileCopier(String pathOfOriginFile, String pathOfNewFile) throws IOException {
        fileCopier(pathOfOriginFile, pathOfNewFile, null);
    }

    public static void fileCopier(String pathOfOriginFile,
                                  String pathOfNewFile,
                                  String encoding) throws IOException {
        File file = new File(pathOfOriginFile);
        if (file.exists() && !file.isDirectory()) {
            File newFile = new File(pathOfNewFile);
            try (InputStream inputStream = new BufferedInputStream(
                    new FileInputStream(file));
                 OutputStream outputStream = new BufferedOutputStream(
                         new FileOutputStream(newFile))) {
                byte[] inputBuffer = new byte[1024];
                int lengthRead;
                while ((lengthRead = inputStream.read(inputBuffer)) > 0) {
                    if (encoding != null) {
                         inputBuffer = new String(inputBuffer).getBytes(encoding);
                    }
                    outputStream.write(inputBuffer, 0, lengthRead);
                    outputStream.flush();
                    }
            } catch (IOException e) {
                throw new IOException("Error durinth copying file");
            }
        } else throw new FileNotFoundException("Copying file was not found");
    }

}
