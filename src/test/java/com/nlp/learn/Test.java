package com.nlp.learn;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import io.netty.handler.codec.http.HttpMethod;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String python = "E:\\workspace\\project\\NLP-Test\\src\\main\\java\\com\\nlp\\learn\\downloadImg\\test14.py";

        Properties props = new Properties();
        props.put("python.home", "C:\\Users\\ww\\.m2\\repository\\org\\python\\jython\\2.7.0");
        props.put("python.console.encoding", "UTF-8");

        props.put("python.security.respectJavaAccessibility", "false");

        props.put("python.import.site", "false");

        Properties preprops = System.getProperties();

        PythonInterpreter.initialize(preprops, props, new String[0]);

        PythonInterpreter interp = new PythonInterpreter();
        interp.execfile(python);
        interp.exec("import requests");
        interp.exec("import time");
        interp.exec("import datetime");
        interp.exec("import os");
        interp.exec("import json");
        interp.exec("import uuid");
        interp.exec("from pyquery import PyQuery as pq");

        PyFunction pyFunction = interp.get("main", PyFunction.class);
        PyObject  pyObject = pyFunction.__call__();
        interp.cleanup();
        interp.close();

    }
}
