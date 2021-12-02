package com.jsf.crud.utills;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("licensePlateValidator")
public class HunLicensePlateValidator implements Validator {

    private static final String LICENSE_PLATE_PATTERN = "^[A-Z]{3}+-+[0-9]{3}$";

    private Pattern pattern;
    private Matcher matcher;

    public HunLicensePlateValidator() {
        pattern = Pattern.compile(LICENSE_PLATE_PATTERN);
    }

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {

            FacesMessage msg = new FacesMessage("License plate validation failed.", "Invalid License plate format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);

        }

    }
}
