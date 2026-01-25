package chatbot.factory;

import chatbot.commands.Command;
import chatbot.core.Message;
import chatbot.factory.creators.*;

import java.util.List;

public class CommandFactory {

    private final List<CommandCreator> creators = List.of(
            new HelpCommandCreator(),
            new ModeCommandCreator(),
            new CalcCommandCreator(),
            new JokeCommandCreator()
    );

    public Command getCommand(Message msg) {
        return creators.stream()
                .filter(c -> c.matches(msg))
                .findFirst()
                .map(CommandCreator::create) // Factory Method call
                .orElse(null);
    }
}
