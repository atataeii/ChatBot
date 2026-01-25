package chatbot.factory.creators;

import chatbot.commands.CalcCommand;
import chatbot.commands.Command;
import chatbot.core.Message;

public class CalcCommandCreator extends CommandCreator {

    @Override
    public boolean matches(Message msg) {
        return msg.text().trim().toLowerCase().startsWith("/calc");
    }

    @Override
    public Command create() {
        return new CalcCommand();
    }
}
