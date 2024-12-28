package com.cool.tu.model.dto.picture;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

// 图片上传请求
@Data
public class PictureUploadRequest implements Serializable {

    /**
     * 图片 id（用于修改）
     */
    private Long id;

    /**
     * 图片名称
     */
    private String picName;

    /**
     * 文件地址
     */
    private String fileUrl;

    /**
     * 空间 id
     */
    private Long spaceId;

    /**
     * 图片主色调
     */
    private String picColor;


    @Serial
    private static final long serialVersionUID = 1L;
}