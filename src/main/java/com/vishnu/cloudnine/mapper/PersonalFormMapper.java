package com.vishnu.cloudnine.mapper;

import com.vishnu.cloudnine.entity.PersonalFormEntity;
import com.vishnu.cloudnine.model.PersonalForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonalFormMapper {

    @Mapping(source = "subject", target = "title")
    PersonalForm entityToDto(PersonalFormEntity personalFormEntity);

    @Mapping(source = "title", target = "subject")
    PersonalFormEntity  toEntity(PersonalForm personalForm);
}
