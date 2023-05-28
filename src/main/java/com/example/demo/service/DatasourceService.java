package com.example.demo.service;

import com.example.demo.domain.ColumnEntity;
import com.example.demo.domain.DatasourceEntity;
import com.example.demo.domain.RoleEntity;
import com.example.demo.domain.TableEntity;
import com.example.demo.repository.ColumnRepository;
import com.example.demo.repository.DatasourceRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TableRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DatasourceService {

    private final DatasourceRepository datasourceRepository;
    private final TableRepository tableRepository;
    private final ColumnRepository columnRepository;
    private final RoleRepository roleRepository;

    public DatasourceService(DatasourceRepository datasourceRepository, TableRepository tableRepository, ColumnRepository columnRepository, RoleRepository roleRepository) {
        this.datasourceRepository = datasourceRepository;
        this.tableRepository = tableRepository;
        this.columnRepository = columnRepository;
        this.roleRepository = roleRepository;
    }

    public void addTableToDatasource(String tableName, String dataSource) {

        DatasourceEntity datasourceEntity = addDatasourceIfNotExists(dataSource);
        TableEntity tableEntity = addTableIfNotExists(tableName);
        tableEntity.getDatasources().add(datasourceEntity);
        tableRepository.save(tableEntity);
    }

    public void addRoleToTable(String roleName, String tableName) {
        TableEntity tableEntity = addTableIfNotExists(tableName);
        RoleEntity roleEntity = addRoleIfNotExists(roleName);

        tableEntity.getRoles().add(roleEntity);
        tableRepository.save(tableEntity);
    }



    public void addColumnToTable(String columnName, String tableName) {
        ColumnEntity columnEntity = addColumnIfNotExists(columnName);
        TableEntity tableEntity = addTableIfNotExists(tableName);
        tableEntity.getColumns().add(columnEntity);
        tableRepository.save(tableEntity);
    }

    private RoleEntity addRoleIfNotExists(String roleName) {
        if (!existsRole(roleName)) {
            log.info("Adding role: " + roleName);
            return addRole(roleName);
        }else {
            log.info("Role [" + roleName + "] exists");
            return findRole(roleName);
        }
    }



    private ColumnEntity addColumnIfNotExists(String columnName) {
        if (!existsColumn(columnName)) {
            log.info("Adding column: " + columnName);
            return addColumn(columnName);
        } else {
            log.info("Column [" + columnName + "] exists");
            return findColumn(columnName);
        }
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

    private ColumnEntity addColumn(String columnName) {
        ColumnEntity col = new ColumnEntity();
        col.setName(columnName);
        return columnRepository.save(col);
    }

    private RoleEntity addRole(String roleName) {
        RoleEntity role = new RoleEntity();
        role.setName(roleName);
        return roleRepository.save(role);
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

    private boolean existsRole(String roleName) {
        return roleRepository.existsByName(roleName);
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

    private RoleEntity findRole(String roleName) {
        return roleRepository.findByName(roleName);
    }


}
