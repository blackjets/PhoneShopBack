package com.blackjets.shop.repository;

import com.blackjets.shop.model.Phone;

import java.util.List;

public interface PhoneDao {

    //SELECT * FROM mobile WHERE id = {id}
    Phone getPhone(int id);

    //DELETE FROM mobile WHERE id = {id}
    void deletePhone(int id);

    //INSERT INTO mobile(,company_name,com.blackjets.shop.model,cost) values{}
    void insertPhone(Phone bean);

    void updatePhone(int id, String companyName, String model, double cost);

    List<Phone> getPhoneList();


}
