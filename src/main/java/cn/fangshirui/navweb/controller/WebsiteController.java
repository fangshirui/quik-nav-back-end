package cn.fangshirui.navweb.controller;

import cn.fangshirui.navweb.annotation.UserLoginToken;
import cn.fangshirui.navweb.pojo.Website;
import cn.fangshirui.navweb.result.ResultVO;
import cn.fangshirui.navweb.result.ResultVOUtils;
import cn.fangshirui.navweb.result.status.StatusCode;
import cn.fangshirui.navweb.service.WebsitesServices;
import cn.fangshirui.navweb.service.WebsitesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * restful控制器
 *
 * @author kk
 * @date 2020/08/29
 */
@RestController
@RequestMapping("/api")
public class WebsiteController {

    private final WebsitesServices websitesServices;

    @Autowired
    public WebsiteController(WebsitesServicesImpl websitesServicesImpl) {
        this.websitesServices = websitesServicesImpl;
    }


    @UserLoginToken
    @DeleteMapping("/website")
    public ResultVO<Object> deleteWebsite(int id) {

        // 此处发生了一些未知的问题，update成功，但是返回0了
        int res = websitesServices.deleteWebsite(id);
        System.out.println(res);
        return ResultVOUtils.success();
    }



    @UserLoginToken
    @PostMapping("/website")
    public ResultVO<Object> addWeb(Website website) {


        if (websitesServices.addWebsite(website) > 0) {

            return ResultVOUtils.success();
        }
        return ResultVOUtils.error("添加网站失败", StatusCode.ERROR_CODE);

    }

    @UserLoginToken
    @PutMapping("/website")
    public ResultVO<Object> updateWeb(Website website) {
        // 主要使用到其中4个值
        // id url name order

        // 更新name url信息
        websitesServices.updateWebsite(website);

        int id = website.getId();
        int order = website.getOrder();

        // 调整顺序
        websitesServices.adjustOrder(id, order);
        return ResultVOUtils.success();
    }



}
