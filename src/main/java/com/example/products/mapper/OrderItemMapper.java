package com.example.products.mapper;

import com.example.products.domain.OrderItem;
import com.example.products.domain.dto.OrderItemDTO;

@org.mapstruct.Mapper(componentModel = "spring")
public interface OrderItemMapper {

	OrderItemDTO OrderItemToOrderItemDTO(OrderItem entity);
	OrderItem OrderItemDTOtoOrderItem(OrderItemDTO dto);
	
}
