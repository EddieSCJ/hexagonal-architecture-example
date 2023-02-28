package domain

import (
	"hexagonal-architecture-example/product/domain/entity"
	"testing"
)

func TestNewProduct(t *testing.T) {
	product := NewProduct("fake-id", "fake-name", 10.0)

	if product.GetId() != "fake-id" {
		t.Errorf("expected fake-id, got %s", product.GetId())
	}

	if product.GetName() != "fake-name" {
		t.Errorf("expected fake-name, got %s", product.GetName())
	}

	if product.GetPrice() != 10.0 {
		t.Errorf("expected 10.0, got %f", product.GetPrice())
	}

	if product.GetStatus() != entity.DISABLED {
		t.Errorf("expected disabled, got %s", product.GetStatus())
	}
}
