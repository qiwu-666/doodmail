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
@TableName("bonus_tbl")
public class BonusTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer btId;
	/**
	 * 
	 */
	private String btName;
	/**
	 * 
	 */
	private String btValue;
	/**
	 * 
	 */
	private String btModifiedDatetime;
	/**
	 * 
	 */
	private String btRemarks;

}
