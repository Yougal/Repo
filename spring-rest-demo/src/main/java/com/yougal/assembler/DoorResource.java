package com.yougal.assembler;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.yougal.domain.Door.DoorContent;
import com.yougal.domain.Door.DoorStatus;

@XmlRootElement(name = "door")
public class DoorResource extends ResourceSupport {

    @XmlAttribute
    public volatile DoorContent content;

    @XmlAttribute
    public volatile DoorStatus status;

}
