package cn.geterror.mm.net.msg;

import java.io.Serializable;

public interface StandardPayload extends Serializable {
    byte[] encode();

    void decode(byte[] data);
}
