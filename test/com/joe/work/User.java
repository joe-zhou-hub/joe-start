package com.joe.work;
/**@author Joe*/
@Table("userInfo")
public class User {
    @Id
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_age", type = "integer", length = 10)
    private String userAge;
}