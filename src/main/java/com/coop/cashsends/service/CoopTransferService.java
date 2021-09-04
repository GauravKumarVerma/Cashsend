package com.coop.cashsends.service;

import java.util.List;

import org.json.JSONException;

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

public interface CoopTransferService {

	int createorUpdateCountry(CountryDto countryDto) throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CountryDto> getCountries()throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdateState(StateDto stateDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<StateDto> getStates(String countryIsoCode)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdateCities(CityDto cityDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CityDto> getCities(String countryIsoCode, String stateId)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int towns(TownDto townDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<TownDto> getTowns(String countryIsoCode, String stateId, Integer cityid)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdatePaymenModes(PaymentModesDto paymentModesDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PaymentModesDto> getPaymentModes(String countryIsoCode, Integer cityId)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdateBanks(BanksDto banksDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<BanksDto> getBanks(String countryIsoCode)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdateSenderTypes(SenderTypesDto senderTypesDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<SenderTypesDto> getSendertypes(String countryIsoCode)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<RecieverCurrencyDto> getrecieverCurrency(String countryIsoCode, String stateId, Integer cityId, String paymentModeId)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdateRecieverCurrency(RecieverCurrencyDto recieverCurrencyDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdatePayer(PayerDto payerDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerDto> getpayers(String countryIsoCode, Integer cityId, String paymentModeId,
			String recieverCurrencyIsoCode, String senderCurrencyIsoCode)throws ResourceNotFoundException, CoopTransferException, JSONException;
	
	List<PayerDto> allpayer()throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdatePayerDetails(PayerDetailsDto payerDetailsDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerDetailsDto> getpayerDetails(Integer payerId)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CountryDto> getActiveCountries()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<StateDto> allStates()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CityDto> allCities()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<TownDto> allTowns()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PaymentModesDto> allpaymentmodes()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<BanksDto> allbanks()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<SenderTypesDto> allsendertypes()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<RecieverCurrencyDto> allrecievercurrency()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerDetailsDto> allpayerdetails()throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdatecancelReason(CancelReasonDto cancelReasonDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CancelReasonDto> allcancelreason()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CancelReasonDto> getcancelreason()throws ResourceNotFoundException, CoopTransferException, JSONException;
 
	int createorUpdateComplaints(ComplaintsDto complaintsDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<ComplaintsDto> allcomplaints()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<ComplaintsDto>  getcomplaints()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<CityDto> getcitiesbystate(String stateId)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<TownDto> getTownsbycity(Integer cityid) throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerDto> getpayerbyTown(String countryIsoCode, Integer cityId, String paymentModeId, String recieverCurrencyIsoCode,
			String senderCurrencyIsoCode, Integer townId)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int createorUpdateexchangeRates(ExchangeRatesDto exchangeRatesDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<ExchangeRatesDto> allexchangerates()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<ExchangeRatesDto> getexchangerates(String sourcecurrencycode, String destinationcurrencycode)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int formofpayments(FormOfPaymentsDto formOfPaymentsDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<FormOfPaymentsDto> allformsofpayments()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<FormOfPaymentsDto>  getformofpayments()throws ResourceNotFoundException, CoopTransferException, JSONException;

	 int errorcodes(PayerErrorCodesDto payerErrorCodesDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerErrorCodesDto> allerrorcodes()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerErrorCodesDto> geterrorcodes()throws ResourceNotFoundException, CoopTransferException, JSONException;

	int complaintspettions(ComplaintsAndPetitionsDto complaintsAndPetitionsDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<ComplaintsAndPetitionsDto> allcomplaintspettions()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<ComplaintsAndPetitionsDto> getcomplaintspettions()throws ResourceNotFoundException, CoopTransferException, JSONException;

	int payerrecieverids(PayerRecieverIDDto payerRecieverIDDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerRecieverIDDto> allrecieverids()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerRecieverIDDto> getrecieverids(String CountryIsoCode)throws ResourceNotFoundException, CoopTransferException, JSONException;

	int remittances(PayerRemittanceDto payerRemittanceDto)throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerRemittanceDto> allremittances()throws ResourceNotFoundException, CoopTransferException, JSONException;

	List<PayerRemittanceDto> getallremittances(String countryIsoCode)throws ResourceNotFoundException, CoopTransferException, JSONException;

			
	

}
