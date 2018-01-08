package com.kdkj.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kdkj.dc.utils.Constant;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="operation_info")
public class OperationInfo implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="operation_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**操作记录ID*/
    @OneToOne(targetEntity = SysUser.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "DC_OPERATION_INFO_FK1", value = ConstraintMode.NO_CONSTRAINT))
    private String storeId;             /**店铺ID*/
    @Column(length=32)
    private String operation_type;      /**操作类型*/
    private Double refundMoney;         /**退款金额*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date refundTime;            /**退款时间*/
    private Double earningOrLoss;       /**（+）盈利或（-）亏损金额*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date recordDate;            /**记录时间*/
    @Column(length=32)
    private String foodId;              /**物品ID*/
    @Column(length=64)
    private String foodName;            /**物品名称*/
    private Double foodPrice;           /**物品价格*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date orderTime;             /**点菜时间*/
}
