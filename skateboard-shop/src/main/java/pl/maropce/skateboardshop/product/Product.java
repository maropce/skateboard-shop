package pl.maropce.skateboardshop.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.maropce.skateboardshop.product.dto.ProductPutDto;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private String company;
    private double deckWide;
    private int wheels;
    private double price;

    void update(final ProductPutDto skateboardPut) {
        this.company = skateboardPut.getCompany();
        this.deckWide = skateboardPut.getDeckWide();
        this.wheels = skateboardPut.getWheels();
        this.price = skateboardPut.getPrice();
    }
}
