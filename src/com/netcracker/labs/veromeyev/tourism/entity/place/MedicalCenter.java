package com.netcracker.labs.veromeyev.tourism.entity.place;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class MedicalCenter extends Place {

    private List<String> treatmentPrograms;

    public MedicalCenter(Address address, String placeName, String description,
                List<String> treatmentPrograms) {
        super(address, placeName, description);
        this.treatmentPrograms = treatmentPrograms;
    }

    public MedicalCenter(Place place, List<String> treatmentPrograms) {
        super(place);
        this.treatmentPrograms = treatmentPrograms;
    }

    public MedicalCenter(MedicalCenter medicalCenter) {
        this(medicalCenter.getAddress(), medicalCenter.getPlaceName(),
                medicalCenter.getDescription(),
                medicalCenter.getTreatmentPrograms());
    }

    public MedicalCenter() {
        this(new Address(), "", "", new ArrayList<>());
    }

    public MedicalCenter(JSONObject o) {
        super(o);
        JSONArray jsonStock = (JSONArray) o.get("treatment programs");
        treatmentPrograms = new ArrayList<>( jsonStock.size());
        for (Object program : jsonStock) {
            treatmentPrograms.add((String) program);
        }
    }

    public List<String> getTreatmentPrograms() {
        return treatmentPrograms;
    }

    public void setTreatmentPrograms(List<String> treatmentPrograms) {
        this.treatmentPrograms = treatmentPrograms;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MedicalCenter)) {
            return false;
        }
        MedicalCenter center = (MedicalCenter) o;
        return super.equals(o)
                && treatmentPrograms.equals(center.getTreatmentPrograms());
    }

    public int hashCode() {
        return (super.hashCode() << 1) + treatmentPrograms.hashCode();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (placeName.length() > 0) {
            builder.append("Medical center ");
        }
        builder.append(super.toString());
        if (treatmentPrograms.size() > 0) {
            builder.append(". Treatment program(s): ");
            boolean firstElement = true;
            for (String thingType : treatmentPrograms) {
                if (firstElement) {
                    firstElement = false;
                } else {
                    builder.append(", ");
                }
                builder.append(thingType);
            }
        }
        return builder.toString();
    }

    @Override
    public JSONObject toJSONObject() {
        // call Place.toJSONObject
        JsonWithType objectWithType = new JsonWithType(super.toJSONObject());
        JSONArray programArray = new JSONArray();
        for (String program : treatmentPrograms) {
            programArray.add(program);
        }
        objectWithType.getInnerObject().put("treatment programs",
                programArray);
        // override type of superclass
        objectWithType.setType(Name.Entity.Place.MEDICAL_CENTER);
        return objectWithType.getObject();
    }

}
