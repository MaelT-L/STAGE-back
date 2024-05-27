package fr.abes.helloabes.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductDto {

//    @JsonProperty("id")
//    private Long id;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private Double productPrice;

    public ProductDto(String productName, Double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }
}
