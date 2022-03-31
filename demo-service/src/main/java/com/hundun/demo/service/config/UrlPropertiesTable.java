package com.hundun.demo.service.config;

import com.google.common.collect.Table;

public class UrlPropertiesTable {

    private Table<String, String, String> table;

    private boolean useMock;

    public Table<String, String, String> getTable() {
        return table;
    }

    public void setTable(Table<String, String, String> table) {
        this.table = table;
    }

    public boolean isUseMock() {
        return useMock;
    }

    public void setUseMock(boolean useMock) {
        this.useMock = useMock;
    }
}
