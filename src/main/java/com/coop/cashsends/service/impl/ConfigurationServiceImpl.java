package com.coop.cashsends.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import com.coop.cashsends.dto.CityDto;
import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.dto.CurrencyDto;
import com.coop.cashsends.dto.LocationDto;
import com.coop.cashsends.dto.PartnerDto;
import com.coop.cashsends.dto.ServicefeesDto;
import com.coop.cashsends.dto.StateDto;
import com.coop.cashsends.dto.TaxesDto;
import com.coop.cashsends.dto.TransfastDto;
import com.coop.cashsends.dto.TransfastResponseDto;
import com.coop.cashsends.exception.ConfigurationServiceException;
import com.coop.cashsends.model.Locations;
import com.coop.cashsends.model.LovType;
import com.coop.cashsends.model.LovValue;
import com.coop.cashsends.model.Servicefees;
import com.coop.cashsends.model.Taxes;
import com.coop.cashsends.model.TransfastRouter;
import com.coop.cashsends.model.UserCountrykeys;
import com.coop.cashsends.repository.CityRepository;
import com.coop.cashsends.repository.CountryRepository;
import com.coop.cashsends.repository.CurrencyRepository;
import com.coop.cashsends.repository.LocationsRepository;
import com.coop.cashsends.repository.LovTypesRepository;
import com.coop.cashsends.repository.ServicefeesRepository;
import com.coop.cashsends.repository.StateRepository;
import com.coop.cashsends.repository.TaxesRepository;
import com.coop.cashsends.repository.TransfastRoutersRepository;
import com.coop.cashsends.repository.UserCountrykeysRepository;
import com.coop.cashsends.repository.UserRepository;
import com.coop.cashsends.service.ConfigurationService;


@Transactional
@Service(value = "configurationService")
public class ConfigurationServiceImpl implements ConfigurationService {

	RestTemplate restTemplate;
	@Autowired
	 private LocationsRepository locationsRepository;
	@Autowired
	private CountryRepository countryRepository;
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	 @Autowired
	 private TransfastRoutersRepository transfastRoutersRepository;
	 
	 @Autowired
	 private UserCountrykeysRepository userCountrykeysRepository ;
	 
	 @Autowired
	 private LovTypesRepository lovTypesRepository;
	 
	 @Autowired
	 private TaxesRepository taxesRepository;
	 
	 @Autowired
	 private ServicefeesRepository servicefeesRepository;
	 
	 @Autowired
	 private CurrencyRepository currencyRepository;
	 
	 @Autowired
	 private UserRepository userRepository;
	
	@Override
	public TransfastResponseDto transfastmasters(TransfastDto transfastDto) throws JSONException,ConfigurationServiceException  {
		TransfastResponseDto  transfastResponseDto =null;
		
		TransfastRouter  transfastRouter =null;
		transfastRouter =transfastRoutersRepository.findBySourceType(transfastDto.getType());
		UserCountrykeys userCountrykeys =null;
		String transtype =transfastDto.getTranstype();
		String basecountrycode =transfastDto.getBasecode();
		if(transtype ==null) {
			transtype ="SENDMONEY";
			basecountrycode ="PA";
		}
		userCountrykeys =userCountrykeysRepository.finbyCountryAndUser(basecountrycode,transtype);
		
		String url =transfastRouter.getSourceurl();
		
		String params = transfastDto.getParams();
		
		StringTokenizer st = new StringTokenizer(params,"|");
		int counter =1;
		 while(st.hasMoreTokens()) {
			String tokenvalue = st.nextToken();
			String replaceval =String.valueOf(counter)+"?";
			//System.out.println("sdfdf"+replaceval);
			url =url.replace(replaceval, tokenvalue);
			//System.out.println("sdfffff"+url);
			counter++;
		 }
		 
		 
		 
		 LovType lovType =null;
		 //System.out.println("tra"+transtype);
		 if(transtype.equalsIgnoreCase("SENDMONEY")) {
			 
					 
		 lovType = lovTypesRepository.getLovType("SEND_MONEY_URL"); 
		 }else {
		  lovType = lovTypesRepository.getLovType("CASH_PICKUP");  
		 }
		 String baseurl =lovType.getLovValues().get(0).getValue();
		 url =baseurl+url;
		 System.out.println(url);
		 HttpHeaders headers = new HttpHeaders();
		 headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		 headers.set("Authorization", userCountrykeys.getCountrytokenkey());
		 System.out.println(userCountrykeys.getCountrytokenkey());
			
		 restTemplate = new RestTemplate();
		 HttpEntity request = new HttpEntity(headers);
		 ResponseEntity<String> response  =null;
		 
		 if(transfastDto.getType().equalsIgnoreCase("GET_INVOICES")) {
		 response = this.restTemplate.exchange(url, HttpMethod.PUT, request, String.class);
		 }else {
			 response = this.restTemplate.exchange(url, HttpMethod.GET, request, String.class); 
		 }
		 
		    if(response.getStatusCode() == HttpStatus.OK) {
		    	JSONObject jsonObj = null;
		    	transfastResponseDto = new TransfastResponseDto();
		    	transfastResponseDto.setResult(response.getBody());
		    	  return transfastResponseDto;
		    } else {
		        return transfastResponseDto;
		    }
		 
		
	}
	@Override
	public int createLocations(LocationDto locationDto) throws ConfigurationServiceException {
		int pkid =0;
		Locations locations =null;
		locations = new Locations();
		locations.setAddress(locationDto.getAddress());
		locations.setCityid(locationDto.getCityid());
		locations.setCountryid(locationDto.getCountryid());
		locations.setLatitude(locationDto.getLatitude());
		locations.setLongitude(locationDto.getLongitude());
		locations.setPartnerid(locationDto.getPartnerid());
		locations.setStateid(locationDto.getStateid());
		locations.setLocationame(locationDto.getLocationname());
		locations.setId(locationDto.getId());
		locations.setIsactive(locationDto.isIsactive());
		System.out.println(locationDto.getBranchId());
		
		if(locationDto.getId() !=null) {
		
		locations.setBranchId(locationDto.getBranchId());
		}else {
			locations.setBranchId(userRepository.uniqueSequenceNumber());
				
		}
		locations.setPayerbranchphone1(locationDto.getPayerbranchphone1());
		locations.setPayerbranchphone2(locationDto.getPayerbranchphone2());
		pkid  =locationsRepository.save(locations).getId();
		return pkid;
	}
	@Override
	public List<LocationDto> getLocations(Integer partnerid) throws ConfigurationServiceException {
		List<LocationDto> locationDto = new ArrayList<>();
		locationsRepository.partnerLocations(partnerid).iterator().forEachRemaining(locations -> locationDto.add(locations.toLocationDto()));
		return locationDto;
	}
	@Override
	public List<CountryDto> countries() throws ConfigurationServiceException {
		List<CountryDto> countryDtos = new ArrayList<>();
		countryRepository.findAll().iterator().forEachRemaining(country -> countryDtos.add(country.toCountryDto()));
		return countryDtos;
	}
	@Override
	public List<StateDto> states(String countryisocode) throws ConfigurationServiceException {
		List<StateDto> statesDtos = new ArrayList<>();
		stateRepository.getstates(countryisocode,true).iterator().forEachRemaining(state -> statesDtos.add(state.toStateDto()));
		return statesDtos;
	}
	@Override
	public List<CityDto> cities(String countryisocode, String stateid) throws ConfigurationServiceException {
		List<CityDto> cityDtos = new ArrayList<>();
		cityRepository.getCities(countryisocode, stateid,true).iterator().forEachRemaining(city -> cityDtos.add(city.toCityDto()));
		return cityDtos;
	}
	@Override
	public int createTax(TaxesDto taxesDto) throws ConfigurationServiceException {
		int pkid =0;
		Taxes taxes =null;
		taxes = new Taxes();
		taxes.setCountrycode(taxesDto.getCountrycode());
		taxes.setId(taxesDto.getId());
		taxes.setTaxname(taxesDto.getTaxname());
		taxes.setTaxtype(taxesDto.getTaxtype());
		taxes.setTaxvalue(taxesDto.getTaxvalue());
		pkid  = taxesRepository.save(taxes).getId();
		return pkid;
	}
	@Override
	public List<TaxesDto> gettaxes() throws ConfigurationServiceException {
		List<TaxesDto> taxesDtos = new ArrayList<>();
		taxesRepository.findAll().iterator().forEachRemaining(taxes -> taxesDtos.add(taxes.totTaxesDto()));
		return taxesDtos;
	}
	@Override
	public int createServicefees(ServicefeesDto servicefeesDto) throws ConfigurationServiceException {
		int pkid =0;
		Servicefees servicefees =null;
		servicefees = new Servicefees();
		servicefees.setDescription(servicefeesDto.getDescription());
		servicefees.setEndrange(servicefeesDto.getEndrange());
		servicefees.setFlatrate(servicefeesDto.getFlatrate());
		servicefees.setId(servicefeesDto.getId());
		servicefees.setPartnertype(servicefeesDto.getPartnertype());
		servicefees.setPaymentmode(servicefeesDto.getPaymentmode());
		servicefees.setPercentagevalue(servicefeesDto.getPercentagevalue());
		servicefees.setPriority(servicefeesDto.getPriority());
		servicefees.setRecievercountry(servicefeesDto.getRecievercountry());
		servicefees.setSendercountry(servicefeesDto.getSendercountry());
		servicefees.setServicetype(servicefeesDto.getServicetype());
		servicefees.setStartrange(servicefeesDto.getStartrange());
		servicefees.setTransactiontype(servicefeesDto.getTransactiontype());
		servicefees.setCurrencycode(servicefeesDto.getCurrencycode());
		pkid = servicefeesRepository.save(servicefees).getId();
		return pkid;
	}
	@Override
	public List<ServicefeesDto> getServicefees() throws ConfigurationServiceException {
		List<ServicefeesDto> servicefeesDtos = new ArrayList<>();
		servicefeesRepository.findAll().iterator().forEachRemaining(servicefees -> servicefeesDtos.add(servicefees.tosServicefeesDto()));
		return servicefeesDtos;
	}
	@Override
	public List<CurrencyDto> allCurrency() throws ConfigurationServiceException {
		List<CurrencyDto> currencyDtos = new ArrayList<>();
		currencyRepository.findAll().iterator().forEachRemaining(currency -> currencyDtos.add(currency.toCurrencyDto()));
		return currencyDtos;
	}
	@Override
	public ServicefeesDto serviceRate(ServicefeesDto servicefeesDto)  {
		// TODO Auto-generated method stub
		
		ServicefeesDto servicefeesDtos =null;
		try {
		servicefeesDtos = new ServicefeesDto();
		servicefeesDtos =servicefeesRepository.searchByParams(servicefeesDto.getPartnertype(),servicefeesDto.getTransactiontype(),
				servicefeesDto.getPaymentmode(),servicefeesDto.getSendercountry(),servicefeesDto.getRecievercountry(),
				servicefeesDto.getCurrencycode(),servicefeesDto.getAmount()).tosServicefeesDto();
		return servicefeesDtos;
		}catch(Exception e) {
			return servicefeesDtos;
		}
		
		
	}
	@Override
	public TaxesDto taxesforCountry(String countryiso)throws ConfigurationServiceException {
		TaxesDto taxesDto =null;
		taxesDto = new TaxesDto();
		try {
		taxesDto =taxesRepository.findByCountry(countryiso).totTaxesDto();
		return taxesDto;
		}catch(Exception e) {
			return null;
		}
	}
	
	
}
