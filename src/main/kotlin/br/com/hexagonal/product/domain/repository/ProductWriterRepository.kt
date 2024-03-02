package br.com.hexagonal.product.domain.repository

import br.com.hexagonal._shared.repository.IDBWriter
import br.com.hexagonal.product.domain.entity.Product

interface ProductWriterRepository : IDBWriter<String, Product>