package me.lokka.jz.dao;

import java.util.List;
import me.lokka.jz.bean.AccountCustomer;
import me.lokka.jz.bean.AccountCustomerExample;
import org.apache.ibatis.annotations.Param;

public interface AccountCustomerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    long countByExample(AccountCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int deleteByExample(AccountCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int insert(AccountCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int insertSelective(AccountCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    List<AccountCustomer> selectByExample(AccountCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    AccountCustomer selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") AccountCustomer record, @Param("example") AccountCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByExample(@Param("record") AccountCustomer record, @Param("example") AccountCustomerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(AccountCustomer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByPrimaryKey(AccountCustomer record);
}