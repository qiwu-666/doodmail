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

import com.doodmail.product.entity.TransactionTblEntity;
import com.doodmail.product.service.TransactionTblService;
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
@RequestMapping("product/transactiontbl")
public class TransactionTblController {
    @Autowired
    private TransactionTblService transactionTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = transactionTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{ttId}")
    public R info(@PathVariable("ttId") Integer ttId){
		TransactionTblEntity transactionTbl = transactionTblService.getById(ttId);

        return R.ok().put("transactionTbl", transactionTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TransactionTblEntity transactionTbl){
		transactionTblService.save(transactionTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TransactionTblEntity transactionTbl){
		transactionTblService.updateById(transactionTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ttIds){
		transactionTblService.removeByIds(Arrays.asList(ttIds));

        return R.ok();
    }

}
