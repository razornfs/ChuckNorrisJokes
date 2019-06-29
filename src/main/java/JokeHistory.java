import java.util.Set;

public interface JokeHistory {
    Set<String> load();

    void save(Set<Joke> jokes);
}
