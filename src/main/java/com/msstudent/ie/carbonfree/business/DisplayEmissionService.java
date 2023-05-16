package com.msstudent.ie.carbonfree.business;

import com.msstudent.ie.carbonfree.data.City;
import com.msstudent.ie.carbonfree.data.CityRepository;
import com.msstudent.ie.carbonfree.data.Transport;
import com.msstudent.ie.carbonfree.data.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class DisplayEmissionService {


    private TransportRepository transportRepository;

    private CityRepository cityRepository;

    @Autowired
    public DisplayEmissionService(TransportRepository transportRepository, CityRepository cityRepository) {
        this.transportRepository = transportRepository;
        this.cityRepository = cityRepository;
    }

    @Autowired
    public void setTransportRepository(TransportRepository transportRepository) {
        this.transportRepository = transportRepository;
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    // all city name
    public List<String> getAllCityName() {

        return cityRepository.findAllCityName();
    }

    //A list of info about 1 city
    public List<DisplayCity> getInfoByCityName(String cityName) {
        Iterable<City> cities = this.cityRepository.findByCityName(cityName);
        return getDisplayCities(cities);
    }

    public List<DisplayCity> getAllInfo() {
        Iterable<City> cities = this.cityRepository.findAll();
        return getDisplayCities(cities);
    }

    // add all info to a list
    private List<DisplayCity> getDisplayCities(Iterable<City> cities) {
        List<DisplayCity> displayCities= new ArrayList<>();
        cities.forEach(city -> {
            DisplayCity displayCity = new DisplayCity();
            displayCity.setCityId(city.getCityId());
            displayCity.setCityName(city.getCityName());
            displayCity.setCityEmission(city.getCityEmission());
            displayCity.setYear(city.getYear());
            displayCities.add(displayCity);
        });
        return displayCities;
    }

//    private String transportBrand;
//    private String transportModel;
//    private String transportSize;
//
//    private double transportEmission;
//
    public List<String> getAllCarBrand() {
        return transportRepository.getTransportBrand();
    }

    public List<String> getCarModelByBrand(String newBrand) {
        return transportRepository.getTransportModelByBrand(newBrand);
    }

    public List<String> getCarSizeByBrandAndModel(String newBrand, String newModel) {
        return transportRepository.getTransportSizeByModelAndBrand(newBrand, newModel);
    }

    public DisplayCar getCarEmissionInfoByCar(String brand, String mode, String size) {
        DisplayCar displayCar = new DisplayCar();

        displayCar.setTransportId(transportRepository.findTransportByThree(brand,mode,size).getTransportId());
        displayCar.setTransportBrand(transportRepository.findTransportByThree(brand,mode,size).getTransportBrand());
        displayCar.setTransportEmission(transportRepository.findTransportByThree(brand,mode,size).getTransportEmission());
        displayCar.setTransportModel(transportRepository.findTransportByThree(brand,mode,size).getTransportModel());
        displayCar.setTransportSize(transportRepository.findTransportByThree(brand,mode,size).getTransportSize());


        return displayCar;
    }


}
