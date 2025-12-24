package chatbot.core;

import chatbot.state.ChatState;
import chatbot.state.NormalState;

public class Context {

    private ChatState state = new NormalState();

    public ChatState getState() {
        return state;
    }

    public void setState(ChatState state) {
        this.state = state;
    }
}
