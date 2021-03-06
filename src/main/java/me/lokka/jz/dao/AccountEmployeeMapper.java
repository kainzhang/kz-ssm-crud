package me.lokka.jz.dao;

import java.util.List;
import me.lokka.jz.bean.AccountEmployee;
import me.lokka.jz.bean.AccountEmployeeExample;
import org.apache.ibatis.annotations.Param;

public interface AccountEmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    long countByExample(AccountEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int deleteByExample(AccountEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int insert(AccountEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int insertSelective(AccountEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    List<AccountEmployee> selectByExample(AccountEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    AccountEmployee selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") AccountEmployee record, @Param("example") AccountEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByExample(@Param("record") AccountEmployee record, @Param("example") AccountEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(AccountEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_account_employee
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByPrimaryKey(AccountEmployee record);
}