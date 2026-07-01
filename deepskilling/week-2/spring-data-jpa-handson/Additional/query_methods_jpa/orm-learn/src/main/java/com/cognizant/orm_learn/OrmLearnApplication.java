package com.cognizant.orm_learn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.model.Stock;
import com.cognizant.orm_learn.repository.CountryRepository;
import com.cognizant.orm_learn.repository.StockRepository;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	private static CountryService countryService;
	private static CountryRepository countryRepository;
	private static StockRepository stockRepository;

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryService = context.getBean(CountryService.class);
		countryRepository = context.getBean(CountryRepository.class);
		stockRepository = context.getBean(StockRepository.class);

		// Basic CRUD tests
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();

		// Query Method tests - Country
		testSearchByPartialName();
		testSearchByPartialNameOrdered();
		testSearchByStartingLetter();

		// Query Method tests - Stock
		testFacebookSeptember2019();
		testGoogleAbove1250();
		testTop3HighestVolume();
		testNetflixLowest3();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("Total countries={}", countries.size());
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("IN");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	private static void testAddCountry() throws CountryNotFoundException {
		LOGGER.info("Start");

		Country newCountry = new Country();
		newCountry.setCode("ZZ");
		newCountry.setName("Test Land");

		countryService.addCountry(newCountry);

		Country fetchedCountry = countryService.findCountryByCode("ZZ");
		LOGGER.debug("Fetched Country after add:{}", fetchedCountry);

		LOGGER.info("End");
	}

	private static void testSearchByPartialName() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findByNameContainingIgnoreCase("ou");
		countries.forEach(c -> LOGGER.debug("{}", c));
		LOGGER.info("End");
	}

	private static void testSearchByPartialNameOrdered() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findByNameContainingIgnoreCaseOrderByNameAsc("ou");
		countries.forEach(c -> LOGGER.debug("{}", c));
		LOGGER.info("End");
	}

	private static void testSearchByStartingLetter() {
		LOGGER.info("Start");
		List<Country> countries = countryRepository.findByNameStartingWithIgnoreCase("Z");
		countries.forEach(c -> LOGGER.debug("{}", c));
		LOGGER.info("End");
	}

	private static void testFacebookSeptember2019() {
		LOGGER.info("Start");
		LocalDate start = LocalDate.of(2019, 9, 1);
		LocalDate end = LocalDate.of(2019, 9, 30);
		List<Stock> stocks = stockRepository.findByCodeAndDateBetween("FB", start, end);
		stocks.forEach(s -> LOGGER.debug("{}", s));
		LOGGER.info("End");
	}

	private static void testGoogleAbove1250() {
		LOGGER.info("Start");
		List<Stock> stocks = stockRepository.findByCodeAndPriceAbove("GOOGL", new BigDecimal("1250"));
		stocks.forEach(s -> LOGGER.debug("{}", s));
		LOGGER.info("End");
	}

	private static void testTop3HighestVolume() {
		LOGGER.info("Start");
		List<Stock> stocks = stockRepository.findTop3ByOrderByVolumeDesc();
		stocks.forEach(s -> LOGGER.debug("{}", s));
		LOGGER.info("End");
	}

	private static void testNetflixLowest3() {
		LOGGER.info("Start");
		List<Stock> stocks = stockRepository.findTop3ByCodeOrderByCloseAsc("NFLX");
		stocks.forEach(s -> LOGGER.debug("{}", s));
		LOGGER.info("End");
	}

}