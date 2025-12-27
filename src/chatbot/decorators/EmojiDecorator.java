package chatbot.decorators;

import chatbot.core.ChatResponse;

public class EmojiDecorator extends RendererDecorator {

    public EmojiDecorator(ResponseRenderer inner) {
        super(inner);
    }

    @Override
    public void render(ChatResponse response) {
        System.out.print("🤖 ");
        super.render(response);
    }
}
