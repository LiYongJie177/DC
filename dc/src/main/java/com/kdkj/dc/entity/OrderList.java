package com.kdkj.dc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kdkj.dc.utils.Constant;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="order_list")
public class OrderList implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="order_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**订单ID*/
    @OneToOne(targetEntity = SysUser.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "DC_ORDER_FK1", value = ConstraintMode.NO_CONSTRAINT))
    private String storeId;             /**店铺ID*/
    @OneToMany(targetEntity = OrderDetailsList.class, mappedBy = "orderId", fetch = FetchType.LAZY,
            cascade = { CascadeType.PERSIST, CascadeType.REMOVE })
    private List<OrderDetailsList> orderDetailsId;/**订单详情ID*/
    @Column(length=8)
    private String storeSeatId;         /**桌号*/
    @Column(name="order_status", length=2)
    private String orderStatus;         /**订单状态*/
    private Double orderMoney;          /**订单金额*/
    @Column(length=20)
    private String payMethod;           /**订单方式*/
    @Column(length=2)
    private String payStatus;           /**订单状态*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date payTime;             /**订单支付时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    @Column( updatable = false)
    private Date orderTime;           /**订单创建时间*/
    @Version
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date updateTime;          /**订单修改时间*/
    private String commentInfo;         /**订单备注*/
//    @Formula("(select t.username from sys_user t where t.user_id = user_id)")  // 这相当于可以直接通过sql去数据字典中查找赋值
}
