package com.doodmail.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.doodmail.common.utils.PageUtils;
import com.doodmail.product.entity.UserTblEntity;

import java.util.Map;

/**
 * 
 *
 * @author qyl
 * @email sunlightcs@gmail.com
 * @date 2023-02-23 16:07:51
 */
public interface UserTblService extends IService<UserTblEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

