package com.coop.cashsends.controller;

import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coop.cashsends.dto.ApiResponse;
import com.coop.cashsends.dto.LocationDto;
import com.coop.cashsends.dto.ServicefeesDto;
import com.coop.cashsends.dto.TaxesDto;
import com.coop.cashsends.dto.TransfastDto;
import com.coop.cashsends.dto.UserDto;
import com.coop.cashsends.exception.ConfigurationServiceException;
import com.coop.cashsends.exception.ResourceNotFoundException;
import com.coop.cashsends.exception.UserServiceException;
import com.coop.cashsends.service.AuthenticationFacadeService;
import com.coop.cashsends.service.ConfigurationService;

@RestController
@RequestMapping("api/configuration")
public class ConfigurationController {
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	public static final String SUCCESS = "success";
	public static final String ROLE_COUNTRY_MANAGER = "ROLE_COUNTRY_MANAGER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_PARTNER = "ROLE_PARTNER";
	public static final String ROLE_TELLER = "ROLE_TELLER";
	
	@Autowired
	private AuthenticationFacadeService authenticationFacadeService;
	
	
	@Autowired
    private ConfigurationService configurationService;
	
	//@Secured({ROLE_PARTNER,ROLE_ADMIN,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@PostMapping(value = "transfastmasters")
	@CrossOrigin
	public ApiResponse lovtypes(@RequestBody TransfastDto transfastDto) throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.transfastmasters(transfastDto));
	}	
	
	//@Secured({ROLE_PARTNER})
    @PreAuthorize("hasRole('PARTNER')")
	@PostMapping(value = "locations")
	@CrossOrigin
	public ApiResponse createLocations(@RequestBody LocationDto locationDto) throws ResourceNotFoundException, ConfigurationServiceException{
	//log.info(String.format("received request to create location %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.createLocations(locationDto));
	}
	
	//@Secured({ROLE_PARTNER,ROLE_ADMIN,ROLE_COUNTRY_MANAGER,ROLE_TELLER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "getlocations/{partnerid}")
	@CrossOrigin
	public ApiResponse getLocations(@PathVariable Integer partnerid) throws ResourceNotFoundException, ConfigurationServiceException{
	//log.info(String.format("received request to fetch location by partner id %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.getLocations(partnerid));
	}
	
	@GetMapping(value = "countries")
	@CrossOrigin
	public ApiResponse countries() throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.countries());
	}
	
	@GetMapping(value = "states/{countryisocode}")
	@CrossOrigin
	public ApiResponse states(@PathVariable String countryisocode) throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.states(countryisocode));
	}
	
	@GetMapping(value = "cities/{countryisocode}/{stateid}")
	@CrossOrigin
	public ApiResponse cities(@PathVariable String countryisocode,@PathVariable String stateid) throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.cities(countryisocode,stateid));
	}
	
	//@Secured({ROLE_ADMIN})
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "createtax")
	@CrossOrigin
	public ApiResponse createTax(@RequestBody TaxesDto taxesDto) throws ResourceNotFoundException, ConfigurationServiceException{
	//log.info(String.format("received request to create location %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.createTax(taxesDto));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER,ROLE_PARTNER,ROLE_TELLER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "gettaxes")
	@CrossOrigin
	public ApiResponse gettaxes() throws ResourceNotFoundException, ConfigurationServiceException{
	//log.info(String.format("received request to create location %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.gettaxes());
	}
	
	//@Secured({ROLE_ADMIN})
    @PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "createservicefees")
	@CrossOrigin
	public ApiResponse createServicefees(@RequestBody ServicefeesDto servicefeesDto) throws ResourceNotFoundException, ConfigurationServiceException{
	//log.info(String.format("received request to create location %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.createServicefees(servicefeesDto));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_COUNTRY_MANAGER,ROLE_PARTNER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "getservicefees")
	@CrossOrigin
	public ApiResponse getServicefees() throws ResourceNotFoundException, ConfigurationServiceException{
	//log.info(String.format("received request to create location %s", authenticationFacadeService.getAuthentication().getPrincipal()));
	  return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.getServicefees());
	}

	//@Secured({ROLE_PARTNER,ROLE_ADMIN,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
    @PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "currency")
	@CrossOrigin
	public ApiResponse allCurrency() throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.allCurrency());
	}
	
	//@Secured({ROLE_TELLER,ROLE_PARTNER})
    @PreAuthorize("hasRole('TELLER') or hasRole('PARTNER')")
	@PostMapping(value = "servicerate")
	@CrossOrigin
	public ApiResponse serviceRate(@RequestBody ServicefeesDto servicefeesDto) throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.serviceRate(servicefeesDto));
	}
	
	@GetMapping(value = "taxesforcountry/{countryiso}")
	@CrossOrigin
	public ApiResponse taxesforCountry(@PathVariable String countryiso) throws ResourceNotFoundException, ConfigurationServiceException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, configurationService.taxesforCountry(countryiso));
	}	


}
