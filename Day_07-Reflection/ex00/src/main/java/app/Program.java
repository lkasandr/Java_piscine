package app;

import classes.User;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public class Program{
    final static private String packageName = "classes";
    private static List<Class<?>> classes;
    private static Class<?> printClass;
    private static Field[] fields;
    private static Method[] methods;
    private static Object obj;


    public static void main(String[] args){
        classes = getAllClassesFrom(packageName);
        printExistsClass();
        System.out.println("---------------------");
        System.out.println("Enter class name:");
        Scanner in = new Scanner(System.in);
        try {
            printClass = Class.forName(packageName + "." + in.nextLine());
            printClassFields();
            printClassMethods();
            System.out.println("---------------------");
            printCreateObject();
            System.out.println("---------------------");
            printChangeFields();
            System.out.println("---------------------");
            printCallingMethod();
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Class not found");
        }
    }

    private static void printCallingMethod()
    {
        try {
            List<Object> newParam = new ArrayList<>();
            System.out.println("Enter name of the method for call:");
            Scanner in = new Scanner(System.in);
            String methodName = in.nextLine();
            for (Method m : methods) {
                if (m.getName().equals(methodName)) {
                    m.setAccessible(true);
                    Parameter[] parameters = m.getParameters();
                    for (Parameter p : parameters) {
                        System.out.println("Enter " + p.getType().getSimpleName() + " value:");
                        newParam.add(convertedInput(p.getType().getSimpleName(), in.next()));
                    }
                    Object result = m.invoke(obj, newParam.toArray());
                    System.out.println("Method returned:");
                    System.out.println(result);
                    return;
                }
            }
        }
        catch( IllegalAccessException | IllegalArgumentException | InvocationTargetException e)
        {
            e.printStackTrace();
        }
        System.out.println("Method not found");

    }

    private static void printChangeFields()
    {
        try {
            System.out.println("Enter name of the field for changing:");
            Scanner in = new Scanner(System.in);
            String fieldName = in.nextLine();
            for (Field f : fields) {
                if (f.getName().equals(fieldName)) {
                    f.setAccessible(true);
                    System.out.println("Enter " + f.getType().getSimpleName() + " value:");
                    f.set(obj, convertedInput(f.getType().getSimpleName(), in.next()));
                    System.out.println("Object updated: " + obj.toString());
                    return;
                }
            }
        }
        catch (IllegalAccessException | IllegalArgumentException iae)
        {
            iae.printStackTrace();
        }
        System.out.println("Field not found");
    }

    private static void printCreateObject()
    {
        System.out.println("Let's create an object.");
        try {
            obj = printClass.newInstance();
            for(Field f : fields)
            {
                f.setAccessible(true);
                System.out.println(f.getName() + ":");
                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                f.set(obj, convertedInput(f.getType().getSimpleName(), input));
            }
            System.out.println("Object created: " + obj.toString());
        }
        catch (InstantiationException ie)
        {
            ie.printStackTrace();
        }
        catch (IllegalAccessException iae)
        {
            iae.printStackTrace();
        }
    }

    private static Object convertedInput(String fieldType, String inputType)
    {
        switch (fieldType)
        {
            case "String":
                return inputType;
            case "Byte":
                return Byte.parseByte(inputType);
            case "Short":
                return Short.parseShort(inputType);
            case "int":
            case "Integer":
                return Integer.parseInt(inputType);
            case "Long":
                return Long.parseLong(inputType);
            case "Float":
                return Float.parseFloat(inputType);
            case "Double":
                return Double.parseDouble(inputType);
        }
        return null;
    }

    private static void printClassMethods() {
        for (Class c : classes)
        {
            if (c.getSimpleName().equals(printClass.getSimpleName()))
            {
                System.out.println("Methods :");
                methods = printClass.getDeclaredMethods();
                if (methods.length != 0) {
                    for(Method m : methods)
                    {
                        Class[] parameterTypes = m.getParameterTypes();
                        StringJoiner parameters = new StringJoiner(", ", "(", ")");
                        for(Class type : parameterTypes)
                            parameters.add(type.getSimpleName());
                        System.out.println(m.getReturnType().getSimpleName() + " " + m.getName() + parameters);
                    }
                }
                else
                    System.out.println("No methods");
                return;
            }
        }
    }

    private static void printClassFields() {
        for(Class c : classes)
        {
            if (c.getSimpleName().equals(printClass.getSimpleName()))
            {
                System.out.println("---------------------");
                System.out.println("Private fields :");
                fields = printClass.getDeclaredFields();
                if (fields.length != 0) {
                    for(Field f: fields)
                        System.out.println(f.getType().getSimpleName() + " " + f.getName());
                }
                else
                    System.out.println("No private fields");
                return;
            }
        }
    }

    private static void printExistsClass()
    {
        System.out.println("Classes:");
        for(Class c : classes)
            System.out.println(c.getSimpleName());
    }

    private static List<Class<?>> getAllClassesFrom(String packageName) {
        return new Reflections(packageName, new SubTypesScanner(false))
                .getAllTypes()
                .stream()
                .map(name -> {
                    try {
                        return Class.forName(name);
                    } catch (ClassNotFoundException e) {
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}