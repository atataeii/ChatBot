package chatbot.core;

import java.util.List;

public class ChatResponse {
    private final String text;
    private final List<String> suggestions;

    ChatResponse(String text, List<String> suggestions) {
        this.text = text;
        this.suggestions = suggestions;
    }

    public String text() {
        return text;
    }

    public List<String> suggestions() {
        return suggestions;
    }
}
