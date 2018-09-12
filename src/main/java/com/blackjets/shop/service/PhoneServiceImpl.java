package com.blackjets.shop.service;

import com.blackjets.shop.model.Phone;
import com.blackjets.shop.repository.PhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneDao phoneDao;

    @Autowired
    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public Phone getPhone(int phoneId) {
        return phoneDao.getPhone(phoneId);
    }

    @Override
    public void createPhone(String companyName, String model, double cost) {
        Phone bean = new Phone();
        bean.setModel(model);
        bean.setCompanyName(companyName);
        bean.setCost(cost);
        phoneDao.insertPhone(bean);
    }

    public void updatePhone(int id, String companyName, String model, double cost) {
        Phone phone = phoneDao.getPhone(id);
        phoneDao.updatePhone(phone.getId(), companyName, model, cost);
    }

    public void deletePhone(int id) {

    }
}
