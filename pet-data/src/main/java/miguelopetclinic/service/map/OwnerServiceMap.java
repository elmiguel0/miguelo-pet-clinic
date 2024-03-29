package miguelopetclinic.service.map;

import java.util.Optional;
import java.util.Set;

import miguelopetclinic.model.Pet;
import miguelopetclinic.service.PetService;
import miguelopetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import miguelopetclinic.model.Owner;
import miguelopetclinic.service.OwnerService;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService <Owner,Long> implements OwnerService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }


    @Override
    public void delete(Owner ocject) {
        super.delete(ocject);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

	@Override
	public Owner findByLastName(String lastNAme) {
        return  this.findAll().stream()
                .filter(o -> o.getLastName().equalsIgnoreCase(lastNAme))
                .findFirst()
                .orElse(null);
	}
    
}