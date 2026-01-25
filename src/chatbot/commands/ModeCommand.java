package chatbot.commands;

import chatbot.core.ChatResponse;
import chatbot.core.ChatResponseBuilder;
import chatbot.core.Context;
import chatbot.core.Message;

public class ModeCommand implements Command {

    @Override
    public boolean matches(Message msg) {
        return msg.text().trim().toLowerCase().startsWith("/mode");
    }

    @Override
    public ChatResponse execute(Message msg, Context ctx) {
        String[] parts = msg.text().trim().split("\\s+");

        if (parts.length == 1) {
            return new ChatResponseBuilder()
                    .text("Current mode is " + ctx.getState().name())
                    .build();
        }

        String before = ctx.getState().name();

        // Let the State decide transitions (State pattern)
        ctx.getState().handle(msg, ctx);

        String after = ctx.getState().name();

        if (before.equals(after) && !parts[1].equalsIgnoreCase(before)) {
            return new ChatResponseBuilder()
                    .text("Unknown mode. Try: /mode normal | /mode study | /mode support")
                    .build();
        }

        return new ChatResponseBuilder()
                .text("Mode switched to " + after)
                .build();
    }
}
