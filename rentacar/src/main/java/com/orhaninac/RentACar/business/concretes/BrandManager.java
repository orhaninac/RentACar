package com.orhaninac.RentACar.business.concretes;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orhaninac.RentACar.business.abstracts.BrandService;
import com.orhaninac.RentACar.business.dtos.ListBrandDto;
import com.orhaninac.RentACar.business.request.CreateBrandRequest;
import com.orhaninac.RentACar.core.utilities.mapping.ModelMapperService;
import com.orhaninac.RentACar.dataAccess.abstracts.BrandDao;
import com.orhaninac.RentACar.entities.concretes.Brand;

@Service
public class BrandManager implements BrandService {

	private BrandDao brandDao;
	private ModelMapperService modelMapperService;

	@Autowired
	public BrandManager(BrandDao brandDao, ModelMapperService modelMapperService) {
		this.brandDao = brandDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public List<ListBrandDto> getAll() {
		List<Brand> result = brandDao.findAll();
		List<ListBrandDto> response = result.stream()
				.map(brand -> modelMapperService.forDto().map(brand, ListBrandDto.class)).collect(Collectors.toList());
		return response;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		if (!doesExist(brand)) {
			brandDao.save(brand);
		}

	}

	@Override
	public ListBrandDto getById(int id) {
		Brand brand = brandDao.getById(id);
		ListBrandDto response = modelMapperService.forDto().map(brand, ListBrandDto.class);
		return response;
	}

	private boolean doesExist(Brand brand) {

		return Objects.nonNull(brandDao.getByBrandName(brand.getBrandName()));
	}

}
