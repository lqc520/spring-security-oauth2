package cn.lqcnb.oauth2.server.service;

import cn.lqcnb.oauth2.server.domain.TbUser;

public interface TbUserService{

    public TbUser getByUserName(String username);
}
