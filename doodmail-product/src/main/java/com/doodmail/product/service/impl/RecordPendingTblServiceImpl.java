package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.RecordPendingTblDao;
import com.doodmail.product.entity.RecordPendingTblEntity;
import com.doodmail.product.service.RecordPendingTblService;


@Service("recordPendingTblService")
public class RecordPendingTblServiceImpl extends ServiceImpl<RecordPendingTblDao, RecordPendingTblEntity> implements RecordPendingTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<RecordPendingTblEntity> page = this.page(
                new Query<RecordPendingTblEntity>().getPage(params),
                new QueryWrapper<RecordPendingTblEntity>()
        );

        return new PageUtils(page);
    }

}