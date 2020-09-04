package cn.fangshirui.navweb.mapper;

import cn.fangshirui.navweb.pojo.Tag;
import cn.fangshirui.navweb.pojo.Website;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * 网站映射器
 *
 * @author kk
 * @date 2020/08/29
 */
@Mapper
public interface WebsitesMapper {


    /**
     * 查询网站
     *
     * @param website 网站 只需要website中的id号
     * @return int
     */
    Website queryWebsite(Website website);


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
     * 更新网站
     *
     * @param website 网站
     * @return int
     */
    int updateWebsite(Website website);

    /**
     * 查询所有网站
     *
     * @return {@link List<Website>}
     */
    List<Website> queryAllWebsite();


    /**
     * 查询某一分类下的所有网站
     *
     * @param tagId 标签的id号
     * @return {@link List<Website>}
     */
    List<Website> queryWebsiteByTagId(int tagId);


    /**
     * 查询标签
     *
     * @param tag 标签
     * @return {@link Tag}
     */
    Tag queryTag(Tag tag);

    /**
     *  查询所有分类（分类下包含该分类下的网站）
     *
     * @return {@link List<Tag>}
     */
    List<Tag> queryAllTag();


    /**
     * 查询开放分类，保密分类不查询
     *
     * @return {@link List<Tag>}
     */
    List<Tag> queryOpenTag();


    /**
     * 更新标签名以及保密分类信息
     *
     * @param tag 标签
     * @return {@link String}
     */
    int updateTag(Tag tag);


    /**
     * 通过tid删除某个分类
     *
     *
     * @param tid tid
     * @return int
     */
    int deleteTagById(int tid);


    /**
     * 通过tid删除所有该分类的网站
     *
     * @param tid tid
     * @return int
     */
    int deleteWebsiteByTagId(int tid);

    /**
     * 插入分类
     *
     * @param tag 分类
     * @return int
     */
    int insertTag(Tag tag);

    /**
     * 查询所有标记名称
     *
     * @return {@link List<String>}
     */
    List<String> queryAllTagName();

    /**
     * 获得网站最大的顺序值  顺序值从1开始
     * 也即是网站总条目
     *
     * @return int
     */
    int getMaxOrder();


    /**
     * 得到分类的最大顺序
     *
     * @return int
     */
    int getMaxOrderOfTag();


    /**
     * 更新某网站条目顺序号 往后调 order >= oldOrder
     * oldOrder可通过id计算得到
     * @param map  包含三个属性 “id”  "order"  "oldOrder"
     * @return int
     */
    int updateOrderByIdAfter(Map<String, Integer> map);


    /**
     * 更新某网站条目顺序号 往前调 order < oldOrder
     * oldOrder可通过id计算得到
     * @param map 包含两个属性 “id”  "order"  "oldOrder"
     * @return int
     */
    int updateOrderByIdBefore(Map<String, Integer> map);


    /**
     * 根据id获得序号
     *
     * @param id id
     * @return int
     */
    int getOrder(int id);


    /**
     * 根据tid得到该分类的顺序
     *
     * @param tid tid
     * @return int
     */
    int getTagOrder(int tid);


    /**
     * 更新分类顺序，新的在后
     *
     * @param tag 标签
     */
    void updateTagOrderAfter(Tag tag);

    /**
     * 更新分类顺序，新的在前
     *
     * @param tag 标签
     */
    void updateTagOrderBefore(Tag tag);
}
