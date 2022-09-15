package miguelopetclinic.service.springdatajpa;

import miguelopetclinic.model.Owner;
import miguelopetclinic.repositories.OwnerRepository;
import miguelopetclinic.repositories.PetRepository;
import miguelopetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;
    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;
    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        Owner owner1 = new Owner();
        owner1.setId(1L);
        Owner owner2 = new Owner();
        owner1.setId(2L);
        ownerSet.add(owner1);
        ownerSet.add(owner2);

        when(ownerRepository.findAll()).thenReturn(ownerSet);

        Set<Owner> owners = ownerSDJpaService.findAll();

        assertNotNull(owners);

        assertEquals(2,owners.size());
    }

    @Test
    void findById() {

    }

    @Test
    void save() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLastName() {
        Owner returnOwner = new Owner();
        returnOwner.setId(1L);
        returnOwner.setLastName("Ramos");

        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner owner = ownerSDJpaService.findByLastName("Ramos");

        assertEquals("Ramos",owner.getLastName());

        verify(ownerRepository).findByLastName(any());
    }
}