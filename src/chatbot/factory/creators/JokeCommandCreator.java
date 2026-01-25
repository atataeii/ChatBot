package chatbot.factory.creators;

import chatbot.commands.Command;
import chatbot.commands.JokeCommand;
import chatbot.core.Message;

public class JokeCommandCreator extends CommandCreator {

    @Override
    public boolean matches(Message msg) {
        return msg.text().trim().toLowerCase().startsWith("/joke");
    }

    @Override
    public Command create() {
        return new JokeCommand();
    }
}
