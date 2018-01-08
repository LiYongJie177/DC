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
@Table(name="ad_info")
public class ADInfo implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**广告ID*/
    @Column(length=32)
    private String storeId;             /**店铺ID*/
    @OneToOne(targetEntity = FoodImageInfo.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "image_id",
            foreignKey = @ForeignKey(name = "DC_AD_INFO_FK2", value = ConstraintMode.NO_CONSTRAINT))
    private FoodImageInfo imageId;             /**图片ID*/
    private String link;                /**链接*/
    private Integer sequence;           /**顺序*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date uploadingTime;         /**上传时间*/
}
