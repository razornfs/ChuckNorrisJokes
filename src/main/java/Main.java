import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        JokeSource source = new APIJokeSource();
        JokeHistory history = new FileBasedJokeHistory();

        Set<String> oldJokes = new HashSet<>();
        for (JokeID jokeID : history.load()) {
            oldJokes.add(jokeID.getId());
        }

        Set<Joke> newJokes = new HashSet<>();
        
        int jokeCount = 0;

        while (jokeCount < 10) {
            Joke joke = source.getJokes(1).get(0);
            if (!oldJokes.contains(joke.getId())) {
                newJokes.add(joke);
                System.out.println(joke.getValue());
                jokeCount++;
            }
        }
        history.save(newJokes);
    }
}
