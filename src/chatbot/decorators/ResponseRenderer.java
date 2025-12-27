package chatbot.decorators;

import chatbot.core.ChatResponse;

public interface ResponseRenderer {
    void render(ChatResponse response);
}
