package com.ComputerEngineeringDesign.Thesis.note.converters;

import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Optional;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MissionMapper {
    MissionMapper INSTANCE = Mappers.getMapper(MissionMapper.class);

    @Mapping(source = "noteSection.id", target="noteSectionId")
    MissionResponseDto mapMissionToMissionResponseDto(Mission mission);

    List<MissionResponseDto> mapMissionListToMissionResponseDtoList(List<Mission> missionList);
}
