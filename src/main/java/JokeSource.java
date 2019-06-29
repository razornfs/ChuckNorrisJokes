import java.util.List;

public interface JokeSource {
    List<Joke> getJokes(int amount);
}
