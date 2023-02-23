package com.doodmail.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.common.utils.Query;

import com.doodmail.product.dao.UserUplineTblDao;
import com.doodmail.product.entity.UserUplineTblEntity;
import com.doodmail.product.service.UserUplineTblService;


@Service("userUplineTblService")
public class UserUplineTblServiceImpl extends ServiceImpl<UserUplineTblDao, UserUplineTblEntity> implements UserUplineTblService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UserUplineTblEntity> page = this.page(
                new Query<UserUplineTblEntity>().getPage(params),
                new QueryWrapper<UserUplineTblEntity>()
        );

        return new PageUtils(page);
    }

}