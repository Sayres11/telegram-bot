import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public interface APIService {

    /**
     * @param api_request Specify the api method to execute
     */
    default String request(String api_request) {
        String urlString = "https://api.telegram.org/bot%s/" + api_request;
        urlString = String.format(urlString, Bot.getAPI_KEY());
        StringBuffer textData = null;

        try {
            URL myURL = new URL(urlString);
            BufferedReader rd = new BufferedReader(new InputStreamReader(myURL.openConnection().getInputStream()));
            textData = new StringBuffer();
            String line;

            while ((line = rd.readLine()) != null) {
                textData.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return textData != null ? textData.toString() : "";
    }

    /**
     * method that allows you to send messages to the specified chat
     *
     * @param chatId the number of the chat room you need to write to
     * @param text   the text that needs to be written
     */
    default void sendMessage(String chatId, String text) {
        String urlString = "sendMessage?chat_id=%s&text=%s";
        urlString = String.format(urlString, chatId, text);
        request(urlString);
    }

    default void getMessage(String chatId) {
        String urlString = "getUpdates?offset=%s";
        urlString = String.format(urlString, chatId);
    }
}
