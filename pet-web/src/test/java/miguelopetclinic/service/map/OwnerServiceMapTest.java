package miguelopetclinic.service.map;

import miguelopetclinic.model.Owner;
import miguelopetclinic.service.PetService;
import miguelopetclinic.service.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    @Mock
    PetTypeService petTypeService;
    @Mock
    PetService petService;

    Long ownerId = 1L;
    String ownerLastName = "Ramos";

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(petTypeService,petService);
        Owner owner = new Owner();
        owner.setId(ownerId);
        ownerServiceMap.save(owner);
    }

    @Test
    void findAll() {
        Set<Owner> list = ownerServiceMap.findAll();
        assertEquals(1,list.size());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(1l);
        assertEquals(1l,owner.getId());
    }

    @Test
    void save() {
        Owner owner = new Owner();
        owner.setId(2L);
        Owner newOwner = ownerServiceMap.save(owner);
        assertEquals(2L,owner.getId());
    }

    @Test
    void delete() {
        Owner owner = new Owner();
        owner.setId(2L);
        owner.setLastName(ownerLastName);
        ownerServiceMap.save(owner);

        ownerServiceMap.delete(owner);

        Owner toFind = ownerServiceMap.findById(2L);
        assertNull(toFind);
    }

    @Test
    void deleteById() {
        Owner owner = new Owner();
        owner.setId(2L);
        owner.setLastName(ownerLastName);
        ownerServiceMap.save(owner);
        ownerServiceMap.deleteById(2L);
        Owner toFind = ownerServiceMap.findById(2L);
        assertNull(toFind);
    }


}