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
@Table(name="food_price_info")
public class FoodPriceInfo implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="food_info_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**物品价格列表ID*/
    @OneToOne(targetEntity = SysUser.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "DC_FOOD_PRICE_INFO_FK1", value = ConstraintMode.NO_CONSTRAINT))
    private String storeId;             /**店铺ID*/
    private String foodId;             /**物品ID*/
    private Double foodPrice;            /**物品价格*/
    private Double discount;            /**折扣*/
    @Column(length=20)
    private String foodType;            /**物品类型(例：大中小)*/
}
