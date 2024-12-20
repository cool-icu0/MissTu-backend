package com.cool.tu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cool.tu.model.dto.space.SpaceAddRequest;
import com.cool.tu.model.dto.space.SpaceQueryRequest;
import com.cool.tu.model.entity.Space;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.entity.User;
import com.cool.tu.model.vo.space.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Cool
 * @description 针对表【space(空间)】的数据库操作Service
 * @createDate 2024-12-20 15:41:49
 */
public interface SpaceService extends IService<Space> {
    /**
     * 创建空间
     *
     * @param spaceAddRequest 创建请求
     * @param loginUser       登录用户
     * @return
     */
    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);
    /**
     * 校验空间
     *
     * @param space 空间
     * @param add   是否为创建时检验
     */
    void validSpace(Space space, boolean add);
    /**
     * 获取空间包装类（单条）
     *
     * @param space   空间
     * @param request 请求
     * @return
     */
    SpaceVO getSpaceVO(Space space, HttpServletRequest request);
    /**
     * 获取空间包装类（分页）
     *
     * @param spacePage 空间分页
     * @param request   请求
     * @return
     */
    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);
    /**
     * 获取查询对象
     *
     * @param spaceQueryRequest 查询请求
     * @return 查询对象
     */
    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);
    /**
     * 根据空间级别填充空间对象
     *
     * @param space 空间
     */
    void fillSpaceBySpaceLevel(Space space);
}
