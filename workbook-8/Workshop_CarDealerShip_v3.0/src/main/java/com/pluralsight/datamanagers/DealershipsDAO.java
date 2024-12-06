package com.pluralsight.datamanagers;

import org.apache.commons.dbcp2.BasicDataSource;

public class DealershipsDAO {

    private String userName;
    private String password;
    private BasicDataSource dataSource;

    public DealershipsDAO(String userName, String password) {

        dataSource = new BasicDataSource();
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        this.userName = userName;
        this.password = password;
    }


}
