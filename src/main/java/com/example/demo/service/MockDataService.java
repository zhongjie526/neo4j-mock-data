package com.example.demo.service;

import com.example.demo.service.DatasourceService;

public class MockDataService {

    private final DatasourceService datasourceService;

    public MockDataService(DatasourceService datasourceService) {
        this.datasourceService = datasourceService;
    }

    public void createMockData(){
        datasourceService.addTableToDatasource("fct_sales","BookShop Transactional");
        datasourceService.addRoleToTable("Administrator", "fct_sales");

        datasourceService.addTableToDatasource("dim_publishers","BookShop Transactional");
        datasourceService.addColumnToTable("publisher_id", "dim_publishers");
        datasourceService.addColumnToTable("publisher_num", "dim_publishers");

        datasourceService.addTableToDatasource("fct_inventory","BookShop Transactional");
        datasourceService.addTableToDatasource("dim_currency","BookShop Transactional");
        datasourceService.addTableToDatasource("dim_books","BookShop Transactional");
        datasourceService.addTableToDatasource("dim_promo","BookShop Transactional");

        datasourceService.addTableToDatasource("customer_tier_sbx","BookShop Transactional");
        datasourceService.addColumnToTable("customer_id", "customer_tier_sbx");
        datasourceService.addColumnToTable("tier_id", "customer_tier_sbx");
        datasourceService.addColumnToTable("tier_nm", "customer_tier_sbx");
        datasourceService.addColumnToTable("experiment_id", "customer_tier_sbx");
        datasourceService.addColumnToTable("rundate_tmst", "customer_tier_sbx");


        datasourceService.addTableToDatasource("dim_countries","BookShop Transactional");
        datasourceService.addTableToDatasource("dim_cards","BookShop Transactional");
        datasourceService.addTableToDatasource("dim_customer","BookShop Transactional");
        datasourceService.addTableToDatasource("user_transactions_west","User Transactions");
        datasourceService.addTableToDatasource("user_transactions_kafka_connect","User Transactions");
        datasourceService.addTableToDatasource("user_transactions_east","User Transactions");
        datasourceService.addTableToDatasource("data_lake","Data Lake S3");
    }
}
