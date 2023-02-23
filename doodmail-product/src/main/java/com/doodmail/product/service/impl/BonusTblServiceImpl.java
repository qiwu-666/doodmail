package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.BonusTblDao;
import com.doodmail.product.entity.BonusTblEntity;
import com.doodmail.product.service.BonusTblService;


@Service("bonusTblService")
public class BonusTblServiceImpl extends ServiceImpl<BonusTblDao, BonusTblEntity> implements BonusTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<BonusTblEntity> page = this.page(
                new Query<BonusTblEntity>().getPage(params),
                new QueryWrapper<BonusTblEntity>()
        );

        return new PageUtils(page);
    }

}