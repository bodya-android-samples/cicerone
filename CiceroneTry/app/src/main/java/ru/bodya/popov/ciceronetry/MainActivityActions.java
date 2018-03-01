package ru.bodya.popov.ciceronetry;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.SOURCE;
import static ru.bodya.popov.ciceronetry.MainActivityActions.JAVA_ACTION;
import static ru.bodya.popov.ciceronetry.MainActivityActions.KOTLIN_ACTION;

@Retention(SOURCE)
@StringDef({
        JAVA_ACTION,
        KOTLIN_ACTION
})
public @interface MainActivityActions {
    String JAVA_ACTION = "java";
    String KOTLIN_ACTION = "kotlin";
}

