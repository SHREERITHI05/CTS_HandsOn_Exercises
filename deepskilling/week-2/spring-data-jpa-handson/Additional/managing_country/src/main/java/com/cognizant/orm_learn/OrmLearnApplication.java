package com.cognizant.orm_learn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryService = context.getBean(CountryService.class);

		testGetAllCountries();
		testGetCountryByCode();
		testAddCountry();
		testUpdateCountry();
		testGetCountriesByPartialName();
		testDeleteCountry();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start - testGetAllCountries");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("Total countries={}", countries.size());
		LOGGER.info("End - testGetAllCountries");
	}

	private static void testGetCountryByCode() {
		LOGGER.info("Start - testGetCountryByCode");
		Country country = countryService.getCountryByCode("IN");
		LOGGER.debug("country={}", country);
		LOGGER.info("End - testGetCountryByCode");
	}

	private static void testAddCountry() {
		LOGGER.info("Start - testAddCountry");
		Country newCountry = new Country();
		newCountry.setCode("XX");
		newCountry.setName("Test Country");
		Country saved = countryService.addCountry(newCountry);
		LOGGER.debug("saved={}", saved);
		LOGGER.info("End - testAddCountry");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start - testUpdateCountry");
		Country country = countryService.getCountryByCode("XX");
		if (country != null) {
			country.setName("Updated Test Country");
			Country updated = countryService.updateCountry(country);
			LOGGER.debug("updated={}", updated);
		}
		LOGGER.info("End - testUpdateCountry");
	}

	private static void testGetCountriesByPartialName() {
		LOGGER.info("Start - testGetCountriesByPartialName");
		List<Country> countries = countryService.getCountriesByPartialName("stan");
		LOGGER.debug("countries matching 'stan'={}", countries);
		LOGGER.info("End - testGetCountriesByPartialName");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start - testDeleteCountry");
		countryService.deleteCountry("XX");
		LOGGER.info("End - testDeleteCountry");
	}

}