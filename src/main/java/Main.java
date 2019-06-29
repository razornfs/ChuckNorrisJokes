public class Main {
    public static void main(String[] args) {
        JokeSource source = new APIJokeSource();
        source.getJokes(10).forEach(System.out::println);
    }
}
