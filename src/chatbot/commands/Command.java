package chatbot.commands;

import chatbot.core.ChatResponse;
import chatbot.core.Context;
import chatbot.core.Message;

public interface Command {
    boolean matches(Message msg);
    ChatResponse execute(Message msg, Context ctx);
}
