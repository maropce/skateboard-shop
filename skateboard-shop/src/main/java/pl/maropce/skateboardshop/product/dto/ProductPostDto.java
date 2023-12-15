package pl.maropce.skateboardshop.product.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductPostDto {
    private String company;
    private Double deckWide;
    private Integer wheels;
    private Double price;
}
