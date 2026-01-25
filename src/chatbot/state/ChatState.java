package chatbot.state;

import chatbot.core.ChatResponse;
import chatbot.core.Context;
import chatbot.core.Message;

public interface ChatState {

    /**
     * Handle message and (if needed) transition Context to another state.
     * State is responsible for transitions (per State pattern).
     */
    void handle(Message msg, Context ctx);

    String name();

    /**
     * Produce response, typically delegating to current Strategy in Context.
     */
    ChatResponse respond(Message msg, Context ctx);
}
