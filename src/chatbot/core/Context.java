package chatbot.core;

import chatbot.state.ChatState;
import chatbot.state.NormalState;
import chatbot.strategies.NormalStrategy;
import chatbot.strategies.ResponseStrategy;

public class Context {

    private ChatState state;
    private ResponseStrategy strategy;

    public Context() {
        // default mode on startup
        this.strategy = new NormalStrategy();
        this.state = new NormalState();
    }

    public ChatState getState() {
        return state;
    }

    /**
     * State transition is allowed, but the decision to transition
     * must be made inside the State (per the State pattern).
     */
    public void setState(ChatState state) {
        this.state = state;
    }

    public ResponseStrategy getStrategy() {
        return strategy;
    }

    /**
     * Strategies must be swappable from the outside (per the Strategy pattern).
     */
    public void setStrategy(ResponseStrategy strategy) {
        this.strategy = strategy;
    }
}
