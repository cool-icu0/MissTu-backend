package com.cool.tu.manager.auth.config;

import com.cool.tu.manager.auth.model.entity.SpaceUserPermission;
import com.cool.tu.manager.auth.model.entity.SpaceUserRole;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SpaceUserAuthConfig implements Serializable {
  
    /**  
     * 权限列表  
     */  
    private List<SpaceUserPermission> permissions;
  
    /**  
     * 角色列表  
     */  
    private List<SpaceUserRole> roles;
  
    private static final long serialVersionUID = 1L;  
}