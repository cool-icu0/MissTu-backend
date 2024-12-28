package com.cool.tu.model.dto.picture;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class SearchPictureByPictureRequest implements Serializable {
  
    /**  
     * 图片 id  
     */  
    private Long pictureId;  
  
    @Serial
    private static final long serialVersionUID = 1L;
}