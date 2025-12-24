package chatbot.core;

import chatbot.commands.Command;
import chatbot.factory.CommandFactory;

import java.util.Scanner;

public class ChatbotEngine {

    private final Context context = new Context();
    private final CommandFactory commandFactory = new CommandFactory();

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

            // 1️⃣ Try command first (Factory)
            Command cmd = commandFactory.getCommand(msg);
            if (cmd != null) {
                ChatResponse res = cmd.execute(msg, context);
                print(res);
                continue;
            }

            // 2️⃣ Otherwise: State + Strategy
            context.setState(context.getState().handle(msg));
            ChatResponse res = context.getState().respond(msg);
            print(res);
        }
    }

    private void print(ChatResponse res) {
        System.out.println("Bot: " + res.text());
        if (!res.suggestions().isEmpty()) {
            System.out.println("Suggestions: " + res.suggestions());
        }
    }
}
