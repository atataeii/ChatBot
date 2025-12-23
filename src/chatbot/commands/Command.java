package chatbot.commands;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.Context;
import chatbot.app.core.Message;

public interface Command {
    boolean matches(Message msg);
    ChatResponse execute(Message msg, Context ctx);
}
