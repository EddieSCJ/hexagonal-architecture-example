package entity

import (
	"testing"
)

var enabledProduct ProductInterface = &Product{
	Id:     "fake-id",
	Name:   "fake-name",
	Status: ENABLED,
	Price:  10.0,
}

var disabledProduct ProductInterface = &Product{
	Id:     "fake-id",
	Name:   "fake-name",
	Status: DISABLED,
	Price:  10.0,
}

func TestProductIsValid(t *testing.T) {
	testTable := []struct {
		name          string
		product       ProductInterface
		expected      bool
		expectedError bool
	}{
		{
			name:          "valid product",
			product:       enabledProduct,
			expected:      true,
			expectedError: false,
		},
		{
			name: "invalid product",
			product: &Product{
				Id:     "fake-id",
				Name:   "",
				Status: ENABLED,
				Price:  10.0,
			},
			expected:      false,
			expectedError: true,
		},
	}

	for _, testCase := range testTable {
		t.Run(testCase.name, func(t *testing.T) {
			valid, err := testCase.product.IsValid()

			if valid != testCase.expected {
				t.Errorf("expected %t, got %t", testCase.expected, valid)
			}

			if testCase.expectedError && err == nil {
				t.Errorf("expected error, got nil")
			}

			if !testCase.expectedError && err != nil {
				t.Errorf("expected nil, got error")
			}
		})
	}
}

func TestProductEnable(t *testing.T) {
	product := *disabledProduct.(*Product)

	product.Enable()

	if product.GetStatus() != ENABLED {
		t.Errorf("expected status to be %s, got %s", ENABLED, product.GetStatus())
	}
}

func TestProductEnableError(t *testing.T) {
	product := *enabledProduct.(*Product)
	err := product.Enable()

	if err == nil {
		t.Errorf("expected error, got nil")
	}
}

func TestProductDisable(t *testing.T) {
	product := *enabledProduct.(*Product)
	product.Disable()

	if product.GetStatus() != DISABLED {
		t.Errorf("expected status to be %s, got %s", DISABLED, product.GetStatus())
	}
}

func TestProductDisableError(t *testing.T) {
	product := *disabledProduct.(*Product)
	err := product.Disable()

	if err == nil {
		t.Errorf("expected error, got nil")
	}
}
