package com.coop.cashsends.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coop.cashsends.dto.BanksDto;
import com.coop.cashsends.dto.CancelReasonDto;
import com.coop.cashsends.dto.CityDto;
import com.coop.cashsends.dto.ComplaintsAndPetitionsDto;
import com.coop.cashsends.dto.ComplaintsDto;
import com.coop.cashsends.dto.CountryDto;
import com.coop.cashsends.dto.ExchangeRatesDto;
import com.coop.cashsends.dto.FormOfPaymentsDto;
import com.coop.cashsends.dto.PartnerDto;
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
import com.coop.cashsends.model.Banks;
import com.coop.cashsends.model.CancelReason;
import com.coop.cashsends.model.City;
import com.coop.cashsends.model.Complaints;
import com.coop.cashsends.model.ComplaintsAndPetitions;
import com.coop.cashsends.model.Country;
import com.coop.cashsends.model.ExchangeRates;
import com.coop.cashsends.model.FormOfPayments;
import com.coop.cashsends.model.Partner;
import com.coop.cashsends.model.Payer;
import com.coop.cashsends.model.PayerDetails;
import com.coop.cashsends.model.PayerErrorCodes;
import com.coop.cashsends.model.PayerRecieverID;
import com.coop.cashsends.model.PayerRemittance;
import com.coop.cashsends.model.PaymentModes;
import com.coop.cashsends.model.RecieverCurrency;
import com.coop.cashsends.model.SenderTypes;
import com.coop.cashsends.model.State;
import com.coop.cashsends.model.Town;
import com.coop.cashsends.repository.BanksRepository;
import com.coop.cashsends.repository.CancelReasonRepository;
import com.coop.cashsends.repository.CityRepository;
import com.coop.cashsends.repository.ComplaintsAndPetitionsRepository;
import com.coop.cashsends.repository.ComplaintsRepository;
import com.coop.cashsends.repository.CountryRepository;
import com.coop.cashsends.repository.ExchangeRateRepository;
import com.coop.cashsends.repository.FormOfPaymentsRepository;
import com.coop.cashsends.repository.PartnerRepository;
import com.coop.cashsends.repository.PayerDetailsRepository;
import com.coop.cashsends.repository.PayerErrorCodesRepository;
import com.coop.cashsends.repository.PayerRecieverIDRepository;
import com.coop.cashsends.repository.PayerRemittanceRepository;
import com.coop.cashsends.repository.PayerRepository;
import com.coop.cashsends.repository.PaymentModesRepository;
import com.coop.cashsends.repository.RecieverCurrencyRepository;
import com.coop.cashsends.repository.SenderTypesRepository;
import com.coop.cashsends.repository.StateRepository;
import com.coop.cashsends.repository.TownRepository;
import com.coop.cashsends.service.CoopTransferService;

@Transactional
@Service(value = "coopTransferService")
public class CoopTransferServiceImpl implements CoopTransferService{

	@Autowired
	 private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private TownRepository townRepository;
	
	@Autowired
	private RecieverCurrencyRepository recieverCurrencyRepository;
	
	@Autowired
	private PaymentModesRepository paymentModesRepository;
	
	@Autowired
	private BanksRepository banksRepository;
	
	@Autowired
	private SenderTypesRepository senderTypesRepository;
	
	@Autowired
	private PayerRepository payerRepository;
	
	@Autowired
	private PayerDetailsRepository payerDetailsRepository;
	
	@Autowired
	private CancelReasonRepository cancelReasonRepository;
	
	@Autowired
	private ComplaintsRepository complaintsRepository;
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private ExchangeRateRepository exchangeRateRepository;
	
	@Autowired
	private FormOfPaymentsRepository formOfPaymentsRepository;
	
	@Autowired
	private PayerRecieverIDRepository  payerRecieverIDRepository;
	
	@Autowired
	private PayerErrorCodesRepository payerErrorCodesRepository;
	
	@Autowired
	private PayerRemittanceRepository payerRemittanceRepository;
	
	@Autowired
	private ComplaintsAndPetitionsRepository complaintsAndPetitionsRepository;
	
	
	@Override
	public int createorUpdateCountry(CountryDto countryDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
	  Country country =null;
	  country = new Country();
	  country.setId(countryDto.getId());
	  country.setHasTown(countryDto.getHasTown());
	  country.setIsoCode(countryDto.getIsoCode());
	  country.setName(countryDto.getName());
	  country.setStatus(countryDto.isStatus());
	  
		return countryRepository.save(country).getId();
	}

	@Override
	public List<CountryDto> getCountries() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CountryDto> countryDtos = new ArrayList<>();
		countryRepository.findAll().iterator().forEachRemaining(country -> countryDtos.add(country.toCountryDto()));
		return countryDtos;
	}
	
	@Override
	public List<CountryDto> getActiveCountries()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CountryDto> countryDtos = new ArrayList<>();
		countryRepository.findActiveCountries(true).iterator().forEachRemaining(country -> countryDtos.add(country.toCountryDto()));
		return countryDtos;
	}

	@Override
	public int createorUpdateState(StateDto stateDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		State state =null;
		state = new State();
		state.setCountryIsoCode(stateDto.getCountryIsoCode());
		state.setId(stateDto.getId());
		state.setStateIsoCode(stateDto.getStateIsoCode());
		state.setStateName(stateDto.getStateName());
		state.setStatus(stateDto.isStatus());
		Country country = null;
		country = countryRepository.findbyCountryCode(stateDto.getCountryIsoCode());
		state.setCountryName(country.getName());
		return stateRepository.save(state).getId();
	}

	@Override
	public List<StateDto> getStates(String countryIsoCode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<StateDto> statesDtos = new ArrayList<>();
		stateRepository.getstates(countryIsoCode,true).iterator().forEachRemaining(state -> statesDtos.add(state.toStateDto()));
		return statesDtos;
	}
	
	@Override
	public List<StateDto> allStates() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<StateDto> statesDtos = new ArrayList<>();
		stateRepository.findAll().iterator().forEachRemaining(state -> statesDtos.add(state.toStateDto()));
		return statesDtos;
	}


	@Override
	public int createorUpdateCities(CityDto cityDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		City city =null;
		city = new City();
		city.setCountryIsoCode(cityDto.getCountryIsoCode());
		city.setId(cityDto.getId());
		city.setCityName(cityDto.getCityName());
		city.setStateId(cityDto.getStateId());
		city.setStatus(cityDto.isStatus());
		Country country = null;
		country = countryRepository.findbyCountryCode(cityDto.getCountryIsoCode());
		city.setCountryName(country.getName());
		State state = null;
		state = stateRepository.findById(Integer.parseInt(cityDto.getStateId())).get();
		city.setStateName(state.getStateName());
		return cityRepository.save(city).getId();
	}

	@Override
	public List<CityDto> allCities() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CityDto> cityDtos = new ArrayList<>();
		cityRepository.findAll().iterator().forEachRemaining(city -> cityDtos.add(city.toCityDto()));
		return cityDtos;
	}
	@Override
	public List<CityDto> getCities(String countryIsoCode, String stateId)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CityDto> cityDtos = new ArrayList<>();
		cityRepository.getCities(countryIsoCode, stateId,true).iterator().forEachRemaining(city -> cityDtos.add(city.toCityDto()));
		return cityDtos;
	}
	
	@Override
	public List<CityDto> getcitiesbystate(String stateId)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CityDto> cityDtos = new ArrayList<>();
		cityRepository.getcitiesbystate(stateId,true).iterator().forEachRemaining(city -> cityDtos.add(city.toCityDto()));
		return cityDtos;
	}


	@Override
	public int towns(TownDto townDto) throws ResourceNotFoundException, CoopTransferException, JSONException {
		Town town = null;
		town = new Town();
		town.setCityId(townDto.getCityId());
		town.setCountryIsoCode(townDto.getCountryIsoCode());
		town.setId(townDto.getId());
		town.setStateId(townDto.getStateId());
		town.setStatus(townDto.isStatus());
		town.setTownName(townDto.getTownName());
		Country country = null;
		country = countryRepository.findbyCountryCode(townDto.getCountryIsoCode());
		town.setCountryName(country.getName());
		State state = null;
		state = stateRepository.findById(Integer.parseInt(townDto.getStateId())).get();
		town.setStateName(state.getStateName());
		City city = null;
		city =cityRepository.findById(townDto.getCityId()).get();
		town.setCityName(city.getCityName());
		return townRepository.save(town).getId();
	}
	
	@Override
	public List<TownDto> allTowns() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<TownDto> townDtos = new ArrayList<>();
		townRepository.findAll().iterator().forEachRemaining(town -> townDtos.add(town.toTownDto()));
		return townDtos;
	}


	@Override
	public List<TownDto> getTowns(String countryIsoCode, String stateId, Integer cityid)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<TownDto> townDtos = new ArrayList<>();
		townRepository.gettowns(countryIsoCode, stateId,cityid,true).iterator().forEachRemaining(town -> townDtos.add(town.toTownDto()));
		return townDtos;
	}
	
	@Override
	public List<TownDto> getTownsbycity(Integer cityid)throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<TownDto> townDtos = new ArrayList<>();
		townRepository.getTownsbycity(cityid,true).iterator().forEachRemaining(town -> townDtos.add(town.toTownDto()));
		return townDtos;
	}


	@Override
	public int createorUpdatePaymenModes(PaymentModesDto paymentModesDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		PaymentModes paymentModes = null;
		paymentModes  = new PaymentModes();
		paymentModes.setCityId(paymentModesDto.getCityId());
		paymentModes.setCountryIsoCode(paymentModesDto.getCountryIsoCode());
		paymentModes.setId(paymentModesDto.getId());
		paymentModes.setModeName(paymentModesDto.getModeName());
		paymentModes.setRequiredAccount(paymentModesDto.getRequiredAccount());
		paymentModes.setRequiredBank(paymentModesDto.getRequiredBank());
		paymentModes.setStatus(paymentModesDto.isStatus());
		paymentModes.setStateId(paymentModesDto.getStateId());
		Country country = null;
		country = countryRepository.findbyCountryCode(paymentModesDto.getCountryIsoCode());
		paymentModes.setCountryName(country.getName());
		State state = null;
		state = stateRepository.findById(Integer.parseInt(paymentModesDto.getStateId())).get();
		paymentModes.setStateName(state.getStateName());
		City city = null;
		city =cityRepository.findById(paymentModesDto.getCityId()).get();
		paymentModes.setCityName(city.getCityName());
		
		return paymentModesRepository.save(paymentModes).getId();
	}
	
	@Override
	public List<PaymentModesDto> allpaymentmodes()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PaymentModesDto> paymentModesDtos = new ArrayList<>();
		paymentModesRepository.findAll().iterator().forEachRemaining(paymentmodes -> paymentModesDtos.add(paymentmodes.toPaymentModesDto()));
		return paymentModesDtos;
	}


	@Override
	public List<PaymentModesDto> getPaymentModes(String countryIsoCode, Integer cityId)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PaymentModesDto> paymentModesDtos = new ArrayList<>();
		paymentModesRepository.getPaymentModes(countryIsoCode,cityId,true).iterator().forEachRemaining(paymentmodes -> paymentModesDtos.add(paymentmodes.toPaymentModesDto()));
		return paymentModesDtos;
	}

	@Override
	public int createorUpdateBanks(BanksDto banksDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
	 Banks banks = null;
	 banks = new Banks();
	 banks.setBankId(banksDto.getBankId());
	 banks.setBankName(banksDto.getBankName());
	 banks.setCountryIsoCode(banksDto.getCountryIsoCode());
	 banks.setId(banksDto.getId());
	 banks.setStatus(banksDto.isStatus());
	 Country country = null;
     country = countryRepository.findbyCountryCode(banksDto.getCountryIsoCode());
	 banks.setCountryName(country.getName());
	 return banksRepository.save(banks).getId();
	}

	@Override
	public List<BanksDto> allbanks() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<BanksDto> banksDtos = new ArrayList<>();
		banksRepository.findAll().iterator().forEachRemaining(banks -> banksDtos.add(banks.toBanksDto()));
		return banksDtos;
	}

	@Override
	public List<BanksDto> getBanks(String countryIsoCode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<BanksDto> banksDtos = new ArrayList<>();
		banksRepository.getbanks(countryIsoCode,true).iterator().forEachRemaining(banks -> banksDtos.add(banks.toBanksDto()));
		return banksDtos;
	}

	@Override
	public int createorUpdateSenderTypes(SenderTypesDto senderTypesDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		SenderTypes sendertypes = null;
		sendertypes  = new SenderTypes();
		sendertypes.setComplianceCountryRequired(senderTypesDto.getComplianceCountryRequired());
		sendertypes.setComplianceStateRequired(senderTypesDto.getComplianceStateRequired());
		sendertypes.setCountryIsoCode(senderTypesDto.getCountryIsoCode());
		sendertypes.setId(senderTypesDto.getId());
		sendertypes.setSenderName(senderTypesDto.getSenderName());
		Country country = null;
	    country = countryRepository.findbyCountryCode(senderTypesDto.getCountryIsoCode());
		sendertypes.setCountryName(country.getName());
		sendertypes.setStatus(senderTypesDto.isStatus());
		return senderTypesRepository.save(sendertypes).getId();
	}

	@Override
	public List<SenderTypesDto> allsendertypes()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<SenderTypesDto> senderTypesDtos = new ArrayList<>();
		senderTypesRepository.findAll().iterator().forEachRemaining(sendertypes -> senderTypesDtos.add(sendertypes.toSenderTypesDto()));
		return senderTypesDtos;
	}
	@Override
	public List<SenderTypesDto> getSendertypes(String countryIsoCode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<SenderTypesDto> senderTypesDtos = new ArrayList<>();
		senderTypesRepository.getSenderTypes(countryIsoCode,true).iterator().forEachRemaining(sendertypes -> senderTypesDtos.add(sendertypes.toSenderTypesDto()));
		return senderTypesDtos;
	}

	@Override
	public List<RecieverCurrencyDto> allrecievercurrency()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<RecieverCurrencyDto> recieverCurrencyDtos = new ArrayList<>();
		recieverCurrencyRepository.findAll().iterator().
		forEachRemaining(recieverCurrency -> recieverCurrencyDtos.add(recieverCurrency.toRecieverCurrencyDto()));
		return recieverCurrencyDtos;
	}
	@Override
	public List<RecieverCurrencyDto> getrecieverCurrency(String countryIsoCode, String stateId, Integer cityId, String paymentModeId)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<RecieverCurrencyDto> recieverCurrencyDtos = new ArrayList<>();
		recieverCurrencyRepository.getrecieverCurrency(countryIsoCode,Integer.parseInt(stateId),cityId,paymentModeId,true).iterator().
		forEachRemaining(recieverCurrency -> recieverCurrencyDtos.add(recieverCurrency.toRecieverCurrencyDto()));
		return recieverCurrencyDtos;
	}

	@Override
	public int createorUpdateRecieverCurrency(RecieverCurrencyDto recieverCurrencyDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		RecieverCurrency recieverCurrency = null;
		recieverCurrency = new RecieverCurrency();
		recieverCurrency.setCityId(recieverCurrencyDto.getCityId());
		recieverCurrency.setCountryIsoCode(recieverCurrencyDto.getCountryIsoCode());
		recieverCurrency.setCurrencyIsoCode(recieverCurrencyDto.getCurrencyIsoCode());
		recieverCurrency.setId(recieverCurrencyDto.getId());
		recieverCurrency.setIsPaymentCurrency(recieverCurrencyDto.isIsPaymentCurrency());
		recieverCurrency.setPaymentModeId(recieverCurrencyDto.getPaymentModeId());
		recieverCurrency.setStateId(recieverCurrencyDto.getStateId());
		recieverCurrency.setStatus(recieverCurrencyDto.isStatus());
		Country country = null;
		country = countryRepository.findbyCountryCode(recieverCurrencyDto.getCountryIsoCode());
		recieverCurrency.setCountryName(country.getName());
		State state = null;
		state = stateRepository.findById(recieverCurrencyDto.getStateId()).get();
		recieverCurrency.setStateName(state.getStateName());
		City city = null;
		city =cityRepository.findById(recieverCurrencyDto.getCityId()).get();
		recieverCurrency.setCityName(city.getCityName());
		
		Town town = null;
		if(recieverCurrencyDto.getTownId() !=null  && !recieverCurrencyDto.getTownId().equalsIgnoreCase("SELECT")) {
		Optional<Town> towns =townRepository.findById(Integer.parseInt(recieverCurrencyDto.getTownId()));
		if(towns.isPresent()) {
			town = towns.get();
		recieverCurrency.setTownName(town.getTownName());
		recieverCurrency.setTownId(recieverCurrencyDto.getTownId());
		
		}
		}
		
		
		return recieverCurrencyRepository.save(recieverCurrency).getId();
	}

	@Override
	public int createorUpdatePayer(PayerDto payerDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
	 Payer payer = null;
	 payer = new Payer();
	 payer.setCityId(payerDto.getCityId());
	 payer.setCountryIsoCode(payerDto.getCountryIsoCode());
	 payer.setId(payerDto.getId());
	 payer.setPayerId(payerDto.getPayerId());
	 payer.setPaymentModeId(payerDto.getPaymentModeId());
	 payer.setRecieverCurrencyIsoCode(payerDto.getRecieverCurrencyIsoCode());
	 payer.setSourceCurrencyIsoCode(payerDto.getSourceCurrencyIsoCode());
	 payer.setStateId(payerDto.getStateId());
	 payer.setStatus(payerDto.isStatus());
	 payer.setTownId(payerDto.getTownId());
	 Partner  partner =null;
	 partner =partnerRepository.partnerDetailsByUserId(payerDto.getPayerId());
	 payer.setPayerName(partner.getBusinessname());
	 Country country = null;
		country = countryRepository.findbyCountryCode(payerDto.getCountryIsoCode());
		payer.setCountryName(country.getName());
		State state = null;
		state = stateRepository.findById(payerDto.getStateId()).get();
		payer.setStateName(state.getStateName());
		City city = null;
		city =cityRepository.findById(payerDto.getCityId()).get();
		payer.setCityName(city.getCityName());
		
		Town town = null;
		Optional<Town> towns =townRepository.findById(payerDto.getTownId());
		if(towns.isPresent()) {
		town = towns.get();
		payer.setTownName(town.getTownName());
		}
		
		return payerRepository.save(payer).getId();
	}
	

	@Override
	public List<PayerDto> getpayers(String countryIsoCode, Integer cityId, String paymentModeId,
			String recieverCurrencyIsoCode, String senderCurrencyIsoCode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerDto> payerDtos = new ArrayList<>();
		payerRepository.getpayers(countryIsoCode,cityId,paymentModeId,recieverCurrencyIsoCode,senderCurrencyIsoCode,true).iterator().
		forEachRemaining(payer -> payerDtos.add(payer.toPayerDto()));
		return payerDtos;
	}

	@Override
	public List<PayerDto> allpayer() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerDto> payerDtos = new ArrayList<>();
		payerRepository.findAll().iterator().
		forEachRemaining(payer -> payerDtos.add(payer.toPayerDto()));
		return payerDtos;
	}

	@Override
	public List<PayerDto> getpayerbyTown(String countryIsoCode, Integer cityId, String paymentModeId,
			String recieverCurrencyIsoCode, String senderCurrencyIsoCode, Integer townId)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerDto> payerDtos = new ArrayList<>();
		payerRepository.getpayerbyTown(countryIsoCode,cityId,paymentModeId,recieverCurrencyIsoCode,senderCurrencyIsoCode,true,townId).iterator().
		forEachRemaining(payer -> payerDtos.add(payer.toPayerDto()));
		return payerDtos;
	}


	@Override
	public int createorUpdatePayerDetails(PayerDetailsDto payerDetailsDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		PayerDetails payerDetails =null;
		payerDetails = new PayerDetails();
		payerDetails.setBranchAddress(payerDetailsDto.getBranchAddress());
		payerDetails.setBranchId(payerDetailsDto.getBranchId());
		payerDetails.setBranchLevelRate(payerDetailsDto.getBranchLevelRate());
		payerDetails.setBranchName(payerDetailsDto.getBranchName());
		payerDetails.setCustomerRate(payerDetailsDto.getCustomerRate());
		payerDetails.setId(payerDetailsDto.getId());
		payerDetails.setIsAnywhere(payerDetailsDto.isIsAnywhere());
		payerDetails.setIsDefaultLocation(payerDetailsDto.isIsDefaultLocation());
		payerDetails.setIsOldPayer(payerDetailsDto.isIsOldPayer());
		payerDetails.setPayerId(payerDetailsDto.getPayerId());
		payerDetails.setPayerName(payerDetailsDto.getPayerName());
		payerDetails.setPayerRefId(payerDetailsDto.getPayerRefId());
		payerDetails.setStatus(payerDetailsDto.isStatus());
		return payerDetailsRepository.save(payerDetails).getId();
	}

	@Override
	public List<PayerDetailsDto> getpayerDetails(Integer payerId)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerDetailsDto> payerDetailsDtos = new ArrayList<>();
		payerDetailsRepository.findbyPayerid(payerId,true).iterator().
		forEachRemaining(payerDetails -> payerDetailsDtos.add(payerDetails.toPayerDetailsDto()));
		return payerDetailsDtos;
	}

	@Override
	public List<PayerDetailsDto> allpayerdetails()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerDetailsDto> payerDetailsDtos = new ArrayList<>();
		payerDetailsRepository.findAll().iterator().
		forEachRemaining(payerDetails -> payerDetailsDtos.add(payerDetails.toPayerDetailsDto()));
		return payerDetailsDtos;
	}

	@Override
	public int createorUpdatecancelReason(CancelReasonDto cancelReasonDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		CancelReason cancelReason = null;
		cancelReason = new CancelReason();
		cancelReason.setId(cancelReasonDto.getId());
		cancelReason.setReasonName(cancelReasonDto.getReasonName());
		cancelReason.setStatus(cancelReasonDto.isStatus());
		return cancelReasonRepository.save(cancelReason).getId();
	}

	@Override
	public List<CancelReasonDto> allcancelreason()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CancelReasonDto> cancelReasonDtos = new ArrayList<>();
		cancelReasonRepository.findAll().iterator().
		forEachRemaining(cancelReason -> cancelReasonDtos.add(cancelReason.toCancelReasonDto()));
		return cancelReasonDtos;
	}

	@Override
	public List<CancelReasonDto> getcancelreason()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<CancelReasonDto> cancelReasonDtos = new ArrayList<>();
		cancelReasonRepository.getActiveCancelReasons(true).iterator().
		forEachRemaining(cancelReason -> cancelReasonDtos.add(cancelReason.toCancelReasonDto()));
		return cancelReasonDtos;
	}

	@Override
	public int createorUpdateComplaints(ComplaintsDto complaintsDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
	Complaints complaints = null;
	complaints = new Complaints();
	complaints.setComplainttype(complaintsDto.getComplainttype());
	complaints.setId(complaintsDto.getId());	
	complaints.setPetitiontype(complaintsDto.getPetitiontype());
	complaints.setStatus(complaintsDto.isStatus());
		return complaintsRepository.save(complaints).getId();
	}

	@Override
	public List<ComplaintsDto> allcomplaints() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<ComplaintsDto> complaintsDtos = new ArrayList<>();
		complaintsRepository.findAll().iterator().
		forEachRemaining(complaints -> complaintsDtos.add(complaints.toComplaintsDto()));
		return complaintsDtos;
	}

	@Override
	public List<ComplaintsDto> getcomplaints() throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<ComplaintsDto> complaintsDtos = new ArrayList<>();
		complaintsRepository.getActiveComplaints(true).iterator().
		forEachRemaining(complaints -> complaintsDtos.add(complaints.toComplaintsDto()));
		return complaintsDtos;
	}

	@Override
	public int createorUpdateexchangeRates(ExchangeRatesDto exchangeRatesDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		ExchangeRates exchangeRates =null;
		exchangeRates = new ExchangeRates();
		exchangeRates.setId(exchangeRatesDto.getId());
		exchangeRates.setRate(exchangeRatesDto.getRate());
		exchangeRates.setSourceCurrencyCode(exchangeRatesDto.getSourceCurrencyCode());
		exchangeRates.setRecieverCurrencyCode(exchangeRatesDto.getRecieverCurrencyCode());
		exchangeRates.setStatus(exchangeRatesDto.isStatus());
		return exchangeRateRepository.save(exchangeRates).getId();
	}

	@Override
	public List<ExchangeRatesDto> allexchangerates()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<ExchangeRatesDto> exchangeRatesDtos = new ArrayList<>();
		exchangeRateRepository.findAll().iterator().
		forEachRemaining(exchangeRates -> exchangeRatesDtos.add(exchangeRates.toExchangeRatesDto()));
		return exchangeRatesDtos;
	}

	@Override
	public List<ExchangeRatesDto> getexchangerates(String sourcecurrencycode, String destinationcurrencycode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<ExchangeRatesDto> exchangeRatesDtos = new ArrayList<>();
		exchangeRateRepository.getExchangeRates(sourcecurrencycode, destinationcurrencycode, true).iterator().
		forEachRemaining(exchangeRates -> exchangeRatesDtos.add(exchangeRates.toExchangeRatesDto()));
		return exchangeRatesDtos;
	}

	@Override
	public int formofpayments(FormOfPaymentsDto formOfPaymentsDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		FormOfPayments formOfPayments = null;
		formOfPayments = new FormOfPayments();
		formOfPayments.setId(formOfPaymentsDto.getId());
		formOfPayments.setPaymentName(formOfPaymentsDto.getPaymentName());
		formOfPayments.setStatus(formOfPaymentsDto.isStatus());
		return formOfPaymentsRepository.save(formOfPayments).getId();
	}

	@Override
	public List<FormOfPaymentsDto> allformsofpayments()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<FormOfPaymentsDto> formOfPaymentsDtos = new ArrayList<>();
		formOfPaymentsRepository.findAll().iterator().
		forEachRemaining(formOfPayments -> formOfPaymentsDtos.add(formOfPayments.toFormOfPaymentsDto()));
		return formOfPaymentsDtos;
	}

	@Override
	public List<FormOfPaymentsDto> getformofpayments()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<FormOfPaymentsDto> formOfPaymentsDtos = new ArrayList<>();
		formOfPaymentsRepository.getactiveformsofpayments(true).iterator().
		forEachRemaining(formOfPayments -> formOfPaymentsDtos.add(formOfPayments.toFormOfPaymentsDto()));
		return formOfPaymentsDtos;
	}

	@Override
	public int errorcodes(PayerErrorCodesDto payerErrorCodesDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		PayerErrorCodes payerErrorCodes = null;
		payerErrorCodes = new  PayerErrorCodes();
		payerErrorCodes.setErrorCodes(payerErrorCodesDto.getErrorCodes());
		payerErrorCodes.setId(payerErrorCodesDto.getId());
		payerErrorCodes.setStatus(payerErrorCodesDto.isStatus());
		
		return payerErrorCodesRepository.save(payerErrorCodes).getId();
	}

	@Override
	public List<PayerErrorCodesDto> allerrorcodes()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerErrorCodesDto> payerErrorCodesDtos = new ArrayList<>();
		payerErrorCodesRepository.findAll().iterator().
		forEachRemaining(payerErrorCodes -> payerErrorCodesDtos.add(payerErrorCodes.toPayerErrorCodesDto()));
		return payerErrorCodesDtos;
	}

	@Override
	public List<PayerErrorCodesDto> geterrorcodes()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerErrorCodesDto> payerErrorCodesDtos = new ArrayList<>();
		payerErrorCodesRepository.findActiveErrorCodes(true).iterator().
		forEachRemaining(payerErrorCodes -> payerErrorCodesDtos.add(payerErrorCodes.toPayerErrorCodesDto()));
		return payerErrorCodesDtos;
	}

	@Override
	public int complaintspettions(ComplaintsAndPetitionsDto complaintsAndPetitionsDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		ComplaintsAndPetitions complaintsAndPetitions = null;
		complaintsAndPetitions = new ComplaintsAndPetitions();
		complaintsAndPetitions.setComplaintName(complaintsAndPetitionsDto.getComplaintName());
		complaintsAndPetitions.setId(complaintsAndPetitionsDto.getId());
		complaintsAndPetitions.setStatus(complaintsAndPetitionsDto.isStatus());
		return complaintsAndPetitionsRepository.save(complaintsAndPetitions).getId();
	}

	@Override
	public List<ComplaintsAndPetitionsDto> allcomplaintspettions()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<ComplaintsAndPetitionsDto> complaintsAndPetitionsDtos = new ArrayList<>();
		complaintsAndPetitionsRepository.findAll().iterator().
		forEachRemaining(complaintsAndPetitions -> complaintsAndPetitionsDtos.add(complaintsAndPetitions.toComplaintsAndPetitionsDto()));
		return complaintsAndPetitionsDtos;
	}

	@Override
	public List<ComplaintsAndPetitionsDto> getcomplaintspettions()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<ComplaintsAndPetitionsDto> complaintsAndPetitionsDtos = new ArrayList<>();
		complaintsAndPetitionsRepository.findActivePetitions(true).iterator().
		forEachRemaining(complaintsAndPetitions -> complaintsAndPetitionsDtos.add(complaintsAndPetitions.toComplaintsAndPetitionsDto()));
		return complaintsAndPetitionsDtos;
	}

	@Override
	public int payerrecieverids(PayerRecieverIDDto payerRecieverIDDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		PayerRecieverID payerRecieverID = null;
		payerRecieverID = new PayerRecieverID();
		payerRecieverID.setCountryIsoCode(payerRecieverIDDto.getCountryIsoCode());
		payerRecieverID.setId(payerRecieverIDDto.getId());
		payerRecieverID.setIdentifierName(payerRecieverIDDto.getIdentifierName());
		payerRecieverID.setStatus(payerRecieverIDDto.isStatus());
		Country country = null;
		country = countryRepository.findbyCountryCode(payerRecieverIDDto.getCountryIsoCode());
		payerRecieverID.setCountryName(country.getName());
		
		return payerRecieverIDRepository.save(payerRecieverID).getId();
	}

	@Override
	public List<PayerRecieverIDDto> allrecieverids()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerRecieverIDDto> payerRecieverIDDtos = new ArrayList<>();
		payerRecieverIDRepository.findAll().iterator().
		forEachRemaining(payerRecieverID -> payerRecieverIDDtos.add(payerRecieverID.toPayerRecieverIDDto()));
		return payerRecieverIDDtos;
	}

	@Override
	public List<PayerRecieverIDDto> getrecieverids(String CountryIsoCode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerRecieverIDDto> payerRecieverIDDtos = new ArrayList<>();
		payerRecieverIDRepository.findByCountryIsoCode(CountryIsoCode,true).iterator().
		forEachRemaining(payerRecieverID -> payerRecieverIDDtos.add(payerRecieverID.toPayerRecieverIDDto()));
		return payerRecieverIDDtos;
	}
	

	@Override
	public int remittances(PayerRemittanceDto payerRemittanceDto)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		PayerRemittance payerRemittance = null;	
		payerRemittance = new PayerRemittance();
		payerRemittance.setCountryIsoCode(payerRemittanceDto.getCountryIsoCode());
		payerRemittance.setId(payerRemittanceDto.getId());
		payerRemittance.setStatus(payerRemittanceDto.isStatus());
		payerRemittance.setRemittanceName(payerRemittanceDto.getRemittanceName());
		Country country = null;
		country = countryRepository.findbyCountryCode(payerRemittance.getCountryIsoCode());
		payerRemittance.setCountryName(country.getName());
		
		return payerRemittanceRepository.save(payerRemittance).getId();
	}

	@Override
	public List<PayerRemittanceDto> allremittances()
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerRemittanceDto> payerRemittanceDtos = new ArrayList<>();
		payerRemittanceRepository.findAll().iterator().
		forEachRemaining(payerRemittance -> payerRemittanceDtos.add(payerRemittance.toPayerRemittanceDto()));
		return payerRemittanceDtos;
	}
	

	@Override
	public List<PayerRemittanceDto> getallremittances(String countryIsoCode)
			throws ResourceNotFoundException, CoopTransferException, JSONException {
		List<PayerRemittanceDto> payerRemittanceDtos = new ArrayList<>();
		payerRemittanceRepository.findActiveRemittance(countryIsoCode,true).iterator().
		forEachRemaining(payerRemittance -> payerRemittanceDtos.add(payerRemittance.toPayerRemittanceDto()));
		return payerRemittanceDtos;
	}


	
	

}
