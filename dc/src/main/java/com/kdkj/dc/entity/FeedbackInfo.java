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
@Table(name="feedback_info")
public class FeedbackInfo implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="feedback_id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**反馈ID*/
    @OneToOne(targetEntity = SysUser.class, fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "store_id",
            foreignKey = @ForeignKey(name = "DC_FEEDBACK_INFO_FK1", value = ConstraintMode.NO_CONSTRAINT))
    private String storeId;             /**店铺ID*/
    @Column(length=500)
    private String description;         /**意见描述*/
    private String contactMethod;      /**联系方式*/
    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "timestamp")
    private Date commentTime;          /**发表时间*/
}
