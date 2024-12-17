package com.cool.tu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cool.tu.model.dto.picture.PictureQueryRequest;
import com.cool.tu.model.dto.picture.PictureUploadRequest;
import com.cool.tu.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.entity.User;
import com.cool.tu.model.vo.picture.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cool
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2024-12-17 12:13:01
 */
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);
}
