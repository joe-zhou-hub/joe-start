package com.joe.work;
import org.junit.Test;
/**@author Joe*/
/**
 *
 * CREATE TABLE `userInfo` (
 * `id` INTEGER(11) AUTO_INCREMENT NOT NULL ,
 * `user_name` varchar(50),
 * `user_age` integer(10),
 *  PRIMARY KEY(`id`)
 *  ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 *
 * */
public class JpaTest {
    @Test
    public void createTable() {
        new CreateTableTool(Emp.class).build();
    }
}