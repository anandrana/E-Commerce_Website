package com.ecommerce.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.website.constant.ApiConstant;
import com.ecommerce.website.dto.ItemDTO;
import com.ecommerce.website.dto.ResponseDTO;
import com.ecommerce.website.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(ApiConstant.API_VERSIONING)
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@PostMapping(ApiConstant.ADD_ITEM)
	public ResponseDTO addItem(@RequestBody ItemDTO itemDTO) {
		ResponseDTO responseDTO=itemService.addItem(itemDTO);
		return responseDTO;
	}
	
	@PostMapping(ApiConstant.UPDATE_ITEM + ApiConstant.PATH_VARIABLE_ID)
	public ResponseDTO updateItem(@PathVariable Long id , @RequestBody  ItemDTO itemDTO ) {
		ResponseDTO responseDTO = itemService.updateItem(id,itemDTO);
		return responseDTO;
	}
	
	@PostMapping(ApiConstant.VIEW_ITEMS)
	public ResponseDTO viewItem() {
		ResponseDTO responseDTO = itemService.viewItems();
		return responseDTO;
	}
	
	@PostMapping(ApiConstant.VIEW_ITEMS + ApiConstant.PATH_VARIABLE_SUBCATEGORY)
	public ResponseDTO findBySubCategory(@PathVariable String subCategory) {
		ResponseDTO responseDTO = itemService.findBySubCategory(subCategory);
		log.info("the responseDTO value : {}",responseDTO);
		return responseDTO;
	}

	@PostMapping(ApiConstant.VIEW_ITEMS + ApiConstant.MOBILE+ApiConstant.PATH_VARIABLE_MOBILE)
	public ResponseDTO findByMobile(@PathVariable String mobile){
		ResponseDTO responseDTO = itemService.findByMobile(mobile);
		log.info("the responseDTO value : {}",responseDTO);
		return responseDTO;
	}
}
