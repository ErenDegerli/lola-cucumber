package com.lolafloraCucumber.utils;

import com.lolafloraCucumber.core.PropKey;
import com.lolafloraCucumber.core.PropertyReader;

import java.io.IOException;

public class TimeUtil {

    public static Long getImplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    public static Long getExplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance().getProperty(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
