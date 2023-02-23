package com.doodmail.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodmail.product.entity.RecordPendingTblEntity;
import com.doodmail.product.service.RecordPendingTblService;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.R;



/**
 * 
 *
 * @author qyl
 * @email sunlightcs@gmail.com
 * @date 2023-02-23 16:07:50
 */
@RestController
@RequestMapping("product/recordpendingtbl")
public class RecordPendingTblController {
    @Autowired
    private RecordPendingTblService recordPendingTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = recordPendingTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{rtId}")
    public R info(@PathVariable("rtId") Integer rtId){
		RecordPendingTblEntity recordPendingTbl = recordPendingTblService.getById(rtId);

        return R.ok().put("recordPendingTbl", recordPendingTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RecordPendingTblEntity recordPendingTbl){
		recordPendingTblService.save(recordPendingTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody RecordPendingTblEntity recordPendingTbl){
		recordPendingTblService.updateById(recordPendingTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] rtIds){
		recordPendingTblService.removeByIds(Arrays.asList(rtIds));

        return R.ok();
    }

}
