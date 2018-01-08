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

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name="food_storage_info")
public class FoodStorageInfo implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="food_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**物品列表ID*/
    @OneToOne(targetEntity = SysUser.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "DC_FOOD_STORAGE_INFO_FK1", value = ConstraintMode.NO_CONSTRAINT))
    private String storeId;             /**店铺ID*/
    @Column(length=64)
    private String foodName;            /**物品名称*/
    @OneToOne(targetEntity = FoodImageInfo.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "image_id",
            foreignKey = @ForeignKey(name = "DC_FOOD_STORAGE_INFO_FK2", value = ConstraintMode.NO_CONSTRAINT))
    private String imageId;            /**物品图片ID*/
    private String description;        /**物品描述*/
    @Column(length=2)
    private String status;             /**物品状态*/
    private Integer stock;             /**库存量*/
    @Column(length=32)
    private String class_name;         /**物品类别*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date onShelfTime;        /**上架时间*/
}