package com.my.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.my.model.GoodInfoEntity;
import com.my.model.Husband;
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
	// 单向一对一
	// 增加
	 @RequestMapping(value = "/singleOne/save")
	    public Long save(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.save(record);
	    }
	// 查询
	 @RequestMapping(value = "/singleOne/query")
	    public JSONObject query(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.getPet(record);
	    }
	 // 删除
	 @RequestMapping(value = "/singleOne/delete")
	    public Long delete(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.delete(record);
	    }
	 
	 // 更改
	 @RequestMapping(value = "/singleOne/update")
	    public Long update(@RequestBody JSONObject record) throws Exception
	    {
	        return tableRelationService.update(record);
	    }
	 
	 // 双向一对一
	// 增加
		 @RequestMapping(value = "/doubelOne/save")
		    public Object twoSave(@RequestBody JSONObject record) throws Exception
		    {
		        return tableRelationService.twoSave(record);
		    }
		// 查询
		 @RequestMapping(value = "/doubelOne/query")
		    public JSONObject twoQuery(@RequestBody JSONObject record) throws Exception
		    {
		        return tableRelationService.twoGet(record);
		    }
		 // 删除
		 @RequestMapping(value = "/doubelOne/delete")
		    public Long twoDelete(@RequestBody JSONObject record) throws Exception
		    {
		        return tableRelationService.twoDelete(record);
		    }
		 
		 // 更改
		 @RequestMapping(value = "/doubelOne/update")
		    public Long twoUpdate(@RequestBody JSONObject record) throws Exception
		    {
		        return tableRelationService.twoUpdate(record);
		    }
}
