package miguelopetclinic.repositories;

import miguelopetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet,Long> {
}
