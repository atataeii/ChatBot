package chatbot.strategies;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.Message;

public class NormalStrategy implements ResponseStrategy {
    @Override
    public ChatResponse generate(Message msg) {
        return new ChatResponse("You said: " + msg.text());
    }
}
