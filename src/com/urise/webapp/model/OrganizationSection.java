package com.urise.webapp.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@XmlAccessorType(XmlAccessType.FIELD)
public class OrganizationSection extends Section {
    private static final long serialVersionUID = 1L;
    private List<Organisation> organisations;

    public OrganizationSection() {
    }

    public OrganizationSection(Organisation... organisation) {
        this(Arrays.asList(organisation));
    }

    public OrganizationSection(List<Organisation> organisations) {
        Objects.requireNonNull(organisations, "organisations must not be null");
        this.organisations = organisations;
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganizationSection that = (OrganizationSection) o;

        return organisations.equals(that.organisations);
    }

    @Override
    public int hashCode() {
        return organisations.hashCode();
    }

    @Override
    public String toString() {
        return organisations.toString();
    }
}
