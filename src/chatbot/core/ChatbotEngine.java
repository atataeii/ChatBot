package chatbot.core;

import chatbot.commands.Command;
import chatbot.decorators.*;
import chatbot.factory.CommandFactory;

import java.util.Scanner;

public class ChatbotEngine {

    private final Context context = new Context();
    private final CommandFactory commandFactory = new CommandFactory();

    private final ResponseRenderer renderer =
            new EmojiDecorator(
                    new TimestampDecorator(
                            new BaseRenderer()
                    )
            );

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Console Chatbot started. Type /help.");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Bot: Bye!");
                break;
            }

            Message msg = new Message(input);

            // 1) Commands first
            Command cmd = commandFactory.getCommand(msg);
            if (cmd != null) {
                ChatResponse res = cmd.execute(msg, context);
                renderer.render(res);
                continue;
            }

            // 2) State decides transitions + Strategy generates response
            context.getState().handle(msg, context);
            ChatResponse res = context.getState().respond(msg, context);
            renderer.render(res);
        }
    }
}
