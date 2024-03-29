package miguelopetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import miguelopetclinic.service.OwnerService;

@RequestMapping("owners")
@Controller
public class OwnerController {
	
	private final OwnerService ownersService;

    public OwnerController(OwnerService ownersService) {
		this.ownersService = ownersService;
	}


	@RequestMapping({"","/"})
    public String listOwners(Model model){
        model.addAttribute("owners",ownersService.findAll());
		return"owners/index";
    }
    
}
