package com.kdkj.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kdkj.dc.utils.Constant;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@DynamicInsert
@DynamicUpdate
@Entity
@Table(name = "sys_log")
public class SysLog implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(length = 32, name = "id", nullable = false, updatable = false)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;           /**日志ID*/
    @Column(length=32)
    private String storeId;      /**店铺ID*/
    private String ip;           /**店铺ip*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date createDate;     /**创建时间*/
    private String opType;       /**操作类型*/
    private String opDesc;       /**操作描述*/
}
