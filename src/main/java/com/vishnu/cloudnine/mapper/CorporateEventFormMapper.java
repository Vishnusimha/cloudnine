package com.vishnu.cloudnine.mapper;

import com.vishnu.cloudnine.entity.CorporateEventFormEntity;
import com.vishnu.cloudnine.model.CorporateEventForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CorporateEventFormMapper {

    @Mapping(source = "subject", target = "title")
    CorporateEventForm entityToDto(CorporateEventFormEntity corporateEventFormEntity);

    @Mapping(source = "title", target = "subject")
    CorporateEventFormEntity toEntity(CorporateEventForm corporateEventForm);
}
