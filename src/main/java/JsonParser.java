import com.google.gson.Gson;

public class JsonParser {

    private Gson gson;

    public JsonParser() {
        gson = new Gson();
    }

    public Joke getJoke(String json) {
        return gson.fromJson(json, Joke.class);
    }
}
