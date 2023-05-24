package com.example.demo;

import com.example.demo.domain.ColumnEntity;
import com.example.demo.domain.DatasourceEntity;
import com.example.demo.domain.TableEntity;
import com.example.demo.repository.ColumnRepository;
import com.example.demo.repository.DatasourceRepository;
import com.example.demo.repository.TableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DatasourceService {

    private final DatasourceRepository datasourceRepository;
    private final TableRepository tableRepository;
    private final ColumnRepository columnRepository;

    public DatasourceService(DatasourceRepository datasourceRepository, TableRepository tableRepository, ColumnRepository columnRepository) {
        this.datasourceRepository = datasourceRepository;
        this.tableRepository = tableRepository;
        this.columnRepository = columnRepository;
    }

    public void addTableToDatasource(String tableName, String dataSource) {

        DatasourceEntity datasourceEntity = addDatasourceIfNotExists(dataSource);
        TableEntity tableEntity = addTableIfNotExists(tableName);
        tableEntity.getDatasources().add(datasourceEntity);
        tableRepository.save(tableEntity);
    }



  public DatasourceEntity addDatasourceIfNotExists(String dataSource) {
    if (!existsDatasource(dataSource)) {
        log.info("Adding data source: "+dataSource);
        return addDatasource(dataSource);
    } else{
        log.info("Data source: "+dataSource+" already exists.");
      return findDatasource(dataSource);
    }
  }

  public TableEntity addTableIfNotExists(String table) {
    if (!existsTable(table)) {
      log.info("Adding table: " + table);
      return addTable(table);
    } else{
        log.info("Table ["+table+"] already exists");
      return findTable(table);
    }
  }

  public DatasourceEntity addDatasource(String dataSource) {
      DatasourceEntity datasourceEntity = new DatasourceEntity();
      datasourceEntity.setName(dataSource);
      return datasourceRepository.save(datasourceEntity);
  }

  public TableEntity addTable(String table) {
      TableEntity tbl = new TableEntity();
      tbl.setName(table);
      return tableRepository.save(tbl);
  }

  public boolean existsDatasource(String dataSource) {
        return datasourceRepository.existsByName(dataSource);
  }

  public boolean existsTable(String table) {
    return tableRepository.existsByName(table);
  }

    public boolean existsColumn(String column) {
        return columnRepository.existsByName(column);
    }

  public DatasourceEntity findDatasource(String dataSource) {
        return datasourceRepository.findByName(dataSource);
  }

  public TableEntity findTable(String table) {
    return tableRepository.findByName(table);
  }

    public ColumnEntity findColumn(String column) {
        return columnRepository.findByName(column);
    }
}
