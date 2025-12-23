package chatbot.strategies;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.Message;

public interface ResponseStrategy {
    ChatResponse generate(Message msg);
}
