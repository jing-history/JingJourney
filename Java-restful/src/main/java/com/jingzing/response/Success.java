package com.jingzing.response;

import com.jingzing.response.status.Created;
import com.jingzing.response.status.Deleted;
import com.jingzing.response.status.Updated;

/**
 * Created by Louis Wang on 2016/5/20.
 */

public class Success {
    public final static Created Created = new Created();
    public final static Deleted Deleted = new Deleted();
    public final static Updated Updated = new Updated();
}
