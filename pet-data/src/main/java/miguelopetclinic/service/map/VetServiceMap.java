package miguelopetclinic.service.map;

import java.util.Set;

import miguelopetclinic.model.Specialty;
import miguelopetclinic.service.SpecialtyService;
import org.springframework.stereotype.Service;

import miguelopetclinic.model.Vet;
import miguelopetclinic.service.VetService;

@Service
public class VetServiceMap extends AbstractMapService <Vet,Long> implements VetService{

    private final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

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
        if(object.getSpecialties().size()>0){
            object.getSpecialties().forEach(s -> {
                if(s.getId() == null){
                    Specialty savedSpecialty = specialtyService.save(s);
                    s.setId(savedSpecialty.getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
