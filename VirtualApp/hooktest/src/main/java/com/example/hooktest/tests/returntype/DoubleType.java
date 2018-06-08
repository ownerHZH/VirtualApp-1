package com.example.hooktest.tests.returntype;

import com.lody.hooklib.art.vposed.VposedBridge;

import com.example.hooktest.tests.LogMethodHook;
import com.example.hooktest.tests.TestCase;

/**
 * Created by weishu on 17/11/13.
 */
public class DoubleType extends TestCase {

    final double returnType = 12343748.12435;
    final double returnTypeModified = returnType - 1;

    public DoubleType() {
        super("Double");
    }

    @Override
    public void test() {


        VposedBridge.findAndHookMethod(ReturnTypeTarget.class, "returnDouble", double.class, new LogMethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult(returnTypeModified);
                super.beforeHookedMethod(param);
            }
        });
    }

    @Override
    public boolean predicate() {
        return ReturnTypeTarget.returnDouble(returnType) == returnTypeModified;
    }
}
