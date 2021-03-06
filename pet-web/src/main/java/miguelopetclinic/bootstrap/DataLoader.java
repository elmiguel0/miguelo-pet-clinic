package miguelopetclinic.bootstrap;

import miguelopetclinic.model.*;
import miguelopetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile({"default","map"})
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialtyService specialtyService;
	private final VisitService visitService;
	public DataLoader (OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService){
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialtyService = specialtyService;
		this.visitService = visitService;
	}
	
	@Override
	public void run(String... args) throws Exception {

		int count = petTypeService.findAll().size();

		if(count == 0){
			loadData();
		}

	}

	private void loadData() {
		PetType dog = new PetType();
		dog.setName("Dog");
		PetType saveDogPetType = petTypeService.save(dog);

		PetType cat = new PetType();
		dog.setName("Cat");
		PetType saveCatPetType = petTypeService.save(cat);

		Specialty radiology = new Specialty();
		radiology.setDescription("Radiology");
		Specialty savedRadiology = specialtyService.save(radiology);

		Specialty surgery = new Specialty();
		surgery.setDescription("Surgery");
		Specialty savedSurgery = specialtyService.save(surgery);


		Specialty dentistry = new Specialty();
		dentistry.setDescription("Dentistry");
		Specialty savedDentistry = specialtyService.save(dentistry);

		Owner owner1 = new Owner();
		owner1.setFirstName("Michael");
		owner1.setLastName("Weston");
		owner1.setAddress("123 Garvin Ave");
		owner1.setCity("Richmond");
		owner1.setTelephone("5102324567");

		Pet mikesPet = new Pet();
		mikesPet.setPetType(saveDogPetType);
		mikesPet.setOwner(owner1);
		mikesPet.setBirthDate(LocalDate.now());
		mikesPet.setName("Rosco");
		owner1.getPets().add(mikesPet);
		ownerService.save(owner1);


		Owner owner2 = new Owner();
		owner2.setFirstName("Fiona");
		owner2.setLastName("Glenanne");
		owner2.setAddress("121 23 street");
		owner2.setCity("Sam Pablo");
		owner2.setTelephone("2345643214");

		Pet fionaCat = new Pet();
		fionaCat.setPetType(saveCatPetType);
		fionaCat.setOwner(owner2);
		fionaCat.setBirthDate(LocalDate.now());
		fionaCat.setName("Rosy");
		owner2.getPets().add(fionaCat);
		ownerService.save(owner2);

		Visit visit1 = new Visit();
		visit1.setPet(fionaCat);
		visit1.setDate(LocalDate.now());
		visit1.setDescription("sneesy Kitty");
		visitService.save(visit1);

		Owner owner3 = new Owner();
		owner3.setFirstName("Miguel");
		owner3.setLastName("Ramos");
		owner1.setAddress("francisco contreras 85");
		owner1.setCity("guadalagara");
		owner1.setTelephone("+523325797377");
		ownerService.save(owner3);

		System.out.println("Loaded Owners.....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Sam");
		vet1.setLastName("Axe");
		vet1.getSpecialties().add(savedRadiology);
		vetService.save(vet1);

		Vet vet2 = new Vet();
		vet2.setFirstName("Jessie");
		vet2.setLastName("Porter");
		vet2.getSpecialties().add(savedSurgery);
		vetService.save(vet2);

		System.out.println("Loaded Vets.....");
	}

}
