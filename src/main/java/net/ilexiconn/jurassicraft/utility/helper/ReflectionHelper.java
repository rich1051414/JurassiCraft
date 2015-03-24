package net.ilexiconn.jurassicraft.utility.helper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author ProPercivalalb
 */
public class ReflectionHelper
{
    public static Class getClassForName(String name)
    {
        try
        {
            return Class.forName(name);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public static void invokeMethod(Class clazz, Object instance, String name, Object... params)
    {
        Class[] paramTypes = new Class[params.length];
        
        for (int i = 0; i < params.length; i++)
        {
            paramTypes[i] = params[i].getClass();
        }
        
        Method method = getMethod(clazz, name, paramTypes);
        
        try
        {
            method.invoke(instance, params);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static Method getMethod(Class clazz, String name, Class... params)
    {
        Method method = null;
        
        try
        {
            method = clazz.getDeclaredMethod(name, params);
            method.setAccessible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return method;
    }
    
    public static Field getField(Class<?> clazz, int fieldIndex)
    {
        try
        {
            Field field = clazz.getDeclaredFields()[fieldIndex];
            
            field.setAccessible(true);
            
            return field;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            
            return null;
        }
    }
    
    public static Field getField(Class<?> clazz, String fieldIndex)
    {
        try
        {
            Field field = clazz.getDeclaredField(fieldIndex);
            field.setAccessible(true);
            
            return field;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Gets the object a field holds
     * @param clazz The class the field is in
     * @param fieldType The object the field contains
     * @param instance The instance
     * @param fieldName The field name
     * @return The object that the class contains
     */
    public static <T> T getField(Class<?> clazz, Class<T> fieldType, Object instance, int fieldIndex)
    {
        try
        {
            Field field = getField(clazz, fieldIndex);
           
            return (T) field.get(instance);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Gets the object a field holds
     * @param clazz The class the field is in
     * @param fieldType The object the field contains
     * @param instance The instance
     * @param fieldName The field name
     * @return The object that the class contains
     */
    public static <T> T getField(Class<?> clazz, Class<T> fieldType, Object instance, String fieldName)
    {
        try
        {
            Field field = getField(clazz, fieldName);
            
            return (T) field.get(instance);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return null;
    }
    
    /**
     * Sets a field to the giving values.
     * @param field The target field
     * @param instance The instance
     * @param value The value to set the field to
     */
    public static void setField(Field field, Object instance, Object value)
    {
        try
        {
            field.set(instance, value);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
    
    public static void setField(Class<?> clazz, Object instance, int fieldIndex, Object value)
    {
        try
        {
            Field field = getField(clazz, fieldIndex);
          
            field.set(instance, value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void setField(Class<?> clazz, Object instance, String fieldName, Object value)
    {
        try
        {
            Field field = getField(clazz, fieldName);
            field.set(instance, value);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
