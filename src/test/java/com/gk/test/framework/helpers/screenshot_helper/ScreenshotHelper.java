package com.gk.test.framework.helpers.screenshot_helper;


import java.util.HashMap;
import java.util.Map;

class ScreenshotHelper {


    private static final ThreadLocal<Map<String, Object>> SCREEN_SHOTS = ThreadLocal.withInitial(HashMap::new);

    public static void add(String name, byte[] image) {
        SCREEN_SHOTS.get().put(name, image.clone());
    }

    public static Map<String, Object> getScreenShotsForCurrentTest() {
        return SCREEN_SHOTS.get();
    }

    public static void tidyUpAfterTestRun() {
        SCREEN_SHOTS.remove();
    }


}
