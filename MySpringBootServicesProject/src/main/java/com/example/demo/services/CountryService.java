package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.beans.Country;
import com.example.demo.controllers.AddResponse;
import com.example.demo.repository.CountryRepository;

@Component
public class CountryService {
	
	@Autowired
	CountryRepository countryRep;
	
	public List<Country> getAllCountries() {
		
		return countryRep.findAll();
	}
	
	
	public Country getCountryById(int id)
	{
		return countryRep.getById(id);
	}
	
	public Country getCountryByName(String countryName)
	{
		List<Country> countries = countryRep.findAll();
		Country country = null;
		for(Country con:countries)
		{
			if(con.getCountryName().equalsIgnoreCase(countryName))
				country=con;
		}
		
		return country;
	}
	
	public Country addCountry(Country country) {
		
		country.setId(getMaxId());
		countryRep.save(country);
		return country;
		
	}
	
	public  int getMaxId() {
		return countryRep.findAll().size()+1;
	}
	
	public Country updateCountry(Country country)
	{
		countryRep.save(country);
		return country;
	}
	
	public AddResponse deleteCountry(int id)
	{
		countryRep.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("Country Deleted !");
		res.setId(id);
		return res;
		
	}

}
