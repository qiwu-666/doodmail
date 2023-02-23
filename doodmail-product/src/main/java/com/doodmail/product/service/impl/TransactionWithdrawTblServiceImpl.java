package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.TransactionWithdrawTblDao;
import com.doodmail.product.entity.TransactionWithdrawTblEntity;
import com.doodmail.product.service.TransactionWithdrawTblService;


@Service("transactionWithdrawTblService")
public class TransactionWithdrawTblServiceImpl extends ServiceImpl<TransactionWithdrawTblDao, TransactionWithdrawTblEntity> implements TransactionWithdrawTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TransactionWithdrawTblEntity> page = this.page(
                new Query<TransactionWithdrawTblEntity>().getPage(params),
                new QueryWrapper<TransactionWithdrawTblEntity>()
        );

        return new PageUtils(page);
    }

}