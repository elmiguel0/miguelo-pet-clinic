package miguelopetclinic.service;

import miguelopetclinic.model.Owner;

public interface OwnerService extends CrudService <Owner,Long>{
    Owner findByLastName(String lastNAme);
}
