import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public interface APIService {

    default void sendMessage(String chatId, String text) {
        {
            String urlString = "https://api.telegram.org/bot%s/sendMessage?chat_id=%s&text=%s";
            urlString = String.format(urlString, Bot.getAPI_KEY(), chatId, text);

            try {
                URL url = new URL(urlString);
                URLConnection conn = url.openConnection();
                new BufferedInputStream(conn.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
