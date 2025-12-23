package chatbot.state;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.Message;

public interface ChatState {
    ChatState handle(Message msg);
    String name();
    ChatResponse respond(Message msg);
}
