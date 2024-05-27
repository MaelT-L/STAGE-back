package fr.abes.helloabes.core.entities;


import lombok.Getter;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
public class Container implements Serializable {

    private static final long serialVersionUID = 1L;

    //Id du container
    private Long id;

    //Nom du container
    private String containerName;

    //Port du container
    private Integer containerPort;

    //Server du container
    private String containerMachine;
}
