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

import com.doodmail.product.entity.TokenTblEntity;
import com.doodmail.product.service.TokenTblService;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.R;



/**
 * 
 *
 * @author qyl
 * @email sunlightcs@gmail.com
 * @date 2023-02-23 16:07:52
 */
@RestController
@RequestMapping("product/tokentbl")
public class TokenTblController {
    @Autowired
    private TokenTblService tokenTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = tokenTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{tTokenId}")
    public R info(@PathVariable("tTokenId") Integer tTokenId){
		TokenTblEntity tokenTbl = tokenTblService.getById(tTokenId);

        return R.ok().put("tokenTbl", tokenTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TokenTblEntity tokenTbl){
		tokenTblService.save(tokenTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TokenTblEntity tokenTbl){
		tokenTblService.updateById(tokenTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] tTokenIds){
		tokenTblService.removeByIds(Arrays.asList(tTokenIds));

        return R.ok();
    }

}
