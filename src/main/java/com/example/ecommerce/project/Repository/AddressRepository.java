package com.example.ecommerce.project.Repository;
import com.example.ecommerce.project.Entity.Addresses;
import com.example.ecommerce.project.Entity.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Addresses,Integer> {
    @Query(value = "SELECT s FROM Addresses s")
    public List<Addresses> getAllAddresses();


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Addresses WHERE address_id = :id")
    public void deleteAddressesById(Integer id);
    @Modifying
    @Transactional
    @Query(value = "UPDATE Addresses SET street=?2 WHERE address_id = ?1")
    public void updateAddressById(Integer id,String street);

    @Query(value="SELECT * FROM Addresses a WHERE a.address_id=?1", nativeQuery=true)
    List<Addresses> getAddressesById(@Param("id") Integer id);
    @Modifying
    @Transactional
    @Query(
            value =
                    "INSERT INTO Addresses (user_id,street,city,state, postal_code,country) values (?1,?2,?3,?4,?5,?6)",
            nativeQuery = true)
    void addAddress(Integer user_id,String street,String city,String state,Integer postal_code,
                    String country);
}
