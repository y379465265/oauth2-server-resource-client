package com.izejin.security;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.izejin.entity.SysUser;
import com.izejin.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import java.util.List;

/**
 * 描述： 加载用户密码, 用于认证
 * <p>
 *
 * @author wangyue
 * @since 2020/7/7 17:06
 */
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ISysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user =  new SysUser();
        user.setLoginName(username);
        Wrapper<SysUser> sysUserWrapper = new QueryWrapper<>(user);
        SysUser sysUser = sysUserService.getOne(sysUserWrapper);
        if (sysUser == null) {
            throw new UsernameNotFoundException("用户不存在！");
        }
        return User.builder()
                .username(sysUser.getLoginName())
                .password(sysUser.getLoginPassword())
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .roles("USER")
                .build();
    }

}
