package com.ComputerEngineeringDesign.Thesis.note.converters;

import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NoteSectionMapper {
    NoteSectionMapper INSTANCE = Mappers.getMapper(NoteSectionMapper.class);

    List<NoteSectionResponseDto> mapNoteSectionListToNoteSectionResponseDtoList(List<NoteSection> noteSectionList);

    @Mapping(source="user.id", target="userId")
    NoteSectionResponseDto mapNoteSectionToNoteSectionResponseDto(NoteSection noteSection);

    @Mapping(source="userId", target="user.id")
    NoteSection mapNoteSectionSaveRequestDtoToNoteSection(NoteSectionSaveRequestDto noteSectionSaveRequestDto);
}
