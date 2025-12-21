package chatbot.strategies;

import chatbot.core.ChatResponse;
import chatbot.core.Message;

public interface ResponseStrategy {
    ChatResponse generate(Message msg);
}
