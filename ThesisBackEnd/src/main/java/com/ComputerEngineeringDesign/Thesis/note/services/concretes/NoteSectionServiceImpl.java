package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.note.converters.NoteSectionMapper;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import com.ComputerEngineeringDesign.Thesis.note.repositories.NoteSectionDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.NoteSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteSectionServiceImpl implements NoteSectionService {
    private final NoteSectionDao noteSectionDao;

    @Override
    public List<NoteSectionResponseDto> getAllNoteSections() {
        List<NoteSection> noteSectionList =  noteSectionDao.findAll();
        List<NoteSectionResponseDto> noteSectionResponseDtoList = NoteSectionMapper.INSTANCE.mapNoteSectionListToNoteSectionResponseDtoList(noteSectionList);
        return noteSectionResponseDtoList;
    }

    @Override
    public NoteSectionResponseDto getOneNoteSection(Long id) {
        if(!checkIfItExists(id)){
            // throw
        }
        NoteSection noteSection = noteSectionDao.getReferenceById(id);
        NoteSectionResponseDto noteSectionResponseDto = NoteSectionMapper.INSTANCE.mapNoteSectionToNoteSectionResponseDto(noteSection);
        return noteSectionResponseDto;
    }

    @Override
    public NoteSectionResponseDto createOneNoteSection(NoteSectionSaveRequestDto noteSectionSaveRequestDto) {
        NoteSection noteSection = NoteSectionMapper.INSTANCE.mapNoteSectionSaveRequestDtoToNoteSection(noteSectionSaveRequestDto);
        noteSection = noteSectionDao.save(noteSection);
        NoteSectionResponseDto noteSectionResponseDto = NoteSectionMapper.INSTANCE.mapNoteSectionToNoteSectionResponseDto(noteSection);
        return noteSectionResponseDto;
    }

    @Override
    public NoteSectionResponseDto updateOneNoteSection(Long id, NoteSectionUpdateRequestDto noteSectionUpdateRequestDto) {
        return null;
    }

    @Override
    public void deleteOneSectionById(Long id) {

    }
    private boolean checkIfItExists(Long id){
        Optional<NoteSection>  noteSection = noteSectionDao.findById(id);
        if(noteSection.isPresent()){
            return true;
        }
        return false;
    }

}
