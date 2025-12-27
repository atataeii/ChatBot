package chatbot.decorators;

import chatbot.core.ChatResponse;

public class BaseRenderer implements ResponseRenderer {

    @Override
    public void render(ChatResponse response) {
        System.out.println("Bot: " + response.text());
        if (!response.suggestions().isEmpty()) {
            System.out.println("Suggestions: " + response.suggestions());
        }
    }
}
