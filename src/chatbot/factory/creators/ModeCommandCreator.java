package chatbot.factory.creators;

import chatbot.commands.Command;
import chatbot.commands.ModeCommand;
import chatbot.core.Message;

public class ModeCommandCreator extends CommandCreator {

    @Override
    public boolean matches(Message msg) {
        return msg.text().trim().toLowerCase().startsWith("/mode");
    }

    @Override
    public Command create() {
        return new ModeCommand();
    }
}
