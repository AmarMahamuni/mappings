package com.room;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.core.MediaType;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Swagger;

@RestController
@Api(value = "UserRestController", description = "REST Apis related to UserModel Entity!!!!")
@RequestMapping("/api")
public class Controller {

	@Autowired
	Repo repo;
	
	@Autowired
	PhoneNumberRepo prepo;
	
	@Autowired
	private AddressRepo add_repo;
@ApiOperation(value = "Show all Users",notes="Show all users from DB",response = UserModel.class)
@GetMapping("/show/all")
public ResponseEntity show() {
		List<UserModel> users= repo.findAll();
		 if (users.isEmpty()) {
	            return new ResponseEntity(HttpStatus.NO_CONTENT);
	            // You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<UserModel>>(users, HttpStatus.OK);
	}


@ApiOperation(value = "Show User by id",notes="Show user by id From DB",response = UserModel.class)
@GetMapping("/show/{id}")
public ResponseEntity<?> showUser(@PathVariable ("id") long id) {
	
	UserModel user= repo.findById(id).orElse(null);
	 if (user==null) {
		 return new ResponseEntity(new CustomErrorType("User with id " + id 
                 + " not found"), HttpStatus.NOT_FOUND);
         // You many decide to return HttpStatus.NOT_FOUND
     }
     return new ResponseEntity<UserModel>(user, HttpStatus.OK);
}

@ApiOperation(value = "Create User",notes="Save  user to DB",response = UserModel.class)
@PostMapping("/save")
 public ResponseEntity save(@Valid @RequestBody UserModel  um ) {
	
	//System.out.println("city"+ um.getAddress().getCity());
	if(repo.existsById(um.getId())){
		return new ResponseEntity(new CustomErrorType("Unable to create. A User with name " + 
	            um.getName() + " already exist."),HttpStatus.CONFLICT);
	}
	
	
		 
	repo.save(um);
	


	return new ResponseEntity<String>( HttpStatus.CREATED);
	
}


@ApiOperation(value = "Delete User",notes="Delete  user to DB",response = UserModel.class)
@DeleteMapping("/user/{id}")
public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {

    UserModel user = repo.findById(id).orElse(null);
    if (user == null) {
        return new ResponseEntity(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                HttpStatus.NOT_FOUND);
    }
    repo.deleteById(id);
    return new ResponseEntity<UserModel>(HttpStatus.OK);
}
}
