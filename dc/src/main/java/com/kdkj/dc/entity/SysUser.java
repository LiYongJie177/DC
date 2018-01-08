package com.kdkj.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.*;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="stores_list")
public class SysUser implements Serializable {
    @Id
    @Column(name="store_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**店铺ID*/
    @Column(length = 64)
    private String storeName;           /**商铺名称*/
    @Column(length = 20)
    private String contacts;            /**联系人*/
    @Email
    @Column(length = 64)
    private String email;               /**邮箱*/
    @Column(length = 18)
    private Long idCard;                /**身份证号*/
    @Column(length = 11)
    private Long phone;                 /**手机号*/
    private String password;            /**密码*/
    private String salt;                /**盐*/
    @Column(length = 64)
    private String address;             /**地址*/
    @Column(name="descrption")
    private String des;                 /**描述*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date rentTime;              /**租用日期*/
    @Temporal(TemporalType.DATE)
    private Date deadline;              /**截止期限*/
    @Column(length = 2)
    private Integer status;              /**是否启用*/
    @Column(length = 20)
    private Double rentFee;             /**租用费用*/
    @Column(length = 64)
    private String alipayAccount;       /**支付宝商户号*/
    @Column(length = 64)
    private String wechatAccount;       /**微信商户号*/
    @Version
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date updateTime;            /**修改时间*/
}
