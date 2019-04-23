package com.example.products.mapper;

import java.util.List;

import com.example.products.domain.Product;
import com.example.products.domain.dto.ProductDTO;

@org.mapstruct.Mapper(componentModel = "spring")
public interface ProductMapper {

	ProductDTO ProductToProductDTO(Product entity);
	Product ProductDTOtoProduct(ProductDTO dto);
	List<Product> productsDTOToProducts(List<ProductDTO> list);
	List<ProductDTO> productsToProductsDTO(List<Product> list);
	
}
