package fr.tzoreol.td3.dtos;

import fr.tzoreol.td3.enums.Country;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Named("data")
@RequestScoped
public class DataDto implements Serializable {
    public List<Country> getCountries() {
        return Arrays.asList(Country.values());
    }
}
