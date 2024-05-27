package fr.abes.helloabes.web.controller;

import fr.abes.helloabes.web.configuration.CustomContainerRowMapper;
import fr.abes.helloabes.web.configuration.DtoMapperUtility;
import fr.abes.helloabes.web.dto.ProductDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private DtoMapperUtility dtoMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/getOne")
    @ApiOperation(
            value = "Liste des produits",
            notes = "Retourne une liste de tout les produits"
    )

    public ProductDto getProduct() {
        ProductDto productDto = jdbcTemplate.queryForObject("SELECT product_name,product_price FROM product LIMIT 1", new RowMapper<ProductDto>() {
            @Override
            public ProductDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                ProductDto productDto1 = new ProductDto();
                productDto1.setProductName(rs.getString("product_name"));
                productDto1.setProductPrice(rs.getDouble("product_price"));
                return productDto1;
            }
        });
        return productDto;
    }

    @GetMapping("/getAll")
    public List<ProductDto> findAll() {

        String sql = "SELECT * FROM product";

        List<ProductDto> products = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(ProductDto.class));
        return products;
    }
}
