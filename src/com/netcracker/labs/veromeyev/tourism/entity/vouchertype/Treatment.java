package com.netcracker.labs.veromeyev.tourism.entity.vouchertype;

import com.netcracker.labs.veromeyev.tourism.entity.place.MedicalCenter;
import com.netcracker.labs.veromeyev.tourism.entity.place.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 22/03/17.
 */
public class Treatment extends VoucherType {

    private MedicalCenter medicalCenter;

    public Treatment(MedicalCenter center) {
        setMedicalCenter(center);
    }

    public Treatment(Treatment treatment) {
        this(treatment.getMedicalCenter());
    }

    public MedicalCenter getMedicalCenter() {
        return medicalCenter;
    }

    public void setMedicalCenter(MedicalCenter medicalCenter) {
        if (medicalCenter == null) medicalCenter = new MedicalCenter();
        this.medicalCenter = medicalCenter;
    }

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

    public int hashCode() {
        return medicalCenter.hashCode();
    }

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
}
