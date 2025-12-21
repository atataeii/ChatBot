package chatbot.state;

import chatbot.core.ChatResponse;
import chatbot.core.Message;
import chatbot.strategies.ResponseStrategy;

public abstract class BaseState implements ChatState {
    protected final ResponseStrategy strategy;

    protected BaseState(ResponseStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public ChatResponse respond(Message msg) {
        return strategy.generate(msg);
    }
}
