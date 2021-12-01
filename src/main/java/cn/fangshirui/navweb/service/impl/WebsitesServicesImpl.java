package cn.fangshirui.navweb.service.impl;

import cn.fangshirui.navweb.mapper.WebsitesMapper;
import cn.fangshirui.navweb.pojo.Tag;
import cn.fangshirui.navweb.pojo.Website;

import cn.fangshirui.navweb.service.WebsitesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 获取网站服务实现类
 *
 * @author kk
 * @date 2020/08/29
 */
@Service
public class WebsitesServicesImpl implements WebsitesServices {


    /**
     * 网站映射器
     */
    private final WebsitesMapper websitesMapper;



    @Autowired
    public WebsitesServicesImpl(WebsitesMapper websitesMapper) {
        // 采用构造注入或者设值注入更加安全。
        this.websitesMapper = websitesMapper;
    }

    @Override
    public int addWebsite(Website website) {
        website.setDateTime(new Date());
        website.setOrder(websitesMapper.getMaxOrder() + 1);
        return websitesMapper.addWebsite(website);
    }

    @Override
    public int deleteWebsite(int id) {
        return websitesMapper.deleteWebsite(id);
    }



    @Override
    public List<Website> getWebsiteByTagId(int tagId) {
        return websitesMapper.queryWebsiteByTagId(tagId);
    }

    @Override
    public List<Tag> getAllTag() {
        return websitesMapper.queryAllTag();
    }

    @Override
    public List<Tag> getOpenTag() {
        return websitesMapper.queryOpenTag();
    }

    @Override
    public void updateTag(Tag tag) {

        websitesMapper.updateTag(tag);

    }

    @Override
    public void updateWebsite(Website website) {
        website.setDateTime(new Date());
        websitesMapper.updateWebsite(website);
    }


    @Override
    public int insertTag(Tag tag) {
        tag.setTorder(websitesMapper.getMaxOrderOfTag() + 1);
        return websitesMapper.insertTag(tag);
    }

    @Override
    public void deleteTag(int tid) {
        websitesMapper.deleteWebsiteByTagId(tid);
        websitesMapper.deleteTagById(tid);
    }



    @Override
    public void adjustOrder(int id, int order) {
        int oldOrder = websitesMapper.getOrder(id);

        Map<String, Integer> map = new HashMap<>(3);
        map.put("id", id);
        map.put("order", order);
        map.put("oldOrder", oldOrder);

        if (oldOrder < order) {
            // 新的地点大于旧地点 往后移动
            websitesMapper.updateOrderByIdAfter(map);
        }
        if (oldOrder > order) {
            // 新地点小于旧地点 往前移动
            websitesMapper.updateOrderByIdBefore(map);
        }

        // olOrder == order 不移动
    }

    @Override
    public void adjustTagOrder(Tag tag) {
        int oldOrder =  websitesMapper.getTagOrder(tag.getTid());

        int order = tag.getTorder();

        if(oldOrder < order) {
            websitesMapper.updateTagOrderAfter(tag);
        }
        if(oldOrder > order){
            websitesMapper.updateTagOrderBefore(tag);
        }
    }
}
