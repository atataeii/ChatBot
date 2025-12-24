package chatbot.factory;

import chatbot.commands.*;
import chatbot.core.Message;

import java.util.List;

public class CommandFactory {

    private final List<Command> commands = List.of(
            new HelpCommand(),
            new ModeCommand(),
            new CalcCommand()
    );

    public Command getCommand(Message msg) {
        return commands.stream()
                .filter(cmd -> cmd.matches(msg))
                .findFirst()
                .orElse(null);
    }
}
