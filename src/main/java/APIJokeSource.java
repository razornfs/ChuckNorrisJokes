import kong.unirest.Unirest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class APIJokeSource implements JokeSource {

    private static final String API_ADDRESS = "https://api.chucknorris.io/jokes/random";

    private JsonParser jsonParser = new JsonParser();

    public List<Joke> getRandomJokes(int amount) {
        List<Joke> jokes = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            jokes.add(getJoke());
        }
        return jokes;
    }

    @Override
    public Set<Joke> getUniqueJokes(int amount, Set<String> oldJokes) {
        Set<Joke> newJokes = new HashSet<>();
        int jokeCount = 0;
        while (jokeCount < amount) {
            Joke joke = getJoke();
            if (!oldJokes.contains(joke.getId()) && !newJokes.contains(joke)) {
                newJokes.add(joke);
                jokeCount++;
            }
        }
        return newJokes;
    }

    private Joke getJoke() {
        return jsonParser.getJoke(Unirest.get(API_ADDRESS).asString().getBody());
    }
}
