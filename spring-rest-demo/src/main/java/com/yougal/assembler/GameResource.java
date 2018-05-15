package com.yougal.assembler;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.hateoas.ResourceSupport;

import com.yougal.domain.Game.GameStatus;

@XmlRootElement(name = "game")
public final class GameResource extends ResourceSupport {

    @XmlAttribute
    public volatile GameStatus status;

}
