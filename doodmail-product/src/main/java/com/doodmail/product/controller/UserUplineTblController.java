package com.doodmail.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodmail.product.entity.UserUplineTblEntity;
import com.doodmail.product.service.UserUplineTblService;
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
@RequestMapping("product/useruplinetbl")
public class UserUplineTblController {
    @Autowired
    private UserUplineTblService userUplineTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = userUplineTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{uuId}")
    public R info(@PathVariable("uuId") Integer uuId){
		UserUplineTblEntity userUplineTbl = userUplineTblService.getById(uuId);

        return R.ok().put("userUplineTbl", userUplineTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody UserUplineTblEntity userUplineTbl){
		userUplineTblService.save(userUplineTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody UserUplineTblEntity userUplineTbl){
		userUplineTblService.updateById(userUplineTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] uuIds){
		userUplineTblService.removeByIds(Arrays.asList(uuIds));

        return R.ok();
    }

}
