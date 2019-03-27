package com.techprimers.db.resource;

import com.techprimers.db.model.Roles;
import com.techprimers.db.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/roles")
public class RolesResource {

    @Autowired
    RolesRepository rolesRepository;

    @GetMapping(value = "/all")
    public List<Roles> getAll() {
        return rolesRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Roles> persist(@RequestBody final Roles users) {
        rolesRepository.save(users);
        return rolesRepository.findAll();
    }

}
