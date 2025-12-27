package chatbot.integrations;

public class JokeServiceAdapter implements JokeService {

    private final ExternalJokeApi api = new ExternalJokeApi();

    @Override
    public String getJoke() {
        String raw = api.fetchJoke();
        // parsing easy
        return raw.substring(raw.indexOf(":") + 1, raw.length() - 1);
    }
}
