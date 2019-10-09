package com.zlk.shiro;

import com.zlk.user.entity.User;
import com.zlk.user.entity.UserFunction;
import com.zlk.user.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName： securityRealm
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 10:12
 */

public class securityRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;


    //根据数据库权限授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pc) {
        String username = (String)pc.getPrimaryPrincipal();
        List<UserFunction> list = userService.findFunByName(username);
        Set<String> roles = new HashSet<>();
        for (UserFunction uf:list) {
            roles.add(uf.getFunname());
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roles);

        return authorizationInfo;
    }

    //权限认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken myToken = (UsernamePasswordToken)token;
        String loginName = myToken.getUsername();
        User user = userService.findUserByName(loginName);
        if(user == null){
            return null;
        }
        SecurityUtils.getSubject().getSession().setTimeout(600000L);
        AuthenticationInfo info = new SimpleAuthenticationInfo(loginName, user.getPwd(), this.getName());
        return info;
    }
}
