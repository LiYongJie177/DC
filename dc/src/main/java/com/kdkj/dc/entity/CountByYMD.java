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
import com.kdkj.dc.enums.YMDType;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="count_by_ymd")
public class CountByYMD implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**ID*/
    @Column(length=32)
    private String storeId;             /**店铺ID*/
    private Double income;              /**当年收入*/
    private Integer orderAmount;        /**订单数统计*/
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date countDate;             /**日期*/
    @Column(name = "type", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private YMDType type;            /**类型(例：年月日)*/
}
