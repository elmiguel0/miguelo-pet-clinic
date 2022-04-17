package miguelopetclinic.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import miguelopetclinic.model.Pet;
import miguelopetclinic.service.PetService;

@Service
public class PetServiceMap extends AbstractMapService <Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Pet ocject) {
        super.delete(ocject);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}