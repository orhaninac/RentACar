package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.OrderedAdditionalServiceService;
import com.orhaninac.RentACar.business.dtos.GetOrderedAdditionalService;
import com.orhaninac.RentACar.business.dtos.ListOrderedAdditionalServiceDto;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorDataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.OrderedAdditionalServiceDao;
import com.orhaninac.RentACar.entities.concretes.OrderedAdditionalService;

@Service
public class OrderedAdditionalServiceManager  implements OrderedAdditionalServiceService{
	
	private OrderedAdditionalServiceDao orderedAdditionalServiceDao;

	private ModelMapperService modelMapperService;

	public OrderedAdditionalServiceManager(OrderedAdditionalServiceDao orderedAdditionalServiceDao,
			ModelMapperService modelMapperService) {
		super();
		this.orderedAdditionalServiceDao = orderedAdditionalServiceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public Result delete(int id) {
		this.orderedAdditionalServiceDao.deleteById(id);
		return new SuccessResult("Deleted successfully.");
	}



	@Override
	public DataResult<GetOrderedAdditionalService> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<ListOrderedAdditionalServiceDto>> getAll() {
	       List<OrderedAdditionalService> result = this.orderedAdditionalServiceDao.findAll();

	        if (result.isEmpty()) {
	            return new ErrorDataResult<List<ListOrderedAdditionalServiceDto>>("OrderedAdditionalService not listed");
	        }

	        List<ListOrderedAdditionalServiceDto> response = result.stream().map(orderedAdditionalService -> this.modelMapperService.forDto().map(orderedAdditionalService, ListOrderedAdditionalServiceDto.class)).collect(Collectors.toList());

	        return new SuccessDataResult<List<ListOrderedAdditionalServiceDto>>(response, "Success");
	}

}
