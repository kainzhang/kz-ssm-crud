package me.lokka.jz.bean;

import java.io.Serializable;

public class AccountCustomer implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.money
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private String money;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.transaction_time
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private Long transactionTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.description
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.type
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private String type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.user_id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column jz_account_customer.order_id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private Long orderId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table jz_account_customer
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.id
     *
     * @return the value of jz_account_customer.id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.id
     *
     * @param id the value for jz_account_customer.id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.money
     *
     * @return the value of jz_account_customer.money
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public String getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.money
     *
     * @param money the value for jz_account_customer.money
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.transaction_time
     *
     * @return the value of jz_account_customer.transaction_time
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public Long getTransactionTime() {
        return transactionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.transaction_time
     *
     * @param transactionTime the value for jz_account_customer.transaction_time
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setTransactionTime(Long transactionTime) {
        this.transactionTime = transactionTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.description
     *
     * @return the value of jz_account_customer.description
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.description
     *
     * @param description the value for jz_account_customer.description
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.type
     *
     * @return the value of jz_account_customer.type
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public String getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.type
     *
     * @param type the value for jz_account_customer.type
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.user_id
     *
     * @return the value of jz_account_customer.user_id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.user_id
     *
     * @param userId the value for jz_account_customer.user_id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column jz_account_customer.order_id
     *
     * @return the value of jz_account_customer.order_id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column jz_account_customer.order_id
     *
     * @param orderId the value for jz_account_customer.order_id
     *
     * @mbg.generated Thu Jun 11 14:38:05 GMT+08:00 2020
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}