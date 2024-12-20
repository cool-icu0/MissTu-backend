package com.cool.tu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cool.tu.model.dto.picture.PictureQueryRequest;
import com.cool.tu.model.dto.picture.PictureReviewRequest;
import com.cool.tu.model.dto.picture.PictureUploadByBatchRequest;
import com.cool.tu.model.dto.picture.PictureUploadRequest;
import com.cool.tu.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.entity.User;
import com.cool.tu.model.vo.picture.PictureVO;
import org.springframework.scheduling.annotation.Async;
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
     * @param inputSource
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    void validPicture(Picture picture);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest
     * @param loginUser
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest, User loginUser);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest
     * @param loginUser
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);


    /**
     * 自动填充审核参数
     *
     * @param picture
     * @param loginUser
     */
    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 删除图片文件
     * @param oldPicture
     */
    @Async
    void clearPictureFile(Picture oldPicture);
}
