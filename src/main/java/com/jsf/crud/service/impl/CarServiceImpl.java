/**
 *
 */
/**
 * @author s727953
 *
 */
package com.jsf.crud.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jsf.crud.entity.CarDTO;
import com.jsf.crud.repositry.CarRepo;
import com.jsf.crud.service.CarService;
import com.jsf.crud.uito.CarUITO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CarServiceImpl implements CarService {
    @Autowired
    CarRepo carRepo;

    @Override
    @Transactional(readOnly = false)
    public CarUITO doSaveCar(CarUITO carUiTO) {
        CarDTO dto = UiToToDto(carUiTO);
        dto = carRepo.save(dto);
        BeanUtils.copyProperties(dto, carUiTO);
        return carUiTO;
    }

    private void dtoToUito(CarUITO carUiTO, CarDTO dto) {
        CarUITO uitTO = new CarUITO();
        BeanUtils.copyProperties(dto, uitTO);
    }

    private CarDTO UiToToDto(CarUITO carUiTO) {
        CarDTO dto = new CarDTO();
        BeanUtils.copyProperties(carUiTO, dto);
        List<CarDTO> lst = new ArrayList<>();
        lst.add(dto);
        return dto;
    }

    @Override
    public List<CarUITO> doFetchAllCar() {
        List<CarDTO> dtoLst = carRepo.findAll();
        List<CarUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            CarUITO tmpUiTO = new CarUITO();
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public CarUITO doGetCar(CarUITO carUiTO) {
        if (null != carUiTO.getBrand()) {
            CarDTO dto = new CarDTO();

            BeanUtils.copyProperties(carUiTO, dto);
            dto = carRepo.getOne(dto.getId());

            BeanUtils.copyProperties(dto, carUiTO);
        }
        return carUiTO;
    }

    @Override
    @Transactional
    public void doDeleteCar(CarUITO carUiTO) {

        carRepo.deleteById(carUiTO.getId());
    }

}