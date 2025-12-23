package chatbot.state;

import chatbot.core.Message;
import chatbot.strategies.NormalStrategy;

public class NormalState extends BaseState {
    public NormalState() {
        super(new NormalStrategy());
    }

    @Override
    public ChatState handle(Message msg) {
        String text = msg.text().trim().toLowerCase();
        if (text.equals("/mode study")) return new StudyState();
        if (text.equals("/mode support")) return new SupportState();
        return this;
    }

    @Override
    public String name() {
        return "NORMAL";
    }
}
