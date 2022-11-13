package com.sryzzz.hospital.db.entity;

import java.math.BigDecimal;

import lombok.Data;

/**
 * 视频诊断
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 视频诊断
 */
@Data
public class VideoDiagnose {
    private Integer id;
    private Integer patientCardId;
    private Integer doctorId;
    private String outTradeNo;
    private BigDecimal amount;
    private Byte paymentStatus;
    private String prepayId;
    private String transactionId;
    private String expectStart;
    private String expectEnd;
    private String realStart;
    private String realEnd;
    private Byte status;
    private String createTime;

}