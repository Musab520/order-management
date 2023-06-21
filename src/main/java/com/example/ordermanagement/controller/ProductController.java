package com.example.ordermanagement.controller;

import com.example.ordermanagement.dto.Product.ProductInsertDto;
import com.example.ordermanagement.dto.Product.ProductUpdateDto;
import com.example.ordermanagement.service.ProductService;
import com.example.ordermanagement.dto.Product.ProductDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@Api(tags = "Product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("{id}")
    //@ApiOperation("Get a product by ID")
    public ResponseEntity<ProductDto> getProduct(
            @PathVariable long id
    ) {
        ProductDto productDto = productService.getById(id);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else {
            return ResponseEntity.badRequest().body(new ProductDto());
        }
    }

    @PostMapping
    //@ApiOperation("Insert a new product")
    public ResponseEntity<ProductDto> insertProduct(
            @RequestBody @Valid ProductInsertDto productInsertDto
    ) {
        ProductDto productDto = productService.insert(productInsertDto);
        return ResponseEntity.ok(productDto);
    }

    @PutMapping("{id}")
    //@ApiOperation("Update an existing product")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable long id,
            @RequestBody @Valid ProductUpdateDto productUpdateDto
    ) {
        ProductDto productDto = productService.update(id, productUpdateDto);
        if (productDto != null) {
            return ResponseEntity.ok(productDto);
        } else {
            return ResponseEntity.badRequest().body(new ProductDto());
        }
    }

    @DeleteMapping("{id}")
    //@ApiOperation("Delete a product by ID")
    public ResponseEntity<String> deleteProduct(
            @PathVariable long id
    ) {
        boolean success = productService.delete(id);
        if (success) {
            return ResponseEntity.ok("Deleted Product Successfully");
        } else {
            return ResponseEntity.badRequest().body("Error Occurred with Deletion");
        }
    }
}
