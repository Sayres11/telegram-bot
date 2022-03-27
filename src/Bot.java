public class Bot implements APIService {
    private static String API_KEY;

    Bot(String api) {
        API_KEY = api;
    }

    public static String getAPI_KEY() {
        return API_KEY;
    }
}

