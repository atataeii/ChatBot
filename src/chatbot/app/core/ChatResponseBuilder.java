package chatbot.app.core;

import java.util.ArrayList;
import java.util.List;

public class ChatResponseBuilder {

    private String text;
    private final List<String> suggestions = new ArrayList<>();

    public ChatResponseBuilder text(String text) {
        this.text = text;
        return this;
    }

    public ChatResponseBuilder addSuggestion(String suggestion) {
        suggestions.add(suggestion);
        return this;
    }

    public ChatResponse build() {
        return new ChatResponse(text, suggestions);
    }
}
