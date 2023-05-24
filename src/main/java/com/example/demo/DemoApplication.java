package com.example.demo;

import com.example.demo.domain.DatasourceEntity;
import com.example.demo.domain.TableEntity;

import com.example.demo.repository.DatasourceRepository;
import com.example.demo.repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private final TableRepository tableRepository;
	private final DatasourceRepository datasourceRepository;
	private final DatasourceService datasourceService;

	public DemoApplication(TableRepository tableRepository, DatasourceRepository datasourceRepository, DatasourceService datasourceService) {
		this.tableRepository = tableRepository;
		this.datasourceRepository = datasourceRepository;
		this.datasourceService = datasourceService;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

    datasourceService.addTableToDatasource("fct_sales","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_publishers","BookShop Transactional");
    datasourceService.addTableToDatasource("fct_inventory","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_currency","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_books","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_promo","BookShop Transactional");
    datasourceService.addTableToDatasource("customer_tier_sbx","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_countries","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_cards","BookShop Transactional");
    datasourceService.addTableToDatasource("dim_customer","BookShop Transactional");
    datasourceService.addTableToDatasource("user_transactions_west","User Transactions");
    datasourceService.addTableToDatasource("user_transactions_kafka_connect","User Transactions");
    datasourceService.addTableToDatasource("user_transactions_east","User Transactions");
    datasourceService.addTableToDatasource("data_lake","Data Lake S3");


	}
}
