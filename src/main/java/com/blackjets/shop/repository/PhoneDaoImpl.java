package com.blackjets.shop.repository;

import com.blackjets.shop.entity.PhoneEntity;
import com.blackjets.shop.exception.PhoneNotFoundException;
import com.blackjets.shop.model.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PhoneDaoImpl implements PhoneDao {
    private static final String SQL_GET_PHONE_BY_ID = "select id, company_name, model, cost from mobile where id = :id";
    private static final String SQL_DELETE_PHONE_BY_ID = "delete from mobile where id = :id";
    private static final String SQL_INSERT_PHONE = "insert into mobile(,company_name,model,cost) values(:company_name,:model,:cost)";
    private final PhoneEntity phoneMapper;
    private final NamedParameterJdbcTemplate jdbctemplate;

    @Autowired
    public PhoneDaoImpl(PhoneEntity phoneMapper, NamedParameterJdbcTemplate jbdcTemplate) {
        this.phoneMapper = phoneMapper;
        this.jdbctemplate = jbdcTemplate;
    }

    public Phone getPhone(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        List<Phone> phones = jdbctemplate.query(
                SQL_GET_PHONE_BY_ID,
                params,
                phoneMapper
        );
        if (phones.isEmpty()) {
            throw new PhoneNotFoundException(id);
        }
        return phones.get(0);
    }

    public void deletePhone(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        jdbctemplate.update(SQL_DELETE_PHONE_BY_ID, params);
    }

    public void insertPhone(Phone bean) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("company_name", bean.getCompanyName());
        params.addValue("com/blackjets/shop/model", bean.getModel());
        params.addValue("cost", bean.getCost());
        jdbctemplate.update(SQL_INSERT_PHONE, params);
    }

    public List<Phone> getPhoneList() {

        return null;
    }

    @Override
    public void updatePhone(int id, String companyName, String model, double cost) {

    }
}
