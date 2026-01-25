package chatbot.state;

import chatbot.core.ChatResponse;
import chatbot.core.Context;
import chatbot.core.Message;

public abstract class BaseState implements ChatState {

    @Override
    public ChatResponse respond(Message msg, Context ctx) {
        // Strategy chosen from outside via ctx.setStrategy(...)
        return ctx.getStrategy().generate(msg);
    }
}
