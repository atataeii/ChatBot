package chatbot.strategies;

import chatbot.core.ChatResponse;
import chatbot.core.ChatResponseBuilder;
import chatbot.core.Message;

public class NormalStrategy implements ResponseStrategy {
    @Override
    public ChatResponse generate(Message msg) {
        return new ChatResponseBuilder()
                .text("You said: " + msg.text())
                .build();
    }
}
