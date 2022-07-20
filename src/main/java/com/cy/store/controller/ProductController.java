package com.cy.store.controller;

import com.cy.store.entity.Product;
import com.cy.store.service.IProductService;
import com.cy.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController extends BaseController {

    @Autowired
    private IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList() {
        List<Product> data = productService.findHotList();
        return new JsonResult<List<Product>>(OK, data);
    }

    @RequestMapping("recent_list")
    public JsonResult<List<Product>> getRecentList() {
        List<Product> data = productService.findRecentList();
        return new JsonResult<>(OK, data);
    }

    @GetMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id) {
        // 调用业务对象执行获取数据
        Product data = productService.findById(id);
        // 返回成功和数据
        return new JsonResult<Product>(OK, data);
    }

    @GetMapping("/pages")
    public JsonResult<List<Product>> getByCategoryId(Integer categoryId, Integer pageNum){
        List<Product> data = productService.findByCategoryId(categoryId, pageNum, 4);
        return new JsonResult<>(OK, data);
    }

    @GetMapping("{categoryId}/count")
    public JsonResult<Integer> countByCategoryId(@PathVariable("categoryId") Integer categoryId){
        Integer data = productService.countByCategoryId(categoryId);
        return new JsonResult<>(OK, data);
    }

}
