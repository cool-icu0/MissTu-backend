package com.cool.tu.service;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cool.tu.model.dto.user.UserQueryRequest;
import com.cool.tu.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cool.tu.model.vo.user.LoginUserVO;
import com.cool.tu.model.vo.user.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Cool
 * @description 针对表【user(用户)】的数据库操作Service
 * @createDate 2024-12-14 22:29:03
 */
public interface UserService extends IService<User> {

    /**
     * 获取当前登录用户
     *
     * @param request http请求
     * @return 脱敏后的用户信息
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 获取脱敏的已登录用户信息
     *
     * @param user 用户
     * @return 脱敏后的用户信息
     */
    LoginUserVO getLoginUserVO(User user);


    /**
     * 用户登录
     *
     * @param userAccount  用户账户
     * @param userPassword 用户密码
     * @param request      请求
     * @return 脱敏后的用户信息
     */
    LoginUserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);


    /**
     * 用户注册
     *
     * @param userAccount   用户账户
     * @param userPassword  用户密码
     * @param checkPassword 校验密码
     * @return 新用户 id
     */
    long userRegister(String userAccount, String userPassword, String checkPassword);


    /**
     * 用户注销
     *
     * @param request 请求
     * @return 是否成功
     */
    boolean userLogout(HttpServletRequest request);

    /**
     * 加密密码
     *
     * @param userPassword 用户密码
     * @return 加密后的密码
     */
    String getEncryptPassword(String userPassword);

    /**
     * 获取脱敏的用户信息
     *
     * @param user 用户
     * @return 脱敏后的用户信息
     */
    UserVO getUserVO(User user);

    /**
     * 获取脱敏的用户信息列表
     *
     * @param userList 用户列表
     * @return 脱敏后的用户信息列表
     */
    List<UserVO> getUserVOList(List<User> userList);

    /**
     * 获取查询条件
     *
     * @param userQueryRequest 查询请求
     * @return 查询条件
     */
    QueryWrapper<User> getQueryWrapper(UserQueryRequest userQueryRequest);
}
