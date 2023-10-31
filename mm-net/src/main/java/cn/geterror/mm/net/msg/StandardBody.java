package cn.geterror.mm.net.msg;


import lombok.Data;

@Data
public class StandardBody<T extends StandardPayload> {
    int code;
    T data;
}
