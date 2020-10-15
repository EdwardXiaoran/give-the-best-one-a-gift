package com.android.cglib.proxy;

public class Const {
    public static final String SUBCLASS_INVOKE_SUPER_SUFFIX = "_Super";
    public static final String SUBCLASS_SUFFIX = "_Enhancer";

    public static Class getPackedType(Class cls) {
        return cls == Boolean.TYPE ? Boolean.class : cls == Byte.TYPE ? Byte.class : cls == Character.TYPE ? Character.class : cls == Double.TYPE ? Double.class : cls == Float.TYPE ? Float.class : cls == Integer.TYPE ? Integer.class : cls == Long.TYPE ? Long.class : cls == Short.TYPE ? Short.class : cls;
    }

    public static String getPrimitiveValueMethodName(Class cls) {
        if (cls == Boolean.TYPE) {
            return "booleanValue";
        }
        if (cls == Byte.TYPE) {
            return "byteValue";
        }
        if (cls == Character.TYPE) {
            return "charValue";
        }
        if (cls == Double.TYPE) {
            return "doubleValue";
        }
        if (cls == Float.TYPE) {
            return "floatValue";
        }
        if (cls == Integer.TYPE) {
            return "intValue";
        }
        if (cls == Long.TYPE) {
            return "longValue";
        }
        if (cls == Short.TYPE) {
            return "shortValue";
        }
        throw new ProxyException(cls.getName() + " dit not primitive class");
    }
}
