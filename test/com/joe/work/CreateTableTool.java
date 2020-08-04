package com.joe.work;
import java.lang.reflect.Field;
/**@author Joe*/
public class CreateTableTool {

    private Class<?> instance;

    public CreateTableTool(Class<?> instance) {
        this.instance = instance;
    }

    public void build() {
        String sql = getCreateTableSql();
        System.out.println(sql);
        //TODO 调用JDBC的executeUpdate方法发送这个SQL即可完成造表
    }

    /**
     * 获取造表SQL，其中主键默认integer类型，11长度，自增非空，引擎默认InnoDB，编码默认为utf-8
     *
     * @return 造表SQL
     */
    private String getCreateTableSql() {
        // 获取表名
        String tableName = getTableName();
        // 获取字段（已经拼好的字符串 : "ename varchar(20),eage integer(10)"）
        String columnsFormatString = getColumnsFormatString();
        // 获取id
        String idName = getIdName();

        // SQL格式
        String sqlFormat =
                "CREATE TABLE `%s` ( "
                        + "`%s` INTEGER(11) AUTO_INCREMENT NOT NULL "
                        + "%s, "
                        + "PRIMARY KEY(`%s`) "
                        + ") ENGINE=InnoDB DEFAULT CHARSET=utf8";
        return String.format(sqlFormat, tableName, idName, columnsFormatString, idName);
    }

    /**
     * 获取@Table注解中标识的表名
     *
     * @return @Table注解中标识的表名
     */
    private String getTableName() {
        return instance.getAnnotation(Table.class).value();
    }

    /**
     * 获取所有@Column中的内容并返回一个格式化字符串
     *
     * @return 一个格式化字符串，如 name varchar(50)
     */
    private String getColumnsFormatString() {
        StringBuilder columns = new StringBuilder();

        Field[] fields = instance.getDeclaredFields();

        for (Field field : fields) {

            // 获取每个属性上的@Column注解
            Column columnAnnotation = field.getAnnotation(Column.class);

            // 只要属性上存在@Column注解，就获取其中的name、type和length
            if (columnAnnotation != null) {
                String name = columnAnnotation.name();
                String type = columnAnnotation.type();
                int length = columnAnnotation.length();

                // 拼成", user_name varchar(50)"的格式
                String line = String.format(", `%s` %s(%d)", name, type, length);
                columns.append(line);
            }
        }
        return columns.toString();
    }

    /**
     * 获取@Id中的内容并返回Id的名字
     *
     * @return Id的名字
     */
    private String getIdName() {

        String idName = "";

        Field[] fields = instance.getDeclaredFields();

        for (Field field : fields) {
            // 获取每个属性上的@Id注解
            Id idAnnotation = field.getAnnotation(Id.class);

            // 只要属性上存在@Id注解，就获取属性名
            if (idAnnotation != null) {
                idName = field.getName();
                break;
            }
        }

        return idName;
    }
}