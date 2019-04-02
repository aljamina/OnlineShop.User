package com.techprimers.db.resource;

import com.techprimers.db.model.Users;
import com.techprimers.db.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping(value = "/all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }

    @PostMapping(value = "/load")
    public List<Users> persist(@Valid @RequestBody  final Users users, Errors errors) {
        /*if (errors.hasErrors()){
            String errorMessage = errors.getFieldError("yourFieldName").getDefaultMessage();
           System.out.println("GRESKAAAAAAAAA******************"+errorMessage);
        }*/
            usersRepository.save(users);
            return usersRepository.findAll();
        }
    @PostMapping(value = "/createUser")
    public ResponseEntity<Users> createUser(@Valid @RequestBody Users users){

        Users returnvalue=new Users();
        returnvalue.setIme(users.getIme());
        returnvalue.setPrezime(users.getPrezime());
        returnvalue.setEmail(users.getEmail());
        returnvalue.setPassword(users.getPassword());

        usersRepository.save(users);
        return  new ResponseEntity<Users>(returnvalue, HttpStatus.OK);
        }

    }


