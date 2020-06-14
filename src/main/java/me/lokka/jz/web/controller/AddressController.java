package me.lokka.jz.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import me.lokka.jz.bean.Address;
import me.lokka.jz.bean.Product;
import me.lokka.jz.bean.extend.AddressExtend;
import me.lokka.jz.bean.extend.ProductExtend;
import me.lokka.jz.service.IAddressService;
import me.lokka.jz.service.IProductService;
import me.lokka.jz.utils.Message;
import me.lokka.jz.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Class: AddressController
 * @Descr: 地址控制器
 * @Author: LOKKA
 * @Date: 2020/6/14 10:12
 **/

@Api(description = "地址管理接口")
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private IAddressService addressService;

    @ApiOperation(value = "获取全部")
    @GetMapping("find_all")
    public Message findAll() {
        List<Address> list = addressService.findAll();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "获取全部+用户信息")
    @GetMapping("find_all_with_user")
    public Message findAllWithUser() {
        List<AddressExtend> list = addressService.findAllWithUser();
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过用户ID查找")
    @ApiImplicitParam(name = "userId", value = "用户唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_user_id")
    public Message findByUserId(long userId) {
        List<Address> list = addressService.findByUserId(userId);
        return MessageUtil.success(list);
    }

    @ApiOperation(value = "通过地址ID查找")
    @ApiImplicitParam(name = "id", value = "地址唯一编号", required = true, paramType = "query")
    @GetMapping("find_by_id")
    public Message findById(long id) {
        Address address = addressService.findById(id);
        return MessageUtil.success(address);
    }

    @ApiOperation(value = "添加或通过ID修改")
    @PostMapping("save_or_edit")
    public Message saveOrEdit(Address address) {
        addressService.saveOrEdit(address);
        return MessageUtil.success("保存成功");
    }

    @ApiOperation(value = "通过ID删除")
    @ApiImplicitParam(name = "id", value = "地址唯一编号", required = true, paramType = "query")
    @GetMapping("del_by_id")
    public Message delById(long id) {
        addressService.delById(id);
        return MessageUtil.success("删除成功");
    }
}
