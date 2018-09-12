package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shop.bean.PhoneBean;
import shop.repository.PhoneDao;

@Component
public interface PhoneService {

   PhoneBean getPhone(int phoneId);

   void createPhone(String comapanyName, String model, double cost);
   void updatePhone(int id, String comapanyName, String model, double cost);
   void deletePhone(int id);

}
