package com.kdkj.dc.entity;

import com.kdkj.dc.enums.DictType;
import com.kdkj.dc.utils.Constant;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "sys_dict")
public class SysDict implements Serializable {
    private static final long serialVersionUID = Constant.SYS_SID;
    @Id
    @Column(name="id", length=32)
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid", strategy="uuid")
    private String id;                  /**数据字典ID*/
    @Column(name = "dict_type", length = 20, nullable = false)
    private String dictType;              /**类型*/
    @Column(name = "code", length = 20, nullable = false)
    private String code;                /**代码*/
    @Column(name = "names", length = 20, nullable = false)
    private String name;                /**名称*/
    private String description;         /**描述*/
    @Column(name = "status", length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private DictType status;            /**状态*/
}

