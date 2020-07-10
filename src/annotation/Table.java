package annotation;

import java.lang.annotation.*;

/**
 * @author XuDabin
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String tableName();
}
