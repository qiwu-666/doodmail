package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.TransactionTblDao;
import com.doodmail.product.entity.TransactionTblEntity;
import com.doodmail.product.service.TransactionTblService;


@Service("transactionTblService")
public class TransactionTblServiceImpl extends ServiceImpl<TransactionTblDao, TransactionTblEntity> implements TransactionTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TransactionTblEntity> page = this.page(
                new Query<TransactionTblEntity>().getPage(params),
                new QueryWrapper<TransactionTblEntity>()
        );

        return new PageUtils(page);
    }

}