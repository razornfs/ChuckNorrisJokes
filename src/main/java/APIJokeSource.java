import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.List;

public class APIJokeSource implements JokeSource {

    private static final String API_ADDRESS = "https://api.chucknorris.io/jokes/random";

    public List<Joke> getJokes(int amount) {
        List<Joke> jokes = new ArrayList<>();
        JsonParser jsonParser = new JsonParser();
        for (int i = 0; i < amount; i++) {
            String json = Unirest.get(API_ADDRESS).asString().getBody();
            jokes.add(jsonParser.getJoke(json));
        }
        return jokes;
    }
}
