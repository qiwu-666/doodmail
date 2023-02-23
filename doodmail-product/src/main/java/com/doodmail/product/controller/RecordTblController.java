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

import com.doodmail.product.entity.RecordTblEntity;
import com.doodmail.product.service.RecordTblService;
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
@RequestMapping("product/recordtbl")
public class RecordTblController {
    @Autowired
    private RecordTblService recordTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = recordTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rtId}")
    public R info(@PathVariable("rtId") Integer rtId){
		RecordTblEntity recordTbl = recordTblService.getById(rtId);

        return R.ok().put("recordTbl", recordTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RecordTblEntity recordTbl){
		recordTblService.save(recordTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RecordTblEntity recordTbl){
		recordTblService.updateById(recordTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] rtIds){
		recordTblService.removeByIds(Arrays.asList(rtIds));

        return R.ok();
    }

}
