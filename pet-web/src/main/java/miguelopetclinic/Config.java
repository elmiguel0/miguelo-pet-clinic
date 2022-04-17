package miguelopetclinic;

/* this class was made because I have a bad structure on the packages and the @Service *
 * tag on Owner and Vet map services where not bean pick up.							  */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import miguelopetclinic.map.OwnerServiceMap;
import miguelopetclinic.map.VetServiceMap;
import miguelopetclinic.service.OwnerService;
import miguelopetclinic.service.VetService;

//@Configuration
public class Config {
	
	@Bean
	OwnerService ownerService() {
		return new OwnerServiceMap();
	}
	
	@Bean 
	VetService vetService() {
		return new VetServiceMap();
	}

}
