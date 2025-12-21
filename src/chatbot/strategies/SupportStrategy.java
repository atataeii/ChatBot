package chatbot.strategies;

import chatbot.core.ChatResponse;
import chatbot.core.Message;

public class SupportStrategy implements ResponseStrategy {
    @Override
    public ChatResponse generate(Message msg) {
        return new ChatResponse("🫶 Support mode: I hear you. You said: " + msg.text());
    }
}
