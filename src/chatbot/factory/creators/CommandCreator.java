package chatbot.factory.creators;

import chatbot.commands.Command;
import chatbot.core.Message;

/**
 * Factory Method: subclasses decide which Command to create.
 */
public abstract class CommandCreator {

    public abstract boolean matches(Message msg);

    // Factory Method
    public abstract Command create();
}
