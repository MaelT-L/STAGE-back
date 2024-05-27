package fr.abes.helloabes.web.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupplierDto {

    @JsonProperty("id")
    private Long supplierId;

    @JsonProperty("name")
    private String supplierName;

    public SupplierDto(Long supplierId, String supplierName) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
    }
}
