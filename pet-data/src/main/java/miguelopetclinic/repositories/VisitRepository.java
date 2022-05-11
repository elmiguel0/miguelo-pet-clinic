package miguelopetclinic.repositories;

import miguelopetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
