package chatbot.commands;

import chatbot.core.ChatResponse;
import chatbot.core.ChatResponseBuilder;
import chatbot.core.Context;
import chatbot.core.Message;
import chatbot.integrations.JokeService;
import chatbot.integrations.JokeServiceAdapter;

public class JokeCommand implements Command {

    private final JokeService jokeService = new JokeServiceAdapter();

    @Override
    public boolean matches(Message msg) {
        return msg.text().equalsIgnoreCase("/joke");
    }

    @Override
    public ChatResponse execute(Message msg, Context ctx) {
        return new ChatResponseBuilder()
                .text(jokeService.getJoke())
                .build();
    }
}
