/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.example.demo.controller;

import com.example.demo.entity.Notice;
import com.example.demo.service.IDynamicService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import com.sailmi.core.tool.api.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 多数据源
 *
 * @author Chill
 */
@RestController
@AllArgsConstructor
@RequestMapping("dynamic")
@Api(value = "多数据源接口", tags = "多数据源")
public class DynamicController {

	private IDynamicService dynamicService;

	/**
	 * master列表
	 */
	@GetMapping("/master-list")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "master列表", notes = "master列表")
	public R<List<Notice>> masterList() {
		List<Notice> list = dynamicService.masterList();
		return R.data(list);
	}

	/**
	 * slave列表
	 */
	@GetMapping("/slave-list")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "slave列表", notes = "slave列表")
	public R<List<Notice>> slaveList() {
		List<Notice> list = dynamicService.slaveList();
		return R.data(list);
	}

}
