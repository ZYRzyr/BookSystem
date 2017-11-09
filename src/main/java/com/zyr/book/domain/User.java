package com.zyr.book.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity //表示该类是一个实体类，由于之前的配置中写了 ddl-auto，jpa会将类名作为表名自动生成表
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"name", "book"})})//表示同一行name和book作为唯一约束
public class User implements Serializable {

    @Id   //主键约束
    @GeneratedValue  //自增
    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private String book;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(String name, String book) {
        this.name = name;
        this.book = book;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book='" + book + '\'' +
                '}';
    }
}
