package com.spicejet.utils;

import com.spicejet.core.PropertyReader;
import com.spicejet.core.PropKey;

import java.io.IOException;

public class TimeUtil {
    public static Long getImplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance().getProp(PropKey.IMPLICIT_WAIT.getPropVal()));
    }

    public static Long getExplicitWait() throws IOException {
        return Long.parseLong(PropertyReader.getInstance().getProp(PropKey.EXPLICIT_WAIT.getPropVal()));
    }
}
