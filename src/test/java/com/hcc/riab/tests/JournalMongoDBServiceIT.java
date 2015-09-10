package com.hcc.riab.tests;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.hcc.riab.model.Product;
import com.hcc.riab.model.ProductInfo;
import com.hcc.riab.repositories.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		{ "file:src/main/webapp/WEB-INF/rest-context.xml",
		   "file:src/main/webapp/WEB-INF/spring-servlet.xml",
		   "file:src/main/resources/applicationContext.xml"
		})
@TestExecutionListeners({ TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class JournalMongoDBServiceIT  {
    @Resource
    ProductRepository productRepository;

    @Test
    @Transactional
    public void crossStoreProduct(){
        Product product = new Product();
        ProductInfo info = new ProductInfo();
        info.setName("Test");
        info.setDescription("Test Product");
        product.setProductInfo(info);
        productRepository.save(product);
    }

    @Test
    @Transactional
    public void crossStoreProductFindAndUpdate(){
        Product product = productRepository.findOne(32L);
        //product.setValue(999L);
        product.getProductInfo().setDescription("Updated description");
        productRepository.save(product);
    }
}