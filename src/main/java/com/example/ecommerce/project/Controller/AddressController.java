package com.example.ecommerce.project.Controller;
import com.example.ecommerce.project.Entity.Addresses;
import com.example.ecommerce.project.Service.Addressservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    private Addressservice addressservice;
    @PutMapping("/updateaddress")
    public void updateCategory(@RequestBody Addresses addresses){
        addressservice.updateAddressById(addresses.getAddress_id(),addresses.getStreet());
    }
    @GetMapping("/getaddress")
    public List<Addresses> getAddress(){
        return addressservice.getAllAddresses();
    }
    @DeleteMapping("/deleteAddress")
    public void deleteAddress(@RequestBody Addresses addresses) {
        addressservice.deleteAddressesById(addresses.getAddress_id());
    }
    @GetMapping("/getaddress/{id}")
    public List<Addresses> getAddressById(@PathVariable("id") Integer id){
        return addressservice.getAddressesById(id);
    }
    @PostMapping("/addadress")
    public void addAddress(@RequestBody Addresses addresses){
        addressservice.addAddress(addresses.getUser_id(),addresses.getStreet(),addresses.getCity()
                ,addresses.getState(), addresses.getPostal_code(),addresses.getCountry());
    }
}
