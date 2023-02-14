package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		someBean bean = new someBean("value1","value2","value3");
		
		//dynamic filtering
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value1","value3");
		FilterProvider filters= new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		List<someBean> bean =  Arrays.asList(new someBean("value1","value2","value3"),
				new someBean("value4","value5","value6")) ;
		
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
		
        
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("value2","value3");
		FilterProvider filters= new SimpleFilterProvider().addFilter("someBeanFilter", filter);
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
}
