package com.doodmail.product.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doodmail.product.entity.BonusTblEntity;
import com.doodmail.product.service.BonusTblService;
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
@RequestMapping("product/bonustbl")
public class BonusTblController {
    @Autowired
    private BonusTblService bonusTblService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = bonusTblService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{btId}")
    public R info(@PathVariable("btId") Integer btId){
		BonusTblEntity bonusTbl = bonusTblService.getById(btId);

        return R.ok().put("bonusTbl", bonusTbl);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BonusTblEntity bonusTbl){
		bonusTblService.save(bonusTbl);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BonusTblEntity bonusTbl){
		bonusTblService.updateById(bonusTbl);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] btIds){
		bonusTblService.removeByIds(Arrays.asList(btIds));

        return R.ok();
    }

}
