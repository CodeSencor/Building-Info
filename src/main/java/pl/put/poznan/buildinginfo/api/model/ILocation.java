package pl.put.poznan.buildinginfo.api.model;

import pl.put.poznan.buildinginfo.logic.IVisitor;

public interface ILocation {
    String getId();

    String getName();

    double acceptVisitor(IVisitor visitor);
}
