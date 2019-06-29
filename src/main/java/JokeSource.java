import java.util.List;
import java.util.Set;

public interface JokeSource {
    List<Joke> getRandomJokes(int amount);

    Set<Joke> getUniqueJokes(int amount, Set<String> oldJokes);
}
