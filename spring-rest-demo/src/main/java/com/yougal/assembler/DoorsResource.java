package com.yougal.assembler;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;


@XmlRootElement(name = "door")
public class DoorsResource extends ResourceSupport {

    @XmlElement(name = "door")
    public volatile Set<DoorResource> doors = new HashSet<DoorResource>();
}