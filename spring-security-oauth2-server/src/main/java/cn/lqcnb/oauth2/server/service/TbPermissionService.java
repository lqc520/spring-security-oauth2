package cn.lqcnb.oauth2.server.service;

import cn.lqcnb.oauth2.server.domain.TbPermission;

import java.util.List;

public interface TbPermissionService{

    List<TbPermission> selectByUserId(Long userId);
}
