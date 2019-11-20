package DTU35_del3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Message {
    private static String language;

    public Message(String language) {
        Message.language = language;
    }

    public static String getMessage(String keyWord, int line) {
        String msg = "";
        String file = "";

        if (language == "danish") {
            file = "resources/danish.txt";
        } else if (language == "english") {
            file = "resources/english.txt";
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (true) {
                String currentLine = reader.readLine();

                if (currentLine == null) {
                    break;
                }

                if (currentLine.equals(keyWord)) {
                    for (int j = 1; j < line; j++) {
                        String skip = reader.readLine();
                    }
                    msg = reader.readLine();
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
