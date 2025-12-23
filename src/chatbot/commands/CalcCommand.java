package chatbot.commands;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.ChatResponseBuilder;
import chatbot.app.core.Context;
import chatbot.app.core.Message;

public class CalcCommand implements Command {

    @Override
    public boolean matches(Message msg) {
        return msg.text().startsWith("/calc");
    }

    @Override
    public ChatResponse execute(Message msg, Context ctx) {
        try {
            String expr = msg.text().replace("/calc", "").trim();
            String[] parts = expr.split("\\+");
            int result = Integer.parseInt(parts[0].trim())
                    + Integer.parseInt(parts[1].trim());

            return new ChatResponseBuilder()
                    .text("Result: " + result)
                    .build();
        } catch (Exception e) {
            return new ChatResponseBuilder()
                    .text("Usage: /calc 2+3")
                    .build();
        }
    }
}