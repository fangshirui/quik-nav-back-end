package cn.fangshirui.navweb.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 网站分类的标签
 *
 * @author kk
 * @date 2020/08/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tag {

    private int tid;

    private String tname;

    private int torder;

    private List<Website> websiteList;

}
