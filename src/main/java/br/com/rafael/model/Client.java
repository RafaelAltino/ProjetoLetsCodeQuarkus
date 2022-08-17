package br.com.rafael.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private int age;
    private String vatnumber;
    private String email;

    public Client(){
        
    }

    public Client(String name) {
        this.name = name;
    }

    public Client(String name, int age, String vatnumber, String email) {
        this.name = name;
        this.age = age;
        this.vatnumber = vatnumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getVatnumber() {
        return vatnumber;
    }
    public void setVatnumber(String vatnumber) {
        this.vatnumber = vatnumber;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client [name=" + name + ", age=" + age + ", email=" + email + ", id=" + id + ", vatnumber=" + vatnumber
                + "]";
    }

    
    

    
    
}
