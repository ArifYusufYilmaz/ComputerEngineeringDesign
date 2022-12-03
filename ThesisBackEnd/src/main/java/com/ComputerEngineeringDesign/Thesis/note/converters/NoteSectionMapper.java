package com.ComputerEngineeringDesign.Thesis.note.converters;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NoteSectionMapper {
    NoteSectionMapper INSTANCE = Mappers.getMapper(NoteSectionMapper.class);



}
