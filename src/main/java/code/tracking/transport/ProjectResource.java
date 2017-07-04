package code.tracking.transport;

import code.tracking.business.Project;
import code.tracking.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectResource {


    @Autowired
    private ProjectRepository repository;

    @PostMapping("/")
    public ResponseEntity create() {
        Project pro = new Project();
        pro.setName("code-tracking");
        pro.setDescription("code-tracking");
        this.repository.save(pro);
        return ResponseEntity.ok("done");
    }

    @GetMapping("/")
    public List<Project> findAll() {
        return this.repository.findAll();
    }

}
