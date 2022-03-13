package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.CityService;
import com.orhaninac.RentACar.business.dtos.GetCityDto;
import com.orhaninac.RentACar.business.dtos.ListCityDto;
import com.orhaninac.RentACar.business.request.CreateCityRequest;
import com.orhaninac.RentACar.business.request.UpdateCityRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.core.utilities.results.DataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorDataResult;
import com.orhaninac.RentACar.core.utilities.results.ErrorResult;
import com.orhaninac.RentACar.core.utilities.results.Result;
import com.orhaninac.RentACar.core.utilities.results.SuccessDataResult;
import com.orhaninac.RentACar.core.utilities.results.SuccessResult;
import com.orhaninac.RentACar.dataAccess.abstracts.CityDao;
import com.orhaninac.RentACar.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	private ModelMapperService modelMapperService;

	public CityManager(CityDao cityDao, ModelMapperService modelMapperService) {
		super();
		this.cityDao = cityDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public DataResult<List<ListCityDto>> getAll() {
		
		List<City> result = cityDao.findAll();
		List<ListCityDto> response = result.stream().map(city -> modelMapperService.forDto().map(city, ListCityDto.class)).collect(Collectors.toList());
		
		return new SuccessDataResult<List<ListCityDto>>(response, "Success");
	}

	@Override
	public Result add(CreateCityRequest createCityRequest) {
		
		City city = this.modelMapperService.forRequest().map(createCityRequest, City.class);
		System.out.println(city.getCityName());
		if (!checkIfCityName(city.getCityName())) {
			this.cityDao.save(city);
			return new SuccessResult("City.Added : " + city.getCityName());
		}
		
		return new ErrorResult("City.NotAdded : " + city.getCityName() + " , City already exists!");
	}

	@Override
	public DataResult<GetCityDto> getById(int id) {
		
		City city = cityDao.getById(id);
		if (checkIfCityIdExists(city.getId())) {
			GetCityDto response = modelMapperService.forDto().map(city, GetCityDto.class);
			return new SuccessDataResult<GetCityDto>(response, "Success");
		}
		
		return new ErrorDataResult<GetCityDto>("City.NotFounded , A city with this ID was not found!");
	}

	@Override
	public Result delete(int id) {
		if (checkIfCityIdExists(id)) {
			this.cityDao.deleteById(id);
			return new SuccessResult("city.Deleted ");
		}
		return new ErrorResult("city.NotDeleted  , A city with this ID was not found!");
	}

	@Override
	public Result update(UpdateCityRequest updateCityRequest) {
		City city = this.modelMapperService.forRequest().map(updateCityRequest, City.class);
		if (checkIfCityIdExists(city.getId())) {
			this.cityDao.save(city);
			return new SuccessResult("City.Updated : " + city.getCityName());
		}
		return new ErrorResult("City.NotUpdated : " + city.getCityName() + " , A city with this ID was not found!");
	}

	@Override
	public DataResult<List<ListCityDto>> getByAllId(List<Integer> idList) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean checkIfCityIdExists(int cityId) {
		return Objects.nonNull(cityDao.getCityById(cityId));
	}
	
	private boolean checkIfCityName(String cityName) {
		return Objects.nonNull(cityDao.getCityByCityName(cityName));
	}

}
