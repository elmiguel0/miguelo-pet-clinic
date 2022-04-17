package miguelopetclinic.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import miguelopetclinic.model.Vet;
import miguelopetclinic.service.VetService;

@Service
public class VetServiceMap extends AbstractMapService <Vet,Long> implements VetService{

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    
    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    
    @Override
    public Vet save(Vet object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Vet ocject) {
        super.delete(ocject);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
