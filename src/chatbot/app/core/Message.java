package chatbot.app.core;

import java.time.Instant;

public class Message {
    private final String text;
    private final Instant timestamp;

    public Message(String text) {
        this.text = text;
        this.timestamp = Instant.now();
    }

    public String text() {
        return text;
    }

    public Instant timestamp() {
        return timestamp;
    }
}
