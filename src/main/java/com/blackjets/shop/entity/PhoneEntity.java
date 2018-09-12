package com.blackjets.shop.entity;

import com.blackjets.shop.model.Phone;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneEntity implements RowMapper<Phone> {

    public Phone mapRow(ResultSet rs, int rowNum) throws SQLException {
        Phone phone = new Phone();
        phone.setId(rs.getInt("id"));
        phone.setCompanyName(rs.getString("company_name"));
        phone.setModel(rs.getString("com/blackjets/shop/model"));
        phone.setCost(rs.getDouble("cost"));

        return phone;
    }

    public List<Phone> mapRowList(ResultSet rs, int rowNum) throws SQLException {
        List<Phone> phones = new ArrayList<Phone>();

        while (rs.next()) {
            phones.add(rs.getRow(), mapRow(rs, rs.getRow()));
        }

        return phones;
    }
}
