package chatbot.strategies;

import chatbot.core.ChatResponse;
import chatbot.core.Message;

public class StudyStrategy implements ResponseStrategy {
    @Override
    public ChatResponse generate(Message msg) {
        return new ChatResponse("📚 Study mode: Let's break it down. You said: " + msg.text());
    }
}
