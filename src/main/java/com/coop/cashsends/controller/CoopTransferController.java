package com.coop.cashsends.controller;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
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
import com.coop.cashsends.dto.BanksDto;
import com.coop.cashsends.dto.CancelReasonDto;
import com.coop.cashsends.dto.CityDto;
import com.coop.cashsends.dto.ComplaintsAndPetitionsDto;
import com.coop.cashsends.dto.ComplaintsDto;
import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.dto.ExchangeRatesDto;
import com.coop.cashsends.dto.FormOfPaymentsDto;
import com.coop.cashsends.dto.PayerDetailsDto;
import com.coop.cashsends.dto.PayerDto;
import com.coop.cashsends.dto.PayerErrorCodesDto;
import com.coop.cashsends.dto.PayerRecieverIDDto;
import com.coop.cashsends.dto.PayerRemittanceDto;
import com.coop.cashsends.dto.PaymentModesDto;
import com.coop.cashsends.dto.RecieverCurrencyDto;
import com.coop.cashsends.dto.SenderTypesDto;
import com.coop.cashsends.dto.StateDto;
import com.coop.cashsends.dto.TownDto;
import com.coop.cashsends.exception.CoopTransferException;
import com.coop.cashsends.exception.ResourceNotFoundException;
import com.coop.cashsends.service.CoopTransferService;

@RestController
@RequestMapping("api/cooptransfer")
public class CoopTransferController {
	
	public static final String SUCCESS = "success";
	public static final String ROLE_COUNTRY_MANAGER = "ROLE_COUNTRY_MANAGER";
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_PARTNER = "ROLE_PARTNER";
	public static final String ROLE_TELLER = "ROLE_TELLER";
	
	@Autowired
    private CoopTransferService coopTransferService;
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "countries")
	@CrossOrigin
	public ApiResponse countries(@RequestBody CountryDto countryDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateCountry(countryDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "countries")
	@CrossOrigin
	public ApiResponse getcountries() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getCountries());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "activecountries")
	@CrossOrigin
	public ApiResponse getactivecountries() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getActiveCountries());
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "states")
	@CrossOrigin
	public ApiResponse states(@RequestBody StateDto stateDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateState(stateDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allstates")
	@CrossOrigin
	public ApiResponse getstates() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allStates());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "states/{CountryIsoCode}")
	@CrossOrigin
	public ApiResponse getstates(@PathVariable String CountryIsoCode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getStates(CountryIsoCode));
	}

	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "cities")
	@CrossOrigin
	public ApiResponse cities(@RequestBody CityDto cityDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateCities(cityDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allcities")
	@CrossOrigin
	public ApiResponse allcities() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allCities());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "cities/{CountryIsoCode}/{StateId}")
	@CrossOrigin
	public ApiResponse getcities(@PathVariable String CountryIsoCode,@PathVariable String StateId) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getCities(CountryIsoCode,StateId));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "citiesbystate/{StateId}")
	@CrossOrigin
	public ApiResponse getcitiesbystate(@PathVariable String StateId) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getcitiesbystate(StateId));
	}

	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "towns")
	@CrossOrigin
	public ApiResponse towns(@RequestBody TownDto townDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.towns(townDto));
	}
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "alltowns")
	@CrossOrigin
	public ApiResponse alltowns() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allTowns());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "towns/{CountryIsoCode}/{StateId}/{cityid}")
	@CrossOrigin
	public ApiResponse gettowns(@PathVariable String CountryIsoCode,@PathVariable String StateId,@PathVariable Integer cityid) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getTowns(CountryIsoCode,StateId,cityid));
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "townsbycity/{cityid}")
	@CrossOrigin
	public ApiResponse getTownsbycity(@PathVariable Integer cityid) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getTownsbycity(cityid));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "paymentmodes")
	@CrossOrigin
	public ApiResponse paymentmodes(@RequestBody PaymentModesDto paymentModesDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdatePaymenModes(paymentModesDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allpaymentmodes")
	@CrossOrigin
	public ApiResponse allpaymentmodes() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allpaymentmodes());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "paymentmodes/{CountryIsoCode}/{CityId}")
	@CrossOrigin
	public ApiResponse getpaymentModes(@PathVariable String CountryIsoCode,@PathVariable Integer CityId) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getPaymentModes(CountryIsoCode,CityId));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "banks")
	@CrossOrigin
	public ApiResponse banks(@RequestBody BanksDto banksDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateBanks(banksDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allbanks")
	@CrossOrigin
	public ApiResponse allbanks() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allbanks());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "banks/{CountryIsoCode}")
	@CrossOrigin
	public ApiResponse getbanks(@PathVariable String CountryIsoCode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getBanks(CountryIsoCode));
	}

	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "sendertypes")
	@CrossOrigin
	public ApiResponse sendertypes(@RequestBody SenderTypesDto SenderTypesDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateSenderTypes(SenderTypesDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allsendertypes")
	@CrossOrigin
	public ApiResponse allsendertypes() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allsendertypes());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "sendertypes/{CountryIsoCode}")
	@CrossOrigin
	public ApiResponse getsendertypes(@PathVariable String CountryIsoCode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getSendertypes(CountryIsoCode));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "recievercurrency")
	@CrossOrigin
	public ApiResponse recieverCurrency(@RequestBody RecieverCurrencyDto recieverCurrencyDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateRecieverCurrency(recieverCurrencyDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allrecievercurrency")
	@CrossOrigin
	public ApiResponse allrecievercurrency() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allrecievercurrency());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "recievercurrency/{CountryIsoCode}/{StateId}/{CityId}/{PaymentModeId}")
	@CrossOrigin
	public ApiResponse getrecieverCurrency(@PathVariable String CountryIsoCode,@PathVariable String StateId,@PathVariable Integer CityId,@PathVariable String PaymentModeId) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getrecieverCurrency(CountryIsoCode,StateId,CityId,PaymentModeId));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "payer")
	@CrossOrigin
	public ApiResponse payer(@RequestBody PayerDto payerDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdatePayer(payerDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allpayer")
	@CrossOrigin
	public ApiResponse allpayer() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allpayer());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "payer/{CountryIsoCode}/{CityId}/{PaymentModeId}/{RecieverCurrencyIsoCode}/{SenderCurrencyIsoCode}")
	@CrossOrigin
	public ApiResponse getpayer(@PathVariable String CountryIsoCode,@PathVariable Integer CityId,@PathVariable String PaymentModeId,
			@PathVariable String RecieverCurrencyIsoCode,@PathVariable String SenderCurrencyIsoCode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getpayers(CountryIsoCode,CityId,PaymentModeId,RecieverCurrencyIsoCode,SenderCurrencyIsoCode));
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "payerbytown/{CountryIsoCode}/{CityId}/{PaymentModeId}/{RecieverCurrencyIsoCode}/{SenderCurrencyIsoCode}/{TownId}")
	@CrossOrigin
	public ApiResponse getpayerbyTown(@PathVariable String CountryIsoCode,@PathVariable Integer CityId,@PathVariable String PaymentModeId,
			@PathVariable String RecieverCurrencyIsoCode,@PathVariable String SenderCurrencyIsoCode,@PathVariable Integer TownId) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getpayerbyTown(CountryIsoCode,CityId,PaymentModeId,RecieverCurrencyIsoCode,SenderCurrencyIsoCode,TownId));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "payerdetails")
	@CrossOrigin
	public ApiResponse payerdetails(@RequestBody PayerDetailsDto payerDetailsDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdatePayerDetails(payerDetailsDto));
	}
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allpayerdetails")
	@CrossOrigin
	public ApiResponse allpayerdetails() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allpayerdetails());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "payerdetails/{PayerId}")
	@CrossOrigin
	public ApiResponse getpayerdetails(@PathVariable Integer PayerId) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getpayerDetails(PayerId));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "cancelreason")
	@CrossOrigin
	public ApiResponse cancelreason(@RequestBody CancelReasonDto cancelReasonDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdatecancelReason(cancelReasonDto));
	}
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allcancelreason")
	@CrossOrigin
	public ApiResponse allcancelreason() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allcancelreason());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "cancelreason")
	@CrossOrigin
	public ApiResponse getcancelreason() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getcancelreason());
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "complaints")
	@CrossOrigin
	public ApiResponse complaints(@RequestBody ComplaintsDto complaintsDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateComplaints(complaintsDto));
	}
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allcomplaints")
	@CrossOrigin
	public ApiResponse allcomplaints() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allcomplaints());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "complaints")
	@CrossOrigin
	public ApiResponse getcomplaints() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getcomplaints());
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "exchangerates")
	@CrossOrigin
	public ApiResponse exchangerates(@RequestBody ExchangeRatesDto exchangeRatesDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.createorUpdateexchangeRates(exchangeRatesDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allexchangerates")
	@CrossOrigin
	public ApiResponse allexchangerates() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allexchangerates());
	}
	
	//@Secured({ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "exchangerates/{sourcecurrencycode}/{destinationcurrencycode}")
	@CrossOrigin
	public ApiResponse getexchangerates(@PathVariable String sourcecurrencycode,@PathVariable String destinationcurrencycode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getexchangerates(sourcecurrencycode,destinationcurrencycode));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "formofpayments")
	@CrossOrigin
	public ApiResponse formofpayments(@RequestBody FormOfPaymentsDto formOfPaymentsDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.formofpayments(formOfPaymentsDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allformsofpayments")
	@CrossOrigin
	public ApiResponse allformsofpayments() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allformsofpayments());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "formofpayments")
	@CrossOrigin
	public ApiResponse getformofpayments() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getformofpayments());
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "errorcodes")
	@CrossOrigin
	public ApiResponse errorcodes(@RequestBody PayerErrorCodesDto payerErrorCodesDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.errorcodes(payerErrorCodesDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allerrorcodes")
	@CrossOrigin
	public ApiResponse allerrorcodes() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allerrorcodes());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "errorcodes")
	@CrossOrigin
	public ApiResponse geterrorcodes() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.geterrorcodes());
	}
	
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "complaintspettions")
	@CrossOrigin
	public ApiResponse complaintspettions(@RequestBody ComplaintsAndPetitionsDto complaintsAndPetitionsDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.complaintspettions(complaintsAndPetitionsDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allcomplaintspettions")
	@CrossOrigin
	public ApiResponse allcomplaintspettions() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allcomplaintspettions());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "complaintspettions")
	@CrossOrigin
	public ApiResponse getcomplaintspettions() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getcomplaintspettions());
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "recieverids")
	@CrossOrigin
	public ApiResponse payerrecieverids(@RequestBody PayerRecieverIDDto payerRecieverIDDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.payerrecieverids(payerRecieverIDDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allrecieverids")
	@CrossOrigin
	public ApiResponse allrecieverids() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allrecieverids());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "recieverids/{CountryIsoCode}")
	@CrossOrigin
	public ApiResponse getrecieverids(@PathVariable String CountryIsoCode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getrecieverids(CountryIsoCode));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "remittances")
	@CrossOrigin
	public ApiResponse remittances(@RequestBody PayerRemittanceDto payerRemittanceDto) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.remittances(payerRemittanceDto));
	}
	
	//@Secured({ROLE_ADMIN})
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "allremittances")
	@CrossOrigin
	public ApiResponse allremittances() throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.allremittances());
	}
	
	//@Secured({ROLE_ADMIN,ROLE_PARTNER,ROLE_TELLER,ROLE_COUNTRY_MANAGER})
	@PreAuthorize("hasRole('ADMIN') or hasRole('TELLER') or hasRole('PARTNER') or hasRole('COUNTRY_MANAGER')")
	@GetMapping(value = "remittances/{CountryIsoCode}")
	@CrossOrigin
	public ApiResponse getallremittances(@PathVariable String CountryIsoCode) throws ResourceNotFoundException, CoopTransferException, JSONException{
	    return new ApiResponse(HttpStatus.OK, SUCCESS, coopTransferService.getallremittances(CountryIsoCode));
	}
	

}
