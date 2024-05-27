package fr.abes.helloabes.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ContainerDto {

    @JsonProperty("id")
    private Long containerId;

    @JsonProperty("name")
    private String containerName;

    @JsonProperty("port")
    private Integer containerPort;

    @JsonProperty("machine")
    private String containerMachine;

    public ContainerDto(Long containerId, String containerName, Integer containerPort, String containerMachine) {
        this.containerId = containerId;
        this.containerName = containerName;
        this.containerPort = containerPort;
        this.containerMachine = containerMachine;
    }
}
