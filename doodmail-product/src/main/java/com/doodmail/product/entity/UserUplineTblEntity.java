package com.doodmail.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author qyl
 * @email sunlightcs@gmail.com
 * @date 2023-02-23 16:07:51
 */
@Data
@TableName("user_upline_tbl")
public class UserUplineTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer uuId;
	/**
	 * 
	 */
	private Integer uuUserId;
	/**
	 * 
	 */
	private String uuPromotionCode;
	/**
	 * 
	 */
	private String uuUpline;
	/**
	 * 
	 */
	private String uuDatetime;

}
