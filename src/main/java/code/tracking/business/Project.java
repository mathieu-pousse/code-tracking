package code.tracking.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Version;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class Project {

    @Id
    private Integer id;
    private String name;
    private String description;
    @Version
    private Integer version;

}


