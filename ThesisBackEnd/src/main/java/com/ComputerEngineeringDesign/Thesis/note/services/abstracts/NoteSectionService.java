package com.ComputerEngineeringDesign.Thesis.note.services.abstracts;

import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionUpdateRequestDto;

import java.util.List;

public interface NoteSectionService {
    List<NoteSectionResponseDto> getAllNoteSectionsByUserId(Long userId);

    NoteSectionResponseDto getOneNoteSection(Long id);

    NoteSectionResponseDto createOneNoteSection(Long userId,NoteSectionSaveRequestDto noteSectionSaveRequestDto);

    NoteSectionResponseDto updateOneNoteSection(Long id, NoteSectionUpdateRequestDto noteSectionUpdateRequestDto);

    void deleteOneSectionById(Long id);
}
