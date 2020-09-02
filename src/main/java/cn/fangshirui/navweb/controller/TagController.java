package cn.fangshirui.navweb.controller;

import cn.fangshirui.navweb.pojo.Tag;
import cn.fangshirui.navweb.pojo.Website;
import cn.fangshirui.navweb.result.ResultVO;
import cn.fangshirui.navweb.result.ResultVOUtils;
import cn.fangshirui.navweb.service.WebsitesServices;
import cn.fangshirui.navweb.service.WebsitesServicesImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签控制器
 *
 * @author kk
 * @date 2020/08/31
 */
@Api
@RestController
@RequestMapping("/api")
public class TagController {

    private final WebsitesServices websitesServices;

    @Autowired
    public TagController(WebsitesServicesImpl websitesServicesImpl) {
        this.websitesServices = websitesServicesImpl;
    }


    @ApiOperation("请求某个分类下的所有网站")
    @GetMapping("/getTagById/{tagId}")
    public ResultVO<Object> getWeb(@PathVariable("tagId") int id) {

        List<Website> websiteList = websitesServices.getWebsiteByTagId(id);

        return ResultVOUtils.success(websiteList);
    }


    @ApiOperation("请求所有分类下的所有网站")
    @GetMapping("tag")
    public ResultVO<Object> getAllTag() {
        List<Tag> webTag = websitesServices.getAllTag();

        return ResultVOUtils.success(webTag);

    }


    @ApiOperation("更新分类名以及顺序")
    @PutMapping("tag")
    public ResultVO<Object> updateTagName(Tag tag) {
        // 使用三个属性  tid tname torder
        websitesServices.updateTagName(tag);
        websitesServices.adjustTagOrder(tag);

        List<Tag> tags = websitesServices.getAllTag();
        return ResultVOUtils.success(tags);
    }


    @ApiOperation("添加新的分类")
    @PostMapping("tag")
    public ResultVO<Object> insertTag(String tname) {
        // 主要使用到 tag中的 tname属性
        Tag tag = new Tag();
        tag.setTname(tname);
        if (websitesServices.insertTag(tag) > 0) {
            Object data = websitesServices.getAllTag();
            return ResultVOUtils.success(data);
        }

        return ResultVOUtils.error();

    }

    @ApiOperation("删除某分类以及其下的所有网站")
    @DeleteMapping("tag")
    public ResultVO<Object> deleteTag(int tid) {
        // 使用 tid 属性
        websitesServices.deleteTag(tid);
        List<Tag> tags = websitesServices.getAllTag();
        return ResultVOUtils.success(tags);

    }


}
