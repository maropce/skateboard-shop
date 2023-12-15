package pl.maropce.skateboardshop.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.maropce.skateboardshop.product.dto.ProductPostDto;
import pl.maropce.skateboardshop.product.dto.ProductPutDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public Integer create(ProductPostDto productPostDto) {
        final var skateboard = Product.builder()
                .company(productPostDto.getCompany())
                .deckWide(productPostDto.getDeckWide())
                .wheels(productPostDto.getWheels())
                .price(productPostDto.getPrice())
                .build();

        return repository.save(skateboard).getId();
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findByCompanyContainsIgnoreCase(String company) {
        return repository.findByCompanyContainsIgnoreCase(company);
    }

    public void update(ProductPutDto productPutDto) {
        final var skateBoardToUpdate = repository.findById(productPutDto.getId())
                .orElseThrow();

        skateBoardToUpdate.update(productPutDto);

        repository.save(skateBoardToUpdate);

    }
}
