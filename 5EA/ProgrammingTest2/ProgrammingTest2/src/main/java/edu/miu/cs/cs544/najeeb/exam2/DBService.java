package edu.miu.cs.cs544.najeeb.exam2;

import org.springframework.beans.factory.annotation.Autowired;

public class DBService {

    private String url;
    private String username;
    private String password;
    private boolean connected= false;

    public boolean connect() {
        boolean connect= false;
        if (("production" == url) && ("jack" == username) && ("cs544" == password)) {
            connect= true;
        } else if (("development" == url) && ("jill" == username) && ("123" == password)) {
            connect= true;
        } else if (("testing" == url) && ("jim" == username) && ("111" == password)) {
            connect= true;
        } else {
            connect= false;
        }
        this.connected= connect;
        return connect;
    }

    public boolean persist(String data) {
        boolean persistDone= false;
        if (connected) {
            System.out.println("connected to "+url);
            System.out.println("data "+data+" saved.");
            persistDone= true;
        } else {
            System.out.println("not connected to database");
        }

        return persistDone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
