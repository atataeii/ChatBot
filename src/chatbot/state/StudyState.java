package chatbot.state;

import chatbot.core.Message;
import chatbot.strategies.StudyStrategy;

public class StudyState extends BaseState {
    public StudyState() {
        super(new StudyStrategy());
    }

    @Override
    public ChatState handle(Message msg) {
        String text = msg.text().trim().toLowerCase();
        if (text.equals("/mode normal")) return new NormalState();
        if (text.equals("/mode support")) return new SupportState();
        return this;
    }

    @Override
    public String name() {
        return "STUDY";
    }
}
