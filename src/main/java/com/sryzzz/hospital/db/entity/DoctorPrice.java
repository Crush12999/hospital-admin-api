package com.sryzzz.hospital.db.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 医生价格
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 医生价格
 */
@Data
public class DoctorPrice {
    private Integer id;
    private Integer doctorId;
    private String level;
    private BigDecimal price_1;
    private BigDecimal price_2;

}