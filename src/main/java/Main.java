import java.io.IOException;
import java.nio.file.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        JokeSource source = new APIJokeSource();

        Path path = Paths.get("jokes.txt");
        List<String> strings = Files.readAllLines(path);

        Set<String> oldJokes = new HashSet<>(strings);
        Set<String> newJokes = new HashSet<>();
        int jokeCount = 0;
        while (jokeCount < 10) {
            Joke joke = source.getJokes(1).get(0);
            if (!oldJokes.contains(joke.getId())) {
                newJokes.add(joke.getId());
                System.out.println(joke.getValue());
                jokeCount++;
            }
        }
        Files.write(path, newJokes, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
