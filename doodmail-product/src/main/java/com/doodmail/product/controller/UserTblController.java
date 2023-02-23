package com.doodmail.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodmail.product.entity.UserTblEntity;
import com.doodmail.product.service.UserTblService;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.R;



/**
 * 
 *
 * @author qyl
 * @email sunlightcs@gmail.com
 * @date 2023-02-23 16:07:51
 */
@RestController
@RequestMapping("product/usertbl")
public class UserTblController {
    @Autowired
    private UserTblService userTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uUserId}")
    public R info(@PathVariable("uUserId") Integer uUserId){
		UserTblEntity userTbl = userTblService.getById(uUserId);

        return R.ok().put("userTbl", userTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserTblEntity userTbl){
		userTblService.save(userTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserTblEntity userTbl){
		userTblService.updateById(userTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] uUserIds){
		userTblService.removeByIds(Arrays.asList(uUserIds));

        return R.ok();
    }

}
