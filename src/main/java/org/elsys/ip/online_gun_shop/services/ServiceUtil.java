package org.elsys.ip.online_gun_shop.services;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ServiceUtil {
    public static <T> T updateFields(T base, T other) {
        Field[] baseFields = base.getClass().getDeclaredFields();

        Arrays.stream(baseFields).forEach(field -> {
            try {
                Object fieldValue = base.getClass().getDeclaredField(field.getName()).get(base);
                other.getClass().getDeclaredField(field.getName()).set(other, fieldValue);
            } catch (IllegalAccessException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        });

        return other;
    }
}
