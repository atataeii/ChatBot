package chatbot.decorators;

import chatbot.core.ChatResponse;

public abstract class RendererDecorator implements ResponseRenderer {

    protected final ResponseRenderer inner;

    protected RendererDecorator(ResponseRenderer inner) {
        this.inner = inner;
    }

    @Override
    public void render(ChatResponse response) {
        inner.render(response);
    }
}
