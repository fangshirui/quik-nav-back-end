package cn.fangshirui.navweb.service;

import cn.fangshirui.navweb.pojo.Tag;
import cn.fangshirui.navweb.pojo.Website;

import java.util.List;

/**
 * @author kk
 */
public interface WebsitesServices {




    /**
     * 添加网站
     *
     * @param website 网站
     * @return {@link Boolean}
     */
    int addWebsite(Website website);

    /**
     * 删除网站
     *
     * @param id id
     * @return {@link Boolean}
     */
    int deleteWebsite(int id);




    /**
     * 通过标签id查询该标签下所有网站
     *
     * @param tagId 标签id
     * @return {@link List<Website>}
     */
    List<Website> getWebsiteByTagId(int tagId);



    /**
     * 获得所有标签的网站
     *
     * @return {@link List<Tag>}
     */
    List<Tag> getAllTag();



    /**
     * 更新标签名
     *
     * @param tag 标签
     */
    void updateTagName(Tag tag);


    /**
     * 更新网站条目
     *
     * @param website 网站
     */
    void updateWebsite(Website website);


    /**
     * 新增分类
     *
     * @param tag 标签
     * @return int
     */
    int insertTag(Tag tag);


    /**
     * 删除分类
     * 不仅包括删除分类，也删除分类下的网站条目
     *
     * @param tid tid
     * @return int
     */
    int deleteTag(int tid);




    /**
     * 调整网站的顺序
     * 不仅修改了它的order,还调整了其他网站下的order
     * 详细见 https://www.cnblogs.com/kesimin/p/9441448.html
     *
     * @param id    id
     * @param order 订单
     */
    void adjustOrder(int id, int order);


    /**
     * 调整标签顺序
     *
     * @param tag 标签
     */
    void adjustTagOrder(Tag tag);
}
