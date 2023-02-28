package domain

import "hexagonal-architecture-example/product/domain/entity"

func NewProduct(id string, name string, price float64) entity.ProductInterface {
	return &entity.Product{
		Id:     id,
		Name:   name,
		Status: entity.DISABLED,
		Price:  price,
	}
}
