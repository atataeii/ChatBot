package chatbot.core;

import chatbot.state.ChatState;
import chatbot.state.NormalState;

import java.util.Scanner;

public class ChatbotEngine {

    private ChatState state = new NormalState();

    public void start() {
        System.out.println("=== Console Chatbot ===");
        System.out.println("Type /help for commands, or 'exit' to quit.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();

            if (input == null) continue;
            input = input.trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Bot: Bye! 👋");
                break;
            }

            Message msg = new Message(input);

            // Help command
            if (msg.text().equalsIgnoreCase("/help")) {
                System.out.println("Bot: Commands:\n" +
                        "- /help\n" +
                        "- /mode            (show current mode)\n" +
                        "- /mode normal\n" +
                        "- /mode study\n" +
                        "- /mode support\n" +
                        "- exit");
                continue;
            }

            // Show current mode
            if (msg.text().equalsIgnoreCase("/mode")) {
                System.out.println("Bot: Current mode is " + state.name());
                continue;
            }

            // Update state (State pattern)
            ChatState newState = state.handle(msg);
            if (newState != state) {
                state = newState;
                System.out.println("Bot: Mode switched to " + state.name());
                continue;
            }

            // Respond using the strategy inside state (Strategy pattern)
            ChatResponse response = state.respond(msg);
            System.out.println("Bot: " + response.text());
        }

        scanner.close();
    }
}
