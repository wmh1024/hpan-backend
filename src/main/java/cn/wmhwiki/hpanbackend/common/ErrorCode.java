package cn.wmhwiki.hpanbackend.common;

public enum ErrorCode {
    SUCCESS(200, "success"),
    ERROR(500, "error");
    private final int code;
    private final String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
