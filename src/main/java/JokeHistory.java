import java.util.Set;

public interface JokeHistory {
    Set<JokeID> load();

    void save(Set<Joke> jokes);
}
