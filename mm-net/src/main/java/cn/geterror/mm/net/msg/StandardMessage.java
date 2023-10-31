package cn.geterror.mm.net.msg;

import org.springframework.web.socket.WebSocketMessage;


public class StandardMessage<T extends StandardPayload>  implements WebSocketMessage<StandardBody<T>> {
    private final StandardBody<T> body;


    private final boolean isLast;

    public StandardMessage(StandardBody<T> body) {
        this.body = body;
        this.isLast = false;
    }

    public StandardMessage(StandardBody<T> body, boolean isLast) {
        this.body = body;
        this.isLast = isLast;
    }

    @Override
    public StandardBody<T> getPayload() {
        return body;
    }

    @Override
    public int getPayloadLength() {
        return 0;
    }

    @Override
    public boolean isLast() {
        return isLast;
    }
}
