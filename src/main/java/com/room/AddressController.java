package com.room;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressRepo add_repo;
	
	
	@PostMapping(value="/save")
	public void save(@RequestBody Address address)
	{
		add_repo.save(address);
	}
	
	@GetMapping("/show/all")
	public List<Address> showAdresses()
	{
		List<Address> adddress=add_repo.findAll();
		return adddress;
		
	}
	
		
	
	

}
