package com.example.demo.model;

import lombok.Data;

/**
 * @Author: wangzi
 * @Date: 2018/10/31 16:50
 */
@Data
public class YascmfDatas {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 模型
     */
    private Integer model;

    /**
     * 设备id
     */
    private String instrumentId;

    /**
     * 数据日期
     */
    private String dateTime;

    /**
     * 坐标
     */
    private String coordinate;

    /**
     * ph
     */
    private Double ph;

    /**
     * 导电性
     */
    private Double conductivity;

    /**
     * 水温
     */
    private Double waterTemperature;

    /**
     * 氨氮
     */
    private Double ammoniaNitrogen;

    /**
     * 溶解氧
     */
    private Double dissolvedOxygen;

    /**
     * 水平
     */
    private Double level;

    /**
     * 意外
     */
    private Boolean exception;

    /**
     * 浊度
     */
    private Double ntu;

    /**
     * 总磷
     */
    private Double p;
}
