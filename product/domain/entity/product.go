package entity

import (
	"errors"
)

const (
	DISABLED = "disabled"
	ENABLED  = "enabled"
)

type ProductInterface interface {
	IsValid() (bool, error)
	Enable() error
	Disable() error
	GetId() string
	GetName() string
	GetStatus() string
	GetPrice() float64
}

type Product struct {
	Id     string
	Name   string
	Status string
	Price  float64
}

func (p *Product) IsValid() (bool, error) {
	if p.Name == "" {
		return false, errors.New("invalid name, cant be empty")
	}

	if p.Price <= 0 {
		return false, errors.New("invalid price, cant be less than or equal to zero")
	}

	return true, nil
}

func (p *Product) Enable() error {
	if p.Status == ENABLED {
		return errors.New("product already enabled")
	}

	if isValid, err := p.IsValid(); !isValid {
		return err
	}

	p.Status = ENABLED
	return nil
}

func (p *Product) Disable() error {
	if p.Status == DISABLED {
		return errors.New("product already disabled")
	}

	p.Status = DISABLED
	return nil
}

func (p *Product) GetId() string {
	return p.Id
}

func (p *Product) GetName() string {
	return p.Name
}

func (p *Product) GetStatus() string {
	return p.Status
}

func (p *Product) GetPrice() float64 {
	return p.Price
}
