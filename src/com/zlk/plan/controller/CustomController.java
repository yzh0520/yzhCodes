package com.zlk.plan.controller;

import com.zlk.plan.entity.Custom;
import com.zlk.plan.entity.Pagination;
import com.zlk.plan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName：
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/16 13:58
 */
@Controller
@RequestMapping("/custom")
public class CustomController {
    @Autowired
    private CustomService customService;

    @RequestMapping("/main")
    public ModelAndView showMain()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("main");
        return mv;
    }

    @RequestMapping("/toList")
    public ModelAndView showList()throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("custom");
        return mv;
    }

    @RequestMapping(value="/list")
    @ResponseBody
    public Map<String, Object> list(Pagination pagination)throws Exception{
        List<Custom> list = customService.findUserLimit(pagination);
        Integer count = customService.findUserCount(pagination);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    //通过ID删除用户
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Integer cid) throws Exception{
        Integer flag = customService.deleteUserById(cid);
        if(flag == 1){
            return "删除成功";
        }else{
            return  "删除失败";
        }
    }

    //新增用户
    @RequestMapping(value = "/addCustom")
    @ResponseBody
    public ModelAndView add(Custom custom)throws Exception{
        ModelAndView mv = new ModelAndView();
        Integer flag = customService.addCustom(custom);
        if(flag == 1){
            mv.setViewName("custom");
            return mv;
        }else {
            return null;
        }
    }
    //编辑用户
    @RequestMapping(value = "/editCustom")
    public String edit(Custom custom)throws Exception{
        Integer flag = customService.editCustomById(custom);
        if(flag == 1){
            return "redirect:/custom/toList";
        }else {
            return null;
        }
    }
}
