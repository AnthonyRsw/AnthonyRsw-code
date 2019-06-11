package com.pinjingjing.demo.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pinjingjing.demo.service.impl.BaseDataServiceImpl;
import com.pinjingjing.demo.util.StringUtil;

@Transactional
@Controller
@RequestMapping("/baseData")
public class BaseDataController extends BaseController {

	@Autowired
	private BaseDataServiceImpl baseDataService;

	/**
	 * 基础信息维护
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/baseDataManage")
	public String baseDataManage(HttpServletRequest request) {
		return "baseData/baseDataManage";
	}

	/**
	 * 跳转基础信息维护
	 * 
	 * @param tableName
	 * @return
	 */
	@RequestMapping("/basicTableName")
	public ModelAndView basicTableName(String tableName) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("tableName", tableName);
		if (tableName.equals("user_area")) {
			mv.setViewName("/baseData/userAreaPage");
		}else {
			mv.setViewName("/baseData/basicTablePage");
		}
		return mv;
	}

	/**
	 * 查询所有基本信息
	 * 
	 * @param request
	 * @param name
	 *            名称
	 * @param tableName
	 *            表名称
	 * @param page
	 * @param limit
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@ResponseBody
	@RequestMapping("/getAllTableList")
	public Map<String, Object> getAllTableList(HttpServletRequest request, String createTime, String tableName,
			@RequestParam(value = "page", required = false, defaultValue = "1") int page,
			@RequestParam(value = "limit", required = false, defaultValue = "10") int limit) throws UnsupportedEncodingException {
			Map<String, Object> resp = getResultMap();
			Map<String, Object> param = new HashMap<String, Object>();
			if (StringUtil.isNotNullAndEmpty(createTime)) {
				String startTime = createTime.substring(0, 10);
				String endTime = createTime.substring(13, createTime.length());
				param.put("startTime", startTime);
				param.put("endTime", endTime);
			}
			param.put("tableName", tableName);
			Integer count = baseDataService.findAllCount(param);
			if (count > 0) {
				resp.put("count", count);
				param.put("pageParam", StringUtil.getPageParam(page, limit));
				// 查询当前页数据
				List<Map<String, Object>> basicDataList = baseDataService.findAll(param);
				resp.put("data", basicDataList);
			}

		return resp;
	}

}
