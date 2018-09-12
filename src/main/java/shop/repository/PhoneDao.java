package shop.repository;

import shop.bean.PhoneBean;

import java.util.List;

public interface PhoneDao {
    //SELECT * FROM mobile WHERE id = {id}
    PhoneBean getPhone(int id);
    //DELETE FROM mobile WHERE id = {id}
    void deletePhone(int id);
    //INSERT INTO mobile(,company_name,model,cost) values{}
    void insertPhone(PhoneBean bean);

    void updatePhone(int id, String companyName, String model, double cost);

    List<PhoneBean> getPhoneList();



}
