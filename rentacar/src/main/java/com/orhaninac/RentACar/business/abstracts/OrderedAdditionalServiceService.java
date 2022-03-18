package com.orhaninac.RentACar.business.abstracts;

import java.util.List;

import com.orhaninac.RentACar.business.dtos.GetOrderedAdditionalService;
import com.orhaninac.RentACar.business.dtos.ListOrderedAdditionalServiceDto;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.Result;

public interface OrderedAdditionalServiceService {
	Result delete(int id);
    DataResult<List<ListOrderedAdditionalServiceDto>> getAll();
	DataResult<GetOrderedAdditionalService> getById(int id);
}
