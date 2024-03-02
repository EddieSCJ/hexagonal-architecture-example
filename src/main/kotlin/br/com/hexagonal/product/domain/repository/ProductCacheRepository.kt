package br.com.hexagonal.product.domain.repository

import br.com.hexagonal._shared.repository.ICacheRepository
import br.com.hexagonal.product.domain.entity.Product

interface ProductCacheRepository : ICacheRepository<String, Product>{
}