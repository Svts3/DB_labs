package ua.lviv.iot.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "owner", collectionRelation = "owners")
public class OwnerDTO extends RepresentationModel<OwnerDTO> {

    private final Long id;

    private final String firstName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String gender;
}
