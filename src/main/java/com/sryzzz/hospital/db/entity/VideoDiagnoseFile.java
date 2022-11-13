package com.sryzzz.hospital.db.entity;

import lombok.Data;

/**
 * 视频诊断文件
 *
 * @author sryzzz
 * @create 2022/11/12 13:40
 * @description 视频诊断文件
 */
@Data
public class VideoDiagnoseFile {
    private Integer id;
    private Integer videoDiagnoseId;
    private String filename;
    private String path;
    private String createTime;

}