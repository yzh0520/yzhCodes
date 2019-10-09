package com.zlk.plan.controller;

import com.zlk.plan.entity.Orders;
import com.zlk.plan.entity.Pagination;
import com.zlk.plan.service.OrdersService;
import com.zlk.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName： OrdersController
 * @Description：
 * @Author： yzh
 * @Date： 2019/9/19 16:28
 */
@Controller
@RequestMapping(value = "/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @RequestMapping(value = "/toList")
    public String toList()throws Exception{
        return "orders";
    }

    @RequestMapping(value = "/ordersList")
    @ResponseBody
    public Map<String, Object> list(Pagination pagination)throws Exception{
        List<Orders> list = ordersService.findOrdersList(pagination);
        Integer count = ordersService.findOrdersCount(pagination);
        Map<String, Object> map = new HashMap<>();
        map.put("code", "0");
        map.put("count", count);
        map.put("data", list);
        return map;
    }

    //通过ID删除订单
    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(Integer oid) throws Exception{
        Integer flag = ordersService.deleteOrdersById(oid);
        if(flag == 1){
            return "删除成功";
        }else{
            return  "删除失败";
        }
    }
    @RequestMapping(value = "/ordersInsert")
    public String ordersInsert(Orders orders,String ocreatetime,String ofinishtime) throws  Exception{
        orders.setOcreatetime(DateUtils.stringToDate(ocreatetime));
        orders.setOfinishtime(DateUtils.stringToDate(ofinishtime));
        Integer flag = ordersService.addOrders(orders);
        if(flag == 1){
            return "redirect:/orders/toList";
        }else {
            return null;
        }
    }

    @RequestMapping("/editOrders")
    public String editOrders(Orders orders,String ocreatetime,String ofinishtime)throws Exception{
        orders.setOcreatetime(DateUtils.stringToDate(ocreatetime));
        orders.setOfinishtime(DateUtils.stringToDate(ofinishtime));
        Integer flag = ordersService.editOrdersById(orders);
        if(flag == 1){
            return "redirect:/orders/toList";
        }else {
            return null;
        }
    }



    @RequestMapping(value = "uploadImg")
    @ResponseBody
    public Map uploadImg(@RequestParam(value = "file",required = false) MultipartFile file){
        Map map=new HashMap();
        String filePath="";
        String virtualFilePath="";
        if(file !=null){
            String originalName=file.getOriginalFilename();
            String lastStr=originalName.substring(originalName.lastIndexOf(".")+1);
            String dateStr=String.valueOf(new Date().getTime());

            String imgName=dateStr+"."+lastStr;
            filePath="D:\\upload\\"+imgName;
            virtualFilePath="/upload/"+imgName;

            File files=new File(filePath);
            try {
                file.transferTo(files);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        map.put("code",1);
        map.put("abspath",filePath);
        map.put("virtualPath", virtualFilePath);
        return map;
    }
}
