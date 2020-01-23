package com.room;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pnumber")
public class PhoneNumberController {
	
	@Autowired
	private PhoneNumberRepo pnumrepo;
	
	@GetMapping("/pnumber/save")
	private void saveNumber(@RequestBody PhoneNumbers pnum ) {
		pnumrepo.save(pnum);
		
	}
	
	@PostMapping("/show")
	private List<PhoneNumbers> showNumbers()
	{
		List<PhoneNumbers> plist=pnumrepo.findAll();
		return plist;
	}

}
