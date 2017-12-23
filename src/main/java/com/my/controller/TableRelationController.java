package com.my.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
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
	
	// 增加
	 @RequestMapping(value = "/save")
	    public Long save(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.save(record);
	    }
	// 查询
	 @RequestMapping(value = "/query")
	    public JSONObject query(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.getPet(record);
	    }
	 // 删除
	 @RequestMapping(value = "/delete")
	    public Long delete(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.delete(record);
	    }
	 
	 // 更改
	 @RequestMapping(value = "/update")
	    public Long update(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.update(record);
	    }
}
