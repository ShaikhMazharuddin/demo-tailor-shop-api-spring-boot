/**
 * 
 */
package com.mazzee.dts.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mazzee.dts.dto.ApiError;
import com.mazzee.dts.entity.DressType;
import com.mazzee.dts.exception.RecordNotFoundException;
import com.mazzee.dts.service.DressTypeService;
import com.mazzee.dts.utils.DtsUtils;

/**
 * Class define all API related to dress types
 * 
 * @author mazhar
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("api/dressType/")
public class DressTypeController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DressTypeController.class);
	private DressTypeService dressTypeService;

	@Autowired
	public void setDressTypeService(DressTypeService dressTypeService) {
		this.dressTypeService = dressTypeService;
	}

	@GetMapping(value = "v1/allDressTypes")
	public ResponseEntity<List<DressType>> getDressType() throws RecordNotFoundException {
		LOGGER.info("Get all dress types");
		ResponseEntity<List<DressType>> responseEntity = null;
		final List<DressType> dressTypeList = dressTypeService.getAllDressTypes();
		if (!DtsUtils.isNullOrEmpty(dressTypeList)) {
			LOGGER.info("Get all dress types count {}", dressTypeList.size());
			responseEntity = ResponseEntity.ok().body(dressTypeList);
		} else {
			ApiError apiError = new ApiError(HttpStatus.NO_CONTENT.value(), "Dress type not found ");
			throw new RecordNotFoundException(apiError);
		}
		return responseEntity;
	}

}
