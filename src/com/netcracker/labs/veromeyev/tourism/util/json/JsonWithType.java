package com.netcracker.labs.veromeyev.tourism.util.json;

import org.json.simple.JSONObject;

/**
 * Class to convert JSONObject from objects of different classes
 * to JSONObject, which contains field "type" with name of this class
 * So whole object is like this:  {"type":"..smth like type..",
 * "inner oobject":{here is inner object}}. It helps to cope with
 * polymorphism of class fields: default JSON doesn't keep class, object of
 * which it converts.
 * Created by jack on 26/03/17.
 */

public class JsonWithType {

    private static final String TYPE = "type";
    private static final String INNER_OBJECT = "inner object";

    private final JSONObject object;

    /**
     * Constructor to transfer from whole object
     * to separate innerObject and type
     * @param object JSON object with content
     *               {"type":"%type%",
     *               "inner object":{%content_inner_object%}}
     *
     */
    public JsonWithType(JSONObject object) {
        this.object = object;
    }

    /**
     * Constructor to transfer from innerObject and its type to whole object
     * @param innerObject transferred to JSONObject object
     * @param type string with type of the source object
     */
    public JsonWithType(JSONObject innerObject, String type) {
        this.object = new JSONObject();
        this.getObject().put(TYPE, type);
        this.getObject().put(INNER_OBJECT, innerObject);
    }


    public JSONObject getInnerObject() {
        return (JSONObject) this.getObject().get(INNER_OBJECT);
    }

    public String getType() {
        return (String) this.getObject().get(TYPE);
    }

    public void setType(String type) {
        this.object.put(TYPE, type);
    }

    public JSONObject getObject() {
        return object;
    }
}
