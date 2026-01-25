package chatbot.factory.creators;

import chatbot.commands.Command;
import chatbot.commands.HelpCommand;
import chatbot.core.Message;

public class HelpCommandCreator extends CommandCreator {

    @Override
    public boolean matches(Message msg) {
        return msg.text().trim().toLowerCase().startsWith("/help");
    }

    @Override
    public Command create() {
        return new HelpCommand();
    }
}
