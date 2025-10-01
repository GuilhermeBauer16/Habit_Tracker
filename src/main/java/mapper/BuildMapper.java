package mapper;


import br.com.HabitTracker.exception.FieldNotFoundException;

import java.lang.reflect.Field;

public class BuildMapper {

    private static final String FIELD_NOT_FOUND = "Failed to access field with the name: ";


    public <T, S> T parseObject(T target, S source) {
        Class<?> targetClass = target.getClass();
        Class<?> sourceClass = source.getClass();
        Field[] sourceFields = sourceClass.getDeclaredFields();

        for (Field sourceField : sourceFields) {
            sourceField.setAccessible(true);
            Object value;
            try {
                value = sourceField.get(source);
            } catch (IllegalAccessException e) {

                throw new FieldNotFoundException(FIELD_NOT_FOUND + sourceField.getName());
            }

            if (value != null && !sourceField.getName().equals("serialVersionUID")) {


                try {
                    Field targetField = targetClass.getDeclaredField(sourceField.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                } catch (NoSuchFieldException | IllegalAccessException e) {


                }
            }
        }

        return target;
    }


}



