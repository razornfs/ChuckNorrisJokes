import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        JokeSource source = new APIJokeSource();
        JokeHistory history = new FileBasedJokeHistory();
        Set<Joke> newJokes = source.getUniqueJokes(10, history.load());
        newJokes.forEach(System.out::println);
        history.save(newJokes);
    }
}
