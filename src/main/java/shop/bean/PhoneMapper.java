package shop.bean;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 import java.util.List;

@Component
public class PhoneMapper implements RowMapper<PhoneBean> {

    public PhoneBean mapRow(ResultSet rs, int rowNum) throws SQLException {
        PhoneBean phone = new PhoneBean();
        phone.setId(rs.getInt("id"));
        phone.setCompanyName(rs.getString("company_name"));
        phone.setModel(rs.getString("model"));
        phone.setCost(rs.getDouble("cost"));

        return phone;
    }
    public List<PhoneBean> mapRowList(ResultSet rs, int rowNum) throws SQLException{
        List<PhoneBean> phones = new ArrayList<PhoneBean>();

        while(rs.next()){
            phones.add(rs.getRow(), mapRow(rs, rs.getRow()));
        }

        return phones;
    }
}
