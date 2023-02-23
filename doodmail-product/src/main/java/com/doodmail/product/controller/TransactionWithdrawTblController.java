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

import com.doodmail.product.entity.TransactionWithdrawTblEntity;
import com.doodmail.product.service.TransactionWithdrawTblService;
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
@RequestMapping("product/transactionwithdrawtbl")
public class TransactionWithdrawTblController {
    @Autowired
    private TransactionWithdrawTblService transactionWithdrawTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = transactionWithdrawTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{twtId}")
    public R info(@PathVariable("twtId") Integer twtId){
		TransactionWithdrawTblEntity transactionWithdrawTbl = transactionWithdrawTblService.getById(twtId);

        return R.ok().put("transactionWithdrawTbl", transactionWithdrawTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TransactionWithdrawTblEntity transactionWithdrawTbl){
		transactionWithdrawTblService.save(transactionWithdrawTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TransactionWithdrawTblEntity transactionWithdrawTbl){
		transactionWithdrawTblService.updateById(transactionWithdrawTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] twtIds){
		transactionWithdrawTblService.removeByIds(Arrays.asList(twtIds));

        return R.ok();
    }

}
