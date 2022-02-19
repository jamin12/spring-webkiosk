package com.example.webkiosk.entity;

import lombok.Data;

@Data
public class FileDto {

    // 파일 이름
    private String fileName;

    // 파일 저장 경로
    private String filePath;

    // 파일 사이즈
    private Long fileSize;

}
