package com.vishnu.cloudnine.mapper;

import com.vishnu.cloudnine.entity.PersonalEventFormEntity;
import com.vishnu.cloudnine.model.PersonalEventForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonalEventFormMapper {

    @Mapping(source = "subject", target = "title")
    PersonalEventForm entityToDto(PersonalEventFormEntity personalEventFormEntity);

    @Mapping(source = "title", target = "subject")
    PersonalEventFormEntity toEntity(PersonalEventForm personalEventForm);
}
