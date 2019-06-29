import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FileBasedJokeHistory implements JokeHistory {

    private static Path path = Paths.get("jokes.txt");

    @Override
    public Set<String> load() {
        List<String> strings = null;
        try {
            strings = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new HashSet<>(strings);
    }

    @Override
    public void save(Set<Joke> jokes) {
        Set<String> IDs = new HashSet<>();
        for (Joke joke : jokes) {
            IDs.add(joke.getId());
        }
        try {
            Files.write(path, IDs, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
