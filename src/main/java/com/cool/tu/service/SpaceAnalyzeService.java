package com.cool.tu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.dto.analyze.*;
import com.cool.tu.model.entity.Space;
import com.cool.tu.model.entity.User;
import com.cool.tu.model.vo.analyze.*;

import java.util.List;

public interface SpaceAnalyzeService extends IService<Space> {
    /**
     * 获取空间使用情况分析
     *
     * @param spaceUsageAnalyzeRequest 空间使用情况分析请求封装类
     * @param loginUser                当前登录用户
     * @return  空间使用情况分析响应封装类
     */
    SpaceUsageAnalyzeResponse getSpaceUsageAnalyze(SpaceUsageAnalyzeRequest spaceUsageAnalyzeRequest, User loginUser);
    /**
     * 获取空间图片分类分析
     *
     * @param spaceCategoryAnalyzeRequest    空间图片分类分析请求封装类
     * @param loginUser                      当前登录用户
     * @return  空间图片分类分析响应封装类
     */
    List<SpaceCategoryAnalyzeResponse> getSpaceCategoryAnalyze(SpaceCategoryAnalyzeRequest spaceCategoryAnalyzeRequest, User loginUser);
    /**
     * 获取空间图片标签分析
     *
     * @param spaceTagAnalyzeRequest    空间图片标签分析请求封装类
     * @param loginUser                 当前登录用户
     * @return  空间图片标签分析响应封装类
     */
    List<SpaceTagAnalyzeResponse> getSpaceTagAnalyze(SpaceTagAnalyzeRequest spaceTagAnalyzeRequest, User loginUser);
    /**
     * 获取空间图片大小分析
     *
     * @param spaceSizeAnalyzeRequest   空间图片大小分析请求封装类
     * @param loginUser                 当前登录用户
     * @return  空间图片大小分析响应封装类
     */
    List<SpaceSizeAnalyzeResponse> getSpaceSizeAnalyze(SpaceSizeAnalyzeRequest spaceSizeAnalyzeRequest, User loginUser);
    /**
     * 获取空间用户上传行为分析
     *
     * @param spaceUserAnalyzeRequest   空间用户上传行为分析请求封装类
     * @param loginUser                 当前登录用户
     * @return  空间用户上传行为分析响应封装类
     */
    List<SpaceUserAnalyzeResponse> getSpaceUserAnalyze(SpaceUserAnalyzeRequest spaceUserAnalyzeRequest, User loginUser);
    /**
     * 空间使用排行分析（仅管理员）
     *
     * @param spaceRankAnalyzeRequest   空间使用排行分析请求封装类
     * @param loginUser                 当前登录用户
     * @return  空间使用排行分析响应封装类
     */
    List<Space> getSpaceRankAnalyze(SpaceRankAnalyzeRequest spaceRankAnalyzeRequest, User loginUser);
}