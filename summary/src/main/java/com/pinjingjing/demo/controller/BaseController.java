package com.pinjingjing.demo.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller基础类
 * @author Administrator
 *
 */
public class BaseController {

    public BaseController() {
    	
    }
    
    /**
     * 返回公共操作结果
     * @return
     */
    public Map<String, Object> getResultMap(){
    	Map<String, Object> resp = new HashMap<String, Object>();
    	resp.put("code", 0);
    	resp.put("msg", "操作成功");
    	return resp;
    }
    
}
