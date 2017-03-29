package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.constant.Name;
import com.netcracker.labs.veromeyev.tourism.entity.EntityFactory;
import com.netcracker.labs.veromeyev.tourism.entity.place.MedicalCenter;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;
import com.netcracker.labs.veromeyev.tourism.util.json.JsonWithType;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class Treatment implements VoucherType {

    private MedicalCenter medicalCenter;

    public Treatment(MedicalCenter center) {
        this.medicalCenter = center;
    }

    public Treatment(Treatment treatment) {
        this(treatment.getMedicalCenter());
    }

    public Treatment(JSONObject o) {
        EntityFactory factory = new EntityFactory();
        medicalCenter = (MedicalCenter) factory.newPlace(
                (JSONObject)o.get("medical center"));
    }

    public MedicalCenter getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenter medicalCenter) {
        if (medicalCenter == null) medicalCenter = new MedicalCenter();
        this.medicalCenter = medicalCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ( !(o instanceof Treatment)) {
            return false;
        }
        Treatment treatment = (Treatment) o;
        return medicalCenter.equals(treatment.getMedicalCenter());
    }

    @Override
    public int hashCode() {
        return medicalCenter.hashCode();
    }

    @Override
    public String toString() {
        return "Treatment at " + medicalCenter.toString();
    }

    @Override
    public String getFullDescription() {
        return toString();
    }

    @Override
    public List<Place> getPlaces() {
        return new ArrayList<Place>(){{
            add(medicalCenter);
        }};
    }

    @Override
    public JSONObject toJSONObject(){
        JSONObject object = new JSONObject();
        object.put("medical center", medicalCenter.toJSONObject());
        return new JsonWithType(object,
                Name.Entity.VoucherType.TREATMENT).getObject();
    }
}
