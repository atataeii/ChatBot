package chatbot.state;

import chatbot.core.Context;
import chatbot.core.Message;
import chatbot.strategies.StudyStrategy;
import chatbot.strategies.SupportStrategy;

public class NormalState extends BaseState {

    @Override
    public void handle(Message msg, Context ctx) {
        String text = msg.text().trim().toLowerCase();

        if (text.equals("/mode study")) {
            ctx.setState(new StudyState());
            ctx.setStrategy(new StudyStrategy());
            return;
        }

        if (text.equals("/mode support")) {
            ctx.setState(new SupportState());
            ctx.setStrategy(new SupportStrategy());
        }
    }

    @Override
    public String name() {
        return "NORMAL";
    }
}
