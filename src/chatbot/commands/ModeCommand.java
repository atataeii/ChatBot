package chatbot.commands;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.ChatResponseBuilder;
import chatbot.app.core.Context;
import chatbot.app.core.Message;
import chatbot.state.NormalState;
import chatbot.state.StudyState;
import chatbot.state.SupportState;

public class ModeCommand implements Command {

    @Override
    public boolean matches(Message msg) {
        return msg.text().startsWith("/mode");
    }

    @Override
    public ChatResponse execute(Message msg, Context ctx) {
        String[] parts = msg.text().split(" ");

        if (parts.length == 1) {
            return new ChatResponseBuilder()
                    .text("Current mode is " + ctx.getState().name())
                    .build();
        }

        switch (parts[1].toLowerCase()) {
            case "normal" -> ctx.setState(new NormalState());
            case "study" -> ctx.setState(new StudyState());
            case "support" -> ctx.setState(new SupportState());
            default -> {
                return new ChatResponseBuilder()
                        .text("Unknown mode.")
                        .build();
            }
        }

        return new ChatResponseBuilder()
                .text("Mode switched to " + ctx.getState().name())
                .build();
    }
}
