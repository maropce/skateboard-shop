package pl.maropce.skateboardshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maropce.skateboardshop.product.Product;
import pl.maropce.skateboardshop.product.ProductService;
import pl.maropce.skateboardshop.product.dto.ProductPostDto;
import pl.maropce.skateboardshop.product.dto.ProductPutDto;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/shop/skateboards")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping()
    public List<Product> getProducts(
            @RequestParam (required = false) String company
    ) {
        if (company == null) return service.findAll();

        return service.findByCompanyContainsIgnoreCase(company);
    }

    @PostMapping()
    public ResponseEntity<Void> addProduct(
            @RequestBody ProductPostDto productPostDto
    ) {
        final Integer id = service.create(productPostDto);
        return ResponseEntity.created(URI.create("/api/v1/shop/skateboards/" + id)).build();
    }

    @PutMapping("/{id}")
    public void updateProduct(
            @PathVariable Integer id,
            @RequestBody ProductPutDto productPutDto
    ) {
        productPutDto.setId(id);
        service.update(productPutDto);
    }

    @DeleteMapping("/{id}")
    public void removeProduct(
            @PathVariable Integer id
    ) {
        service.delete(id);
    }

}
