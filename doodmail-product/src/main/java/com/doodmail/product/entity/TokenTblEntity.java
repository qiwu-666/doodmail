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
@TableName("token_tbl")
public class TokenTblEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer tTokenId;
	/**
	 * 
	 */
	private String tUserId;
	/**
	 * 
	 */
	private String tTokenKey;
	/**
	 * 
	 */
	private Integer tTokenStatus;
	/**
	 * 
	 */
	private String tTokenExpireDate;
	/**
	 * 
	 */
	private String tTokenAccessType;
	/**
	 * 
	 */
	private String tAppRandomKey;

}
