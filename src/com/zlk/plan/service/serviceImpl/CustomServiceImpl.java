package com.zlk.plan.service.serviceImpl;

import com.zlk.plan.entity.Custom;
import com.zlk.plan.entity.Pagination;
import com.zlk.plan.mapper.CustomMapper;
import com.zlk.plan.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomServiceImpl implements CustomService {
    @Autowired
    private CustomMapper customMapper;
    @Override
    public List<Custom> findUserLimit(Pagination pagination) {
        Integer page = pagination.getPage();
        Integer limit = pagination.getLimit();
        Integer startPage = (page-1)*limit;
        pagination.setStartPage(startPage);
        return customMapper.findUserList(pagination);
    }
    @Override
    public Integer findUserCount(Pagination pagination) {
        return customMapper.findUserCount(pagination);
    }
    @Override
    public Integer deleteUserById(Integer cid){

        return customMapper.deleteUserById(cid);
    }
    @Override
    public Integer addCustom(Custom custom){
        return customMapper.addCustom(custom);
    }
    @Override
    public Integer editCustomById(Custom custom){
        return customMapper.editCustomById(custom);
    }
}