package com.zlk.user.controller;

import com.zlk.user.entity.Pagination;
import com.zlk.user.entity.User;
import com.zlk.user.service.UserService;
import com.zlk.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName： UserController
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/24 9:18
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "login";
    }

    @RequestMapping("/nopermission")//跳转无权限访问页面
    public String showNopermission()throws Exception{
        return "nopermission";
    }

    @RequestMapping("/toLogin")//首页跳转
    public String toLogin() throws Exception{
        return "login";
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, User user, String code) {
        Subject subject = SecurityUtils.getSubject();
        if (code == null) {
            String md5Pwd = MD5Utils.md5Encrypt32Lower(user.getPwd());
            UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), md5Pwd);
            try {
                subject.login(token);
            } catch (IncorrectCredentialsException ice) {
                // 捕获密码错误异常
                ModelAndView mv = new ModelAndView("login");
                mv.addObject("wrong", "密码不正确");
                mv.addObject("msg", "true");
                return mv;
            } catch (UnknownAccountException uae) {
                // 捕获用户名错误异常
                ModelAndView mv = new ModelAndView("login");
                mv.addObject("wrong", "用户名不正确");
                mv.addObject("msg", "true");
                return mv;
            }
            ModelAndView mv = new ModelAndView();
            User user1 = userService.findUserByNameAndPwd(user);
            subject.getSession().setAttribute("user", user1);
            mv.addObject("username",user.getName());
            mv.setViewName("main");
            return mv;
        }else{
            String checkCode = (String) request.getSession().getAttribute("checkCode");
            if (code.toLowerCase().equals(checkCode.toLowerCase())){
                String md5Pwd = MD5Utils.md5Encrypt32Lower(user.getPwd());
                UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), md5Pwd);
                try {
                    subject.login(token);
                } catch (IncorrectCredentialsException ice) {
                    // 捕获密码错误异常
                    ModelAndView mv = new ModelAndView("login");
                    mv.addObject("wrong", "密码不正确");
                    mv.addObject("msg", "true");
                    return mv;
                } catch (UnknownAccountException uae) {
                    // 捕获用户名错误异常
                    ModelAndView mv = new ModelAndView("login");
                    mv.addObject("wrong", "用户名不正确");
                    mv.addObject("msg", "true");
                    return mv;
                }
                ModelAndView mv = new ModelAndView();
                User user1 = userService.findUserByNameAndPwd(user);
                subject.getSession().setAttribute("user", user1);
                mv.addObject("username",user.getName());
                mv.setViewName("main");
                return mv;
            }else {
                ModelAndView mv = new ModelAndView("login");
                mv.addObject("wrong", "验证码错误");
                mv.addObject("msg", "true");
                return mv;
            }
        }
    }

    @RequestMapping("/toList")
    public ModelAndView showList()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("userrolefun");
        return mv;
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public Map<String, Object> list(Pagination pagination)throws Exception{
        List<User> list = userService.findUserAll(pagination);
        Integer count = userService.findUserCount(pagination);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    //新增用户
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public ModelAndView addUser(User user)throws Exception{
        ModelAndView mv = new ModelAndView();
        user.setCreatetime(new Date());
        user.setPwd(MD5Utils.md5Encrypt32Lower(user.getPwd()));
        Integer flag = userService.addUser(user);
        if(flag == 1){
            mv.setViewName("userrolefun");
            return mv;
        }else {
            return null;
        }
    }

    //通过ID删除用户
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Integer uid) throws Exception{
        Integer flag = userService.deleteUserById(uid);
        if(flag == 1){
            return "删除成功";
        }else{
            return  "删除失败";
        }
    }

    //编辑用户
    @RequestMapping(value = "/editUser")
    public String edit(User user)throws Exception{
        user.setUpdatetime(new Date());
        Integer flag = userService.editUserById(user);
        if(flag == 1){
            return "redirect:/user/toList";
        }else {
            return null;
        }
    }
}

