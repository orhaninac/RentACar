package com.orhaninac.RentACar.business.concretes;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.orhaninac.RentACar.business.abstracts.AdditionalServiceService;
import com.orhaninac.RentACar.business.abstracts.CarRentalService;
import com.orhaninac.RentACar.business.abstracts.CarService;
import com.orhaninac.RentACar.business.abstracts.OrderedAdditionalServiceService;
import com.orhaninac.RentACar.business.abstracts.PaymentService;
import com.orhaninac.RentACar.business.abstracts.PosAdapterService;
import com.orhaninac.RentACar.business.dtos.ListCarRentalDto;
import com.orhaninac.RentACar.business.dtos.ListPaymentDto;
import com.orhaninac.RentACar.business.request.CreatePaymentRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.PaymentDao;
import com.orhaninac.RentACar.entities.concretes.Payment;

public class PaymentManager implements PaymentService {
	
	private ModelMapperService modelMapperService;
	private PaymentDao paymentDao;
	private CarRentalService carRentalService;
	private CarService carService;
	private AdditionalServiceService additionalServiceItemService;
	private OrderedAdditionalServiceService orderedAdditionalServiceService;
	private PosAdapterService posAdapterService;
	

	public PaymentManager(ModelMapperService modelMapperService, PaymentDao paymentDao,
			CarRentalService carRentalService, CarService carService,
			AdditionalServiceService additionalServiceItemService,
			OrderedAdditionalServiceService orderedAdditionalServiceService, PosAdapterService posAdapterService) {
		super();
		this.modelMapperService = modelMapperService;
		this.paymentDao = paymentDao;
		this.carRentalService = carRentalService;
		this.carService = carService;
		this.additionalServiceItemService = additionalServiceItemService;
		this.orderedAdditionalServiceService = orderedAdditionalServiceService;
		this.posAdapterService = posAdapterService;
	}

	@Override
	public Result add(CreatePaymentRequest createPaymentRequest) {


		ListCarRentalDto rental = carRentalService.getById(createPaymentRequest.getRentalId()).getData();

		double totalPrice = 0.0;


		this.posAdapterService.makePayment(createPaymentRequest.getCardNo(), createPaymentRequest.getCcv(), totalPrice);

		Payment payment = this.modelMapperService.forRequest().map(createPaymentRequest, Payment.class);
		payment.setTotalPrice(totalPrice);

		payment.setPaymentId(0);
		this.paymentDao.save(payment);

		return new SuccessResult("Payment Done");
	}

	@Override
	public Result delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListPaymentDto>> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
