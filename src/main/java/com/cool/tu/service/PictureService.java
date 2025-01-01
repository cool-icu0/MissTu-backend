package com.cool.tu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cool.tu.api.aliyunAI.model.CreateOutPaintingTaskResponse;
import com.cool.tu.api.aliyunAI.model.GetOutPaintingTaskResponse;
import com.cool.tu.model.dto.picture.*;
import com.cool.tu.model.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.entity.User;
import com.cool.tu.model.vo.picture.PictureTagCategory;
import com.cool.tu.model.vo.picture.PictureVO;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Cool
 * @description 针对表【picture(图片)】的数据库操作Service
 * @createDate 2024-12-17 12:13:01
 */
public interface PictureService extends IService<Picture> {

    /**
     * 校验图片
     *
     * @param picture 图片
     */
    void validPicture(Picture picture);

    /**
     * 上传图片
     *
     * @param inputSource          文件输入源
     * @param pictureUploadRequest 上传请求
     * @param loginUser            登录用户
     * @return 图片
     */
    PictureVO uploadPicture(Object inputSource,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    /**
     * 获取图片包装类（单条）
     *
     * @param id      图片id
     * @param request 请求
     * @return 图片包装类
     */
    PictureVO getPictureVO(Long id, HttpServletRequest request);

    /**
     * 获取图片包装类（多条）
     *
     * @param picturePage 图片分页
     * @param request     请求
     * @return 图片包装类分页
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 获取查询对象
     *
     * @param pictureQueryRequest 查询请求
     * @return 查询对象
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 图片审核
     *
     * @param pictureReviewRequest 图片审核请求
     * @param loginUser            登录用户
     */
    void doPictureReview(PictureReviewRequest pictureReviewRequest, User loginUser);

    /**
     * 自动填充审核参数
     *
     * @param picture   图片
     * @param loginUser 登录用户
     */
    void fillReviewParams(Picture picture, User loginUser);

    /**
     * 批量抓取和创建图片
     *
     * @param pictureUploadByBatchRequest 批量上传请求
     * @param loginUser                   登录用户
     * @return 成功创建的图片数
     */
    Integer uploadPictureByBatch(PictureUploadByBatchRequest pictureUploadByBatchRequest, User loginUser);

    /**
     * 清理图片文件
     *
     * @param oldPicture 旧图片
     */
    @Async
    void clearPictureFile(Picture oldPicture);

    /**
     * 删除图片
     *
     * @param pictureId 图片id
     * @param loginUser 登录用户
     */
    void deletePicture(long pictureId, User loginUser);

    /**
     * 编辑图片
     *
     * @param pictureEditRequest 图片编辑请求
     * @param loginUser          登录用户
     */
    void editPicture(PictureEditRequest pictureEditRequest, User loginUser);

    /**
     * 校验空间图片的权限
     *
     * @param loginUser 登录用户
     * @param picture   图片
     */
    void checkPictureAuth(User loginUser, Picture picture);

    /**
     * 更新图片
     *
     * @param pictureUpdateRequest 图片更新请求
     * @param loginUser            登录用户
     */
    void updatePicture(PictureUpdateRequest pictureUpdateRequest, User loginUser);

    /**
     * 分页获取图片（封装类）
     *
     * @param pictureQueryRequest 图片查询请求
     * @param request             请求
     * @return 图片分页
     */
    Page<Picture> listPictureVOByPage(PictureQueryRequest pictureQueryRequest, HttpServletRequest request);

    /**
     * 获取图片标签分类
     *
     * @return 图片标签分类
     */
    PictureTagCategory listPictureTagCategory();

    /**
     * 分页获取图片（封装类）（缓存）
     *
     * @param pictureQueryRequest 图片查询请求
     * @param request             请求
     * @return 图片分页
     */
    Page<PictureVO> listPictureVOByPageWithCache(PictureQueryRequest pictureQueryRequest, HttpServletRequest request);

    /**
     * 根据颜色搜索图片
     *
     * @param spaceId   空间id
     * @param picColor  图片颜色
     * @param loginUser 登录用户
     * @return 图片列表
     */
    List<PictureVO> searchPictureByColor(Long spaceId, String picColor, User loginUser);

    /**
     * 批量编辑图片
     *
     * @param pictureEditByBatchRequest 批量编辑请求
     * @param loginUser                 登录用户
     */
    @Transactional(rollbackFor = Exception.class)
    void editPictureByBatch(PictureEditByBatchRequest pictureEditByBatchRequest, User loginUser);

    /**
     * AI扩图，生成图片
     *
     * @param createPictureOutPaintingTaskRequest 创建图片生成任务请求
     * @param loginUser                           登录用户
     * @return 生成任务响应
     */
    CreateOutPaintingTaskResponse createPictureOutPaintingTask(CreatePictureOutPaintingTaskRequest createPictureOutPaintingTaskRequest, User loginUser);

    /**
     * 查询 AI 扩图任务执行情况
     *
     * @param taskId 任务id
     * @return 任务响应
     */
    GetOutPaintingTaskResponse getPictureOutPaintingTask(String taskId);
}

