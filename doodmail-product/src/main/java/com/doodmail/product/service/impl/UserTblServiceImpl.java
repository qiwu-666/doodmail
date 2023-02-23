package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.UserTblDao;
import com.doodmail.product.entity.UserTblEntity;
import com.doodmail.product.service.UserTblService;


@Service("userTblService")
public class UserTblServiceImpl extends ServiceImpl<UserTblDao, UserTblEntity> implements UserTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserTblEntity> page = this.page(
                new Query<UserTblEntity>().getPage(params),
                new QueryWrapper<UserTblEntity>()
        );

        return new PageUtils(page);
    }

}