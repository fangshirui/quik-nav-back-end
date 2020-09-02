package cn.fangshirui.navweb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 网站pojo
 *
 * @author kk
 * @date 2020/08/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Website {

    /**
     * id
     */
    private int id;
    /**
     * 网站的名字
     */
    private String name;
    /**
     * 网站url
     */
    private String url;
    /**
     * 标签id
     */
    private int tagId;

    /**
     * 顺序
     */
    private int order;


    /**
     * 日期时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dateTime;

}
