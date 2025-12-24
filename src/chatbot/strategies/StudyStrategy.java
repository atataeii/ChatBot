package chatbot.strategies;

import chatbot.core.ChatResponse;
import chatbot.core.ChatResponseBuilder;
import chatbot.core.Message;

public class StudyStrategy implements ResponseStrategy {
    @Override
    public ChatResponse generate(Message msg) {
        return new ChatResponseBuilder()
                .text("📚 Study mode: Let's break it down. You said: " + msg.text())
                .addSuggestion("/help")
                .build();
    }
}
