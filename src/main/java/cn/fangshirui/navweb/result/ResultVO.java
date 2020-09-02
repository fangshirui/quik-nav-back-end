package cn.fangshirui.navweb.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回结果封装
 * result view object
 *
 * @author kk
 * @date 2020/08/31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> {

    /**
     * 成功标志
     */
    private Boolean success;

    /**
     * 失败消息
     */
    private String message;

    /**
     * 返回代码
     */
    private Integer code;

    /**
     * 时间戳
     */
    private Long timeStamp;

    /**
     * 结果对象
     */
    private T result;
}
