package pl.maropce.skateboardshop.product.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductPutDto {
    @JsonIgnore
    private Integer id;

    private String company;
    private Double deckWide;
    private Integer wheels;
    private Double price;
}
