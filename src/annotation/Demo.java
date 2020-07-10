package annotation;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Field;

/**
 * @author XuDabin
 * @description
 * @create 2020-07-10 10:00
 */
public class Demo {
    public static void main(String[] args) {
        String sql = getSql();
        System.out.println(sql);
    }

    public static String getSql() {
        Class<ReUser> reUserClass = ReUser.class;
        StringBuffer sb = new StringBuffer("create table ");
        Class<User> userClass = User.class;
        Table table = userClass.getAnnotation(Table.class);
        sb.append(table.tableName() + "(\n");

        Field[] fields = userClass.getDeclaredFields();
        if (fields.length > 0) {
            for (Field f : fields) {
                if (f.isAnnotationPresent(Column.class)) {
                    Column column = f.getAnnotation(Column.class);
                    sb.append("\t" + column.value() + " ");
                    sb.append(column.type() + "(" + column.length() + ") ");
                    sb.append("COMMENT '" + column.COMMENT() + "',");
                }
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append("\n)");
        return sb.toString();
    }
}
