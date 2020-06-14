package me.lokka.jz.dao.extend;

import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.extend.AddressExtend;
import me.lokka.jz.dao.AddressMapper;

import java.util.List;

/**
 * @Interface: AddressExtendMapper
 * @Descr: 地址接口
 * @Author: LOKKA
 * @Date: 2020/6/14 9:57
 **/

public interface AddressExtendMapper extends AddressMapper {

    List<AddressExtend> selectAllWithUser();

}