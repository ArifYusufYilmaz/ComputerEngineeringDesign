package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.repositories.NoteSectionDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.NoteSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteSectionServiceImpl implements NoteSectionService {
    private final NoteSectionDao noteSectionDao;

    @Override
    public List<NoteSectionResponseDto> getAllNoteSections() {
        return null;
    }

    @Override
    public NoteSectionResponseDto getOneNoteSection(Long id) {
        return null;
    }

    @Override
    public NoteSectionResponseDto createOneNoteSection(NoteSectionSaveRequestDto noteSectionSaveRequestDto) {
        return null;
    }

    @Override
    public NoteSectionResponseDto updateOneNoteSection(Long id, NoteSectionUpdateRequestDto noteSectionUpdateRequestDto) {
        return null;
    }

    @Override
    public void deleteOneSectionById(Long id) {

    }
}
