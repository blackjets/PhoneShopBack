package shop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import shop.bean.PhoneBean;
import shop.bean.PhoneMapper;
import shop.exception.PhoneNotFoundException;

import java.util.List;

public class PhoneDaoImpl implements PhoneDao {
    private static final String SQL_GET_PHONE_BY_ID = "select id, company_name, model, cost from mobile where id = :id";
    private static final String SQL_DELETE_PHONE_BY_ID = "delete from mobile where id = :id";
    private static final String SQL_INSERT_PHONE = "insert into mobile(,company_name,model,cost) values(:company_name,:model,:cost)";
    private final PhoneMapper phoneMapper;
    private final NamedParameterJdbcTemplate jdbctemplate;

    @Autowired
    public PhoneDaoImpl(PhoneMapper phoneMapper, NamedParameterJdbcTemplate jbdcTemplate){
        this.phoneMapper = phoneMapper;
        this.jdbctemplate = jbdcTemplate;
    }

    public PhoneBean getPhone(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
        List<PhoneBean> phones = jdbctemplate.query(
                SQL_GET_PHONE_BY_ID,
                params,
                phoneMapper
        );
        if (phones.isEmpty()){
            throw new PhoneNotFoundException(id);
        }
        return phones.get(0);
    }

    public void deletePhone(int id) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id",id);
        jdbctemplate.update(SQL_DELETE_PHONE_BY_ID,params);
    }

    public void insertPhone(PhoneBean bean) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("company_name",bean.getCompanyName());
        params.addValue("model",bean.getModel());
        params.addValue("cost", bean.getCost());
        jdbctemplate.update(SQL_INSERT_PHONE,params);
    }

    public List<PhoneBean> getPhoneList() {

        return null;
    }

    @Override
    public void updatePhone(int id, String companyName, String model, double cost) {

    }
}
