package com.kdkj.dc.entity;

import com.kdkj.dc.utils.Constant;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="order_details_list")
public class OrderDetailsList implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="order_details_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**订单详情ID*/
    @OneToOne(targetEntity = SysUser.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "DC_ORDER_DETAILS_FK1", value = ConstraintMode.NO_CONSTRAINT))
    private String storeId;             /**店铺ID*/
    @ManyToOne(targetEntity = OrderList.class)
    @JoinColumn(name = "order_id", nullable = false,
            foreignKey = @ForeignKey(name = "DC_ORDER_DETAILS_FK2", value = ConstraintMode.NO_CONSTRAINT))
    private OrderList orderId;             /**订单ID*/
    @Column(name="order_status", length=2)
    private String orderStatus;         /**是否配送*/
    @Column(length=32)
    private String foodId;              /**物品ID*/
    @Column(length=64)
    private String foodName;            /**物品名称*/
    @Column(length=32)
    private String foodType;            /**物品类型*/
    private Double foodPrice;           /**物品价格*/
    private Integer foodAmount;         /**物品总数*/
    private String description;         /**订单备注*/
}
