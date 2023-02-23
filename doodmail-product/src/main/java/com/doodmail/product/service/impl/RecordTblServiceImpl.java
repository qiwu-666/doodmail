package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.RecordTblDao;
import com.doodmail.product.entity.RecordTblEntity;
import com.doodmail.product.service.RecordTblService;


@Service("recordTblService")
public class RecordTblServiceImpl extends ServiceImpl<RecordTblDao, RecordTblEntity> implements RecordTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecordTblEntity> page = this.page(
                new Query<RecordTblEntity>().getPage(params),
                new QueryWrapper<RecordTblEntity>()
        );

        return new PageUtils(page);
    }

}