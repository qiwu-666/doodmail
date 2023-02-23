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
@TableName("user_tbl")
public class UserTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer uUserId;
	/**
	 * 
	 */
	private String uLinkdoodId;
	/**
	 * 
	 */
	private String uUserSecret;
	/**
	 * 
	 */
	private String uFirstName;
	/**
	 * 
	 */
	private String uLastName;
	/**
	 * 
	 */
	private String uCountryCode;
	/**
	 * 
	 */
	private String uContactNo;
	/**
	 * 
	 */
	private String uDob;
	/**
	 * 
	 */
	private String uLanguageKnown;
	/**
	 * 
	 */
	private String uGender;
	/**
	 * 
	 */
	private String uEmailAddress;
	/**
	 * 
	 */
	private String uLastLocation;
	/**
	 * 
	 */
	private String uLastLocationDatetime;
	/**
	 * 
	 */
	private String uMoney;
	/**
	 * 
	 */
	private Integer uStatus;
	/**
	 * 
	 */
	private String uNId;
	/**
	 * 
	 */
	private String uEnergy;
	/**
	 * 
	 */
	private String uLevel;

}
