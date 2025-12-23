package chatbot.state;

import chatbot.core.ChatResponse;
import chatbot.core.Message;

public interface ChatState {
    ChatState handle(Message msg);
    String name();
    ChatResponse respond(Message msg);
}
