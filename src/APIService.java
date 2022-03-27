import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public interface APIService {

    /**
     * @param api_request Specify the api method to execute
     */
    default void request(String api_request) {
        String urlString = "https://api.telegram.org/bot%s/" + api_request;
        urlString = String.format(urlString, Bot.getAPI_KEY());

        try {
            URL myURL = new URL(urlString);
            BufferedReader rd = new BufferedReader(new InputStreamReader(myURL.openConnection().getInputStream()));
            System.out.println(rd);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

/*    //FIXME
    default void getMessage(String chatId) {
        String urlString = "getUpdates?offset=%s";
        urlString = String.format(urlString, chatId);
    }*/
}
