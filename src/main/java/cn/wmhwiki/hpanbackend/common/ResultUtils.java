package cn.wmhwiki.hpanbackend.common;

public class ResultUtils {
    public static <T> BaseResponse<T> success(T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(200);
        response.setData(data);
        response.setMsg("success");
        return response;
    }

    public static <T> BaseResponse<T> error(String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(500);
        response.setMsg(msg);
        return response;
    }

    public static <T> BaseResponse<T> error(int code, String msg) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    // 传参 ErrorCode
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(errorCode.getCode());
        response.setMsg(errorCode.getMsg());
        return response;
    }
}
