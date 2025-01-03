package com.cool.tu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cool.tu.model.dto.spaceuser.SpaceUserAddRequest;
import com.cool.tu.model.dto.spaceuser.SpaceUserQueryRequest;
import com.cool.tu.model.entity.SpaceUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.vo.spaceuser.SpaceUserVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author Cool
* @description 针对表【space_user(空间用户关联)】的数据库操作Service
* @createDate 2025-01-03 14:16:41
*/
public interface SpaceUserService extends IService<SpaceUser> {

    void validSpaceUser(SpaceUser spaceUser, boolean add);

    long addSpaceUser(SpaceUserAddRequest spaceUserAddRequest);

    QueryWrapper<SpaceUser> getQueryWrapper(SpaceUserQueryRequest spaceUserQueryRequest);

    SpaceUserVO getSpaceUserVO(SpaceUser spaceUser, HttpServletRequest request);

    List<SpaceUserVO> getSpaceUserVOList(List<SpaceUser> spaceUserList);
}
