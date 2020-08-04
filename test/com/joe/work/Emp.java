package com.joe.work;
/**@author Joe*/
@Table("emp")
public class Emp {
    @Id
    private Integer id;
    @Column(name = "ename",length=20)
    private String empName;
    @Column(name = "age", type = "integer", length = 10)
    private String empAge;
}