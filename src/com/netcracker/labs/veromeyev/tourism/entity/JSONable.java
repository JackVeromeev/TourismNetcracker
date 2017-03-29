package com.netcracker.labs.veromeyev.tourism.entity;

import org.json.simple.JSONObject;

/**
 * defines ability to create a JSONObject with content of this object
 * Created by jack on 26/03/17.
 */
public interface JSONable {
    JSONObject toJSONObject();
}