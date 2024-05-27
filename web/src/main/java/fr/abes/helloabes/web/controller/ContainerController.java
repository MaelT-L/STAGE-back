package fr.abes.helloabes.web.controller;

import fr.abes.helloabes.web.configuration.CustomContainerRowMapper;
import fr.abes.helloabes.web.configuration.DtoMapperUtility;
import fr.abes.helloabes.web.dto.ContainerDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/container")
public class ContainerController {


    @Autowired
    private DtoMapperUtility dtoMapper;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/getOne")
    @ApiOperation(
            value = "Liste des containers",
            notes = "Retourne une liste de tout les containers"
    )

    public ContainerDto getContainer() {
//        ContainerDto containerDto = jdbcTemplate.queryForObject("SELECT container_name,container_port,container_machine FROM container LIMIT 1", new RowMapper<ContainerDto>() {
//            @Override
//            public ContainerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
//                //return new ContainerDto(rs.getString(1), rs.getInt(2), rs.getString(3));
//
//                ContainerDto containerDto1 = new ContainerDto();
//                containerDto1.setContainerName(rs.getString("container_name"));
//                containerDto1.setContainerPort(rs.getInt("container_port"));
//                containerDto1.setContainerMachine(rs.getString("container_machine"));
//                return containerDto1;
//            }
//        });
        ContainerDto containerDto = jdbcTemplate.queryForObject("SELECT container_name,container_port,container_machine FROM container LIMIT 1", new CustomContainerRowMapper() {

        });

        return containerDto;
    }

    @GetMapping("/getAll")
    public List<ContainerDto> findAll() {

        String sql = "SELECT * FROM container";

        List<ContainerDto> containers = jdbcTemplate.query(
                sql,
//                new BeanPropertyRowMapper(ContainerDto.class));
                new CustomContainerRowMapper());

        return containers;
    }
}
