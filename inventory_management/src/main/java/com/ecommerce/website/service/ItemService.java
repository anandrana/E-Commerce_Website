package com.ecommerce.website.service;

import com.ecommerce.website.dto.ItemDTO;
import com.ecommerce.website.dto.ResponseDTO;

public interface ItemService {

	public ResponseDTO addItem(ItemDTO itemDTO);

	public ResponseDTO updateItem(Long id, ItemDTO itemDTO);

	public ResponseDTO viewItems();

	public ResponseDTO findBySubCategory(String subCategory);

    public ResponseDTO findByMobile(String mobile);

}
