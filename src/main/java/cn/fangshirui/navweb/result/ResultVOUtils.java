package cn.fangshirui.navweb.result;


import cn.fangshirui.navweb.result.status.StatusCode;

/**
 * 结果voutils
 *
 * @author kk
 * @date 2020/08/31
 */
public class ResultVOUtils {

    public static ResultVO<Object> vo(boolean success, int code, String message, Object data) {

        long timeStamp = System.currentTimeMillis();
        return new ResultVO<>(success, message, code, timeStamp, data);
    }

    public static ResultVO<Object> success() {
        return vo(true, StatusCode.SUCCESS_CODE, "成功", null);
    }

    public static ResultVO<Object> success(String msg, int code) {
        return vo(true, code, msg, null);
    }

    public static ResultVO<Object> success(Object data) {
        return vo(true, StatusCode.SUCCESS_CODE, "成功", data);
    }

    public static ResultVO<Object> success(String msg, Object data) {
        return vo(true, StatusCode.SUCCESS_CODE, msg, data);
    }

    public static ResultVO<Object> error() {
        return vo(false, StatusCode.ERROR_CODE, "失败", null);
    }

    public static ResultVO<Object> error(String msg, int code) {
        return vo(false, code, msg, null);
    }

    public static ResultVO<Object> error(String msg, Object data) {
        return vo(false, StatusCode.ERROR_CODE, msg, data);
    }

    public static ResultVO<Object> error(Object data) {
        return vo(false, StatusCode.ERROR_CODE, "失败", data);
    }
}
