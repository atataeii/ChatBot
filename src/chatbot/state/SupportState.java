package chatbot.state;

import chatbot.core.Message;
import chatbot.strategies.SupportStrategy;

public class SupportState extends BaseState {
    public SupportState() {
        super(new SupportStrategy());
    }

    @Override
    public ChatState handle(Message msg) {
        String text = msg.text().trim().toLowerCase();
        if (text.equals("/mode normal")) return new NormalState();
        if (text.equals("/mode study")) return new StudyState();
        return this;
    }

    @Override
    public String name() {
        return "SUPPORT";
    }
}
