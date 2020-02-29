package com.yaoxj.myenum;

import java.io.Serializable;
import java.util.Map;

public interface ValueEnum<T> extends Serializable {

	T value();

	default T value(Map params){ return null; }

	default String getName(){ return ""; }
}