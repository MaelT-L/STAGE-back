package fr.abes.helloabes.web.configuration;
import fr.abes.helloabes.web.dto.ContainerDto;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CustomContainerRowMapper implements RowMapper<ContainerDto> {

    @Override
    public ContainerDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        ContainerDto containerDto = new ContainerDto();
        containerDto.setContainerId(rs.getLong("container_id"));

        String containerName = rs.getString("container_name");
        containerDto.setContainerName(rs.wasNull() ? null : containerName);

        int containerPort = rs.getInt("container_port");
        containerDto.setContainerPort(rs.wasNull() ? null : containerPort);

        String containerMachine = rs.getString("container_machine");
        containerDto.setContainerMachine(rs.wasNull() ? null : containerMachine);

        return containerDto;
    }

}