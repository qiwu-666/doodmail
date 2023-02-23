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
 * @date 2023-02-23 16:07:52
 */
@Data
@TableName("record_tbl")
public class RecordTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer rtId;
	/**
	 * 
	 */
	private String rtPromotionCode;
	/**
	 * 
	 */
	private String rtOtn;
	/**
	 * 
	 */
	private String rtOriPrice;
	/**
	 * 
	 */
	private String rtFinalPrice;
	/**
	 * 
	 */
	private String rtVmType;
	/**
	 * 
	 */
	private String rtDatetime;
	/**
	 * 
	 */
	private String rtInsertedDatetime;
	/**
	 * 
	 */
	private String rtProfit;
	/**
	 * 
	 */
	private String rtCurrency;
	/**
	 * 
	 */
	private String rtHash;
	/**
	 * 
	 */
	private String rtInout;
	/**
	 * 
	 */
	private String rtFrom;

}
