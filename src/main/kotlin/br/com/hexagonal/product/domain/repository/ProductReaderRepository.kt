package br.com.hexagonal.product.domain.repository

import br.com.hexagonal._shared.repository.IDBReader
import br.com.hexagonal.product.domain.entity.Product

interface ProductReaderRepository : IDBReader<String, Product>