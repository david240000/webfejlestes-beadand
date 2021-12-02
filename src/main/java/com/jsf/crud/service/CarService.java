
package com.jsf.crud.service;

import java.util.List;

import com.jsf.crud.uito.CarUITO;

public interface CarService {
    CarUITO doSaveCar(CarUITO carUITO);

    List<CarUITO> doFetchAllCar();

    CarUITO doGetCar(CarUITO carUITO);

    void doDeleteCar(CarUITO carUITO);
}