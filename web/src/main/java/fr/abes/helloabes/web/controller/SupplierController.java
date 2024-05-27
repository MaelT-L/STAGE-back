package fr.abes.helloabes.web.controller;

import fr.abes.helloabes.web.configuration.DtoMapperUtility;
import fr.abes.helloabes.web.dto.ContainerDto;
import fr.abes.helloabes.web.dto.ProductDto;
import fr.abes.helloabes.web.dto.SupplierDto;
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
@RequestMapping("/supplier")
public class SupplierController {

@Autowired
    private DtoMapperUtility dtoMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/getOne")
    @ApiOperation(
            value = "Liste des fournisseurs",
            notes = "Retourne une liste de tout les fournisseurs"
    )

    public SupplierDto getSupplier() {
        SupplierDto supplierDto = jdbcTemplate.queryForObject("SELECT supplier_id, supplier_name FROM supplier LIMIT 1", new RowMapper<SupplierDto>() {
            @Override
            public SupplierDto mapRow(ResultSet rs, int rowNum) throws SQLException {

                SupplierDto supplierDto1 = new SupplierDto();
                supplierDto1.setSupplierId(rs.getLong("supplier_id"));
                supplierDto1.setSupplierName(rs.getString("supplier_name"));
                return supplierDto1;
            }
        });
        return supplierDto;
    }

    @GetMapping("/getAll")
    public List<SupplierDto> findAll() {

        String sql = "SELECT * FROM supplier";

        List<SupplierDto> suppliers = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(SupplierDto.class));
        return suppliers;
    }
}
