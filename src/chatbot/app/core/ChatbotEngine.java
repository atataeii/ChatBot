package chatbot.core;

import java.util.Scanner;

public class ChatbotEngine {

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

            ChatResponse response = handleMessage(msg);

            System.out.println("Bot: " + response.text());
        }

        scanner.close();
    }

    private ChatResponse handleMessage(Message msg) {
        String text = msg.text();

        if (text.equalsIgnoreCase("/help")) {
            return new ChatResponse("Commands:\n" +
                    "- /help : show this help\n" +
                    "- exit  : quit the program");
        }

        return new ChatResponse("You said: " + text);
    }
}