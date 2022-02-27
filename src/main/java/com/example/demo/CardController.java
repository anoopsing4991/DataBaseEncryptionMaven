package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CardController {
	@Autowired
	CardDetailRepository cardDetailRepository;
	
	@Autowired
	CreditCardRepository creditCardRepository;
	
	@GetMapping("/all")
	public List<CreditCard> getAllCard(){
		
		return creditCardRepository.findAll();
	}
	
	@GetMapping("/{name}")
	public List<CreditCard> getByName(@PathVariable("name") String name){
		
		return creditCardRepository.findByName(name);
	}
	
	@PostMapping("/save")
	public String getSaveCard(@RequestBody CreditCard cardDetail) throws Exception{
		
	Long id=	creditCardRepository.save(cardDetail).getId();
	System.out.println(id);
	if(id!=null)
		 return "save successflly";
	else {
		throw new Exception();
	}
	}
	

}
