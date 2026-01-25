package chatbot.state;

import chatbot.core.Context;
import chatbot.core.Message;
import chatbot.strategies.NormalStrategy;
import chatbot.strategies.SupportStrategy;

public class StudyState extends BaseState {

    @Override
    public void handle(Message msg, Context ctx) {
        String text = msg.text().trim().toLowerCase();

        if (text.equals("/mode normal")) {
            ctx.setState(new NormalState());
            ctx.setStrategy(new NormalStrategy());
            return;
        }

        if (text.equals("/mode support")) {
            ctx.setState(new SupportState());
            ctx.setStrategy(new SupportStrategy());
        }
    }

    @Override
    public String name() {
        return "STUDY";
    }
}
