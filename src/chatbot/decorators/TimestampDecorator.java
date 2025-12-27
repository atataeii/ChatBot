package chatbot.decorators;

import chatbot.core.ChatResponse;

import java.time.LocalTime;

public class TimestampDecorator extends RendererDecorator {

    public TimestampDecorator(ResponseRenderer inner) {
        super(inner);
    }

    @Override
    public void render(ChatResponse response) {
        System.out.print("[" + LocalTime.now() + "] ");
        super.render(response);
    }
}
