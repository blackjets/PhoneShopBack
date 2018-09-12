package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import shop.bean.PhoneBean;
import shop.repository.PhoneDao;

@Primary
@Service
public class PhoneServiceImpl implements PhoneService {

    private PhoneDao phoneDao;//maybe final?

    public PhoneBean getPhone(int phoneId) {
        return phoneDao.getPhone(phoneId);
    }
    @Override
    public void createPhone(String companyName, String model, double cost) {
        PhoneBean bean = new PhoneBean();
        bean.setModel(model);
        bean.setCompanyName(companyName);
        bean.setCost(cost);
        phoneDao.insertPhone(bean);
    }

    public void updatePhone(int id, String companyName, String model, double cost) {
        PhoneBean phone = phoneDao.getPhone(id);
        phoneDao.updatePhone(phone.getId(), companyName, model,cost);
    }

    public void deletePhone(int id) {

    }
}
