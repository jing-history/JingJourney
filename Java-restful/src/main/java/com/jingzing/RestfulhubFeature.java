package com.jingzing;

import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public class RestfulhubFeature implements Feature {

    @Override
    public boolean configure(FeatureContext featureContext) {
        return false;
    }
}
