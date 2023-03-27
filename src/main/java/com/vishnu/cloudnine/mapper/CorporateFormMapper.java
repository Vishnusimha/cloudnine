package com.vishnu.cloudnine.mapper;

import com.vishnu.cloudnine.entity.CorporateFormEntity;
import com.vishnu.cloudnine.model.CorporateForm;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CorporateFormMapper {

    @Mapping(source = "subject", target = "title")
    CorporateForm entityToDto(CorporateFormEntity corporateFormEntity);

    @Mapping(source = "title", target = "subject")
    CorporateFormEntity toEntity(CorporateForm corporateForm);
}
