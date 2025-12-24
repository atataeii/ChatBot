package chatbot.commands;

import chatbot.app.core.ChatResponse;
import chatbot.app.core.ChatResponseBuilder;
import chatbot.app.core.Context;
import chatbot.app.core.Message;

public class HelpCommand implements Command {

    @Override
    public boolean matches(Message msg) {
        return msg.text().equalsIgnoreCase("/help");
    }

    @Override
    public ChatResponse execute(Message msg, Context ctx) {
        return new ChatResponseBuilder()
                .text("Commands:\n" +
                        "- /help\n" +
                        "- /mode\n" +
                        "- /mode normal\n" +
                        "- /mode study\n" +
                        "- /mode support\n" +
                        "- exit")
                .addSuggestion("/mode study")
                .build();
    }
}
