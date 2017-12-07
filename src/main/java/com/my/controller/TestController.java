package com.my.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.my.model.GoodInfoEntity;
import com.my.myinterface.GoodInfoJPA;

@RestController
public class TestController {
	//商品基本信息数据接口
    @Autowired
    private GoodInfoJPA goodInfoJPA;

    /**
     * 查询首页内容
     * @return
     */
    @RequestMapping(value = "/index")
    public String index(String name)
    {
        return "this is index page" + name;
    }

    /**
     * 查询全部商品
     * @return
     */
    @RequestMapping(value = "/all")
    public List<GoodInfoEntity> selectAll()
    {
        return goodInfoJPA.findAll();
    }

    /**
     * 查询商品详情
     * @param goodId
     * @return
     */
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public GoodInfoEntity selectOne(Integer goodId)
    {
        return goodInfoJPA.findOne(goodId);
    }
}
