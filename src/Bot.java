public class Bot implements APIService {
    private static String API_KEY;

    Bot(String api) {
        API_KEY = api;
        sendMessage("5251434810", "interface");
    }

    public static String getAPI_KEY() {
        return API_KEY;
    }
}

