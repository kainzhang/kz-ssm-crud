package me.lokka.jz.dao;

import java.util.List;
import me.lokka.jz.bean.Order;
import me.lokka.jz.bean.OrderExample;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    long countByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int deleteByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    List<Order> selectByExample(OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    Order selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jz_order
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    int updateByPrimaryKey(Order record);
}