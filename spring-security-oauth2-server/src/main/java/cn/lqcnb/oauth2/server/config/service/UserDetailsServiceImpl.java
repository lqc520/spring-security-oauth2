package cn.lqcnb.oauth2.server.config.service;

import cn.lqcnb.oauth2.server.domain.TbPermission;
import cn.lqcnb.oauth2.server.domain.TbUser;
import cn.lqcnb.oauth2.server.service.TbPermissionService;
import cn.lqcnb.oauth2.server.service.TbUserService;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService userService;

    @Autowired
    private TbPermissionService permissionService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser user = userService.getByUserName(username);
        ArrayList<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if(user != null){
            List<TbPermission> permissions = permissionService.selectByUserId(user.getId());
            permissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(grantedAuthority);
            });
        }
        return new User(user.getUsername(),user.getPassword(),grantedAuthorities);
    }
}
