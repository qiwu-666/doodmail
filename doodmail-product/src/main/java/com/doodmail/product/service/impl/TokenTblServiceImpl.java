package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.TokenTblDao;
import com.doodmail.product.entity.TokenTblEntity;
import com.doodmail.product.service.TokenTblService;


@Service("tokenTblService")
public class TokenTblServiceImpl extends ServiceImpl<TokenTblDao, TokenTblEntity> implements TokenTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<TokenTblEntity> page = this.page(
                new Query<TokenTblEntity>().getPage(params),
                new QueryWrapper<TokenTblEntity>()
        );

        return new PageUtils(page);
    }

}