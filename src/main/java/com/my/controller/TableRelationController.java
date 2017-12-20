package com.my.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.my.model.GoodInfoEntity;
import com.my.service.TableRelationService;

/**
 * 用于测试表的七种对应关系
 * @author by_ww
 *
 */
@RestController
@RequestMapping(value = "/tableRelation")
public class TableRelationController {
	
	@Resource
	private TableRelationService tableRelationService;
	
	 @RequestMapping(value = "/save")
	    public Long save(JSONObject record) throws Exception
	    {
	        return tableRelationService.save(record);
	    }
	

}
