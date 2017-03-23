package com.netcracker.labs.veromeyev.tourism.entity.place;

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
        setTreatmentPrograms(treatmentPrograms);
    }

    public MedicalCenter(MedicalCenter medicalCenter) {
        this(medicalCenter.getAddress(), medicalCenter.getPlaceName(),
                medicalCenter.getDescription(),
                medicalCenter.getTreatmentPrograms());
    }

    public MedicalCenter() {
        this(new Address(), "", "", new ArrayList<>());
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
            builder.append("Shop ");
        }
        builder.append(super.toString());
        if (treatmentPrograms.size() > 0) {
            builder.append(" Treatment program(s): ");
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

}
