package br.com.hexagonal.product.adapters.exposal

import br.com.hexagonal.product.adapters.databases.dto.ProductDTO
import br.com.hexagonal.product.domain.entity.Product
import br.com.hexagonal.product.domain.service.IProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
class RestAdapter(val service: IProductService) {

    @PostMapping("/create")
    fun createProduct(@RequestBody product: ProductDTO): ResponseEntity<ProductDTO> {
        val result = ProductDTO.fromDomain(service.createProduct(product.toDomain()))
        return ResponseEntity.created(URI.create("/product/${result.id}")).body(result)
    }

    @PutMapping("/update/{id}")
    fun updateProduct(@RequestBody product: ProductDTO, @PathVariable id: String): ResponseEntity<ProductDTO> {
        val result = ProductDTO.fromDomain(service.updateProduct(product.toDomain().copy(id = id)))
        return ResponseEntity.ok(result)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteProduct(@PathVariable id: String): ResponseEntity<Unit> {
        service.deleteProduct(id)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id: String): ResponseEntity<ProductDTO> {
        val product: Product? = service.getProduct(id)
        product?.let { return ResponseEntity.ok(ProductDTO.fromDomain(it)) } ?: return ResponseEntity.notFound().build()
    }

    @GetMapping("/")
    fun getProducts(): ResponseEntity<List<ProductDTO>> {
        val products = service.getProducts()
        return ResponseEntity.ok(products.map { ProductDTO.fromDomain(it) })
    }
}