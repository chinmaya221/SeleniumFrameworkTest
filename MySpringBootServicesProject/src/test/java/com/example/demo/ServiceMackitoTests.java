package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.beans.Country;
import com.example.demo.repository.CountryRepository;
import com.example.demo.services.CountryService;

@SpringBootTest(classes= {ServiceMackitoTests.class})
public class ServiceMackitoTests {
	
	@Mock
	CountryRepository countryRep;
	
	@InjectMocks
	CountryService countryService;
	
	@Test
	@Order(1)
	public void test_getAllCountries() {
		
		List<Country> mycountires = new ArrayList<Country>();
		mycountires.add(new Country(1,"India","Delhi"));
		mycountires.add(new Country(1,"USA","Washington"));
		
		when(countryRep.findAll()).thenReturn(mycountires);
		assertEquals(2,countryService.getAllCountries().size());
		
		
		
	}
	
	@Test
	@Order(2)
	public void test_getCountryById() {
		
		List<Country> mycountires = new ArrayList<Country>();
		mycountires.add(new Country(1,"India","Delhi"));
		mycountires.add(new Country(1,"USA","Washington"));
		
		int countryId=1;
		
		when(countryRep.findAll()).thenReturn(mycountires);
		assertEquals(countryId,countryService.getCountryById(countryId).getId());
		
		
		
	}

}
