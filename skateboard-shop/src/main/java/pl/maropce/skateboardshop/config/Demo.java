package pl.maropce.skateboardshop.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.maropce.skateboardshop.product.Product;
import pl.maropce.skateboardshop.product.ProductRepository;
import pl.maropce.skateboardshop.user.User;
import pl.maropce.skateboardshop.user.UserRepository;

@Configuration
@RequiredArgsConstructor
public class Demo {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Bean
    void createUsers() {
        userRepository.save(
                User.builder()
                        .email("marek@gmail.com")
                        .username("maropce")
                        .password("maropce123").build()
        );
    }

    @Bean
    void createProducts() {
        productRepository.save(
                Product.builder()
                        .company("Thrasher")
                        .deckWide(8.5)
                        .wheels(54)
                        .price(299)
                        .build()
        );

        productRepository.save(
                Product.builder()
                        .company("Independent")
                        .deckWide(8.0)
                        .wheels(56)
                        .price(239)
                        .build()
        );
    }
}
