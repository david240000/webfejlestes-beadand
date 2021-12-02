/**
 *
 */
/**
 * @author s727953
 *
 */
package com.jsf.crud.mbean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import com.jsf.crud.service.CarService;
import com.jsf.crud.uito.CarUITO;
import org.primefaces.context.RequestContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

@Controller("carController")
@SessionScope
public class CarController {
    @Autowired
    private CarService carService;

    private String actionLabel;
    private CarUITO carUiTO;
    private List<CarUITO> carUiToList;

    /**
     * add or update new Record in DB
     *
     * @return
     */
    public void doSaveInfoCar() {
        System.out.println(this.getCarUiTO());
        carService.doSaveCar(this.getCarUiTO());
        getAllCar();
        this.setCarUiTO(new CarUITO());
        RequestContext.getCurrentInstance().showMessageInDialog(new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Car Details", "Car Details added/Updated Successfully."));

    }

    /**
     * Default load all the Car info
     */
    @PostConstruct
    public void getAllCar() {
        if (!this.getCarUiToList().isEmpty()) {
            this.getCarUiToList().clear();
        }
        System.out.println(" >>>>>>>>>>>>> " + carService);
        this.getCarUiToList().addAll(carService.doFetchAllCar());
        this.setActionLabel("Add");
    }

    /**
     * Remove selected Car info
     *
     * @return
     */

    public void deleteCar(CarUITO carUiTO) {
        carService.doDeleteCar(carUiTO);
        getAllCar();
    }

    public void editCar(CarUITO carUiTO) {
        this.setActionLabel("Update");
        BeanUtils.copyProperties(carUiTO, this.getCarUiTO());
        System.out.println(this.getCarUiTO());
    }

    public CarUITO getCarUiTO() {
        if (carUiTO == null) {
            carUiTO = new CarUITO();
        }
        return carUiTO;
    }

    public void setCarUiTO(CarUITO carUiTO) {
        this.carUiTO = carUiTO;
    }

    public List<CarUITO> getCarUiToList() {
        if (null == carUiToList) {
            carUiToList = new ArrayList<>();
        }
        return carUiToList;
    }

    public String getActionLabel() {
        return actionLabel;
    }

    public void setActionLabel(String actionLabel) {
        this.actionLabel = actionLabel;
    }

}