package code.tracking.repository;

import code.tracking.business.Project;
import org.springframework.data.orient.object.repository.OrientObjectRepository;

import java.util.List;

public interface ProjectRepository extends OrientObjectRepository<Project> {

    List<Project> findByName(String name);

}
