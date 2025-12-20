package chatbot.core;

public class ChatResponse {
    private final String text;

    public ChatResponse(String text) {
        this.text = text;
    }

    public String text() {
        return text;
    }
}
