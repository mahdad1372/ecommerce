package com.example.ecommerce.project.Service;

import com.example.ecommerce.project.Entity.Addresses;
import com.example.ecommerce.project.Repository.AddressRepository;
import com.example.ecommerce.project.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class Addressservice {
    @Autowired
    private AddressRepository addressRepository;
    public List<Addresses> getAllAddresses(){
        return addressRepository.getAllAddresses();
    }
    public List<Addresses> getAddressesById(Integer id){
        return addressRepository.getAddressesById(id);
    }
    public void deleteAddressesById(Integer id){
        addressRepository.deleteAddressesById(id);
    }
    public void updateAddressById(Integer id,String address){
        addressRepository.updateAddressById(id,address);
    }

    public void addAddress(Integer user_id,String street,String city,String state,Integer postal_code,String country){
        addressRepository.addAddress(user_id,street,city,state, postal_code,country);
    }
}
