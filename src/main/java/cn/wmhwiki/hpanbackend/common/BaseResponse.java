package cn.wmhwiki.hpanbackend.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable {
    private int code;
    private T data;
    private String msg;
}
