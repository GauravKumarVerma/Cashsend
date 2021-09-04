package com.coop.cashsends.service;

import java.util.List;

import org.json.JSONException;

import com.coop.cashsends.dto.CityDto;
import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.dto.CurrencyDto;
import com.coop.cashsends.dto.LocationDto;
import com.coop.cashsends.dto.ServicefeesDto;
import com.coop.cashsends.dto.StateDto;
import com.coop.cashsends.dto.TaxesDto;
import com.coop.cashsends.dto.TransfastDto;
import com.coop.cashsends.dto.TransfastResponseDto;
import com.coop.cashsends.exception.ConfigurationServiceException;

public interface ConfigurationService  {
 
	TransfastResponseDto transfastmasters(TransfastDto transfastDto) throws JSONException, ConfigurationServiceException;
    int createLocations(LocationDto locationDto)throws ConfigurationServiceException;
   List<LocationDto> getLocations(Integer partnerid)throws ConfigurationServiceException;
   List<CountryDto> countries()throws ConfigurationServiceException;
   List<StateDto> states(String countryisocode)throws ConfigurationServiceException;
   List<CityDto> cities(String countryisocode, String stateid)throws ConfigurationServiceException;
   int createTax(TaxesDto taxesDto)throws ConfigurationServiceException;
   List<TaxesDto> gettaxes()throws ConfigurationServiceException;
   int createServicefees(ServicefeesDto servicefeesDto)throws ConfigurationServiceException;
   List<ServicefeesDto> getServicefees()throws ConfigurationServiceException;
   List<CurrencyDto> allCurrency()throws ConfigurationServiceException;
   ServicefeesDto serviceRate(ServicefeesDto servicefeesDto)throws ConfigurationServiceException;
   TaxesDto taxesforCountry(String countryiso) throws ConfigurationServiceException;

}
