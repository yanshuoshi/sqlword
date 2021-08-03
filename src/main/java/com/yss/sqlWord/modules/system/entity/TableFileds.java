package com.yss.sqlWord.modules.system.entity;

import lombok.Data;

/**
 * <p> 数据库表字段信息 </p>
 *
 * @author : yss
 * @description :
 */
@Data
public class TableFileds {

    /**
     * 字段名
     */
    private String field;
    /**
     * 类型
     */
    private String type;
    /**
     * 是否为空
     */
    private String Null;
    /**
     * 主键
     */
    private String key;
    /**
     * 字段说明
     */
    private String comment;
    /**
     * 默认值
     */
    private String Default;

}
