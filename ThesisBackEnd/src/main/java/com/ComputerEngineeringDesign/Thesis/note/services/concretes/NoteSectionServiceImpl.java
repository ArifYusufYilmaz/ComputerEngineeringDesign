package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.generic.exceptions.BaseErrorMessage;
import com.ComputerEngineeringDesign.Thesis.generic.exceptions.BusinessException;
import com.ComputerEngineeringDesign.Thesis.generic.exceptions.ItemNotFoundException;
import com.ComputerEngineeringDesign.Thesis.note.converters.NoteSectionMapper;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import com.ComputerEngineeringDesign.Thesis.note.repositories.NoteSectionDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.NoteSectionService;
import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import com.ComputerEngineeringDesign.Thesis.user.enums.UserErrorMessage;
import com.ComputerEngineeringDesign.Thesis.user.repositories.UserDao;
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
    private final UserDao userDao;
    @Override
    public List<NoteSectionResponseDto> getAllNoteSectionsByUserId(Long userId) {
        if(userId == null){
            throw new ItemNotFoundException(UserErrorMessage.USER_DOES_NOT_EXIST);
        }

        Optional<List<NoteSection>> noteSectionList =  noteSectionDao.findAllByUserId(userId);
        if(!noteSectionList.isPresent()){
            //throw
        }
        List<NoteSectionResponseDto> noteSectionResponseDtoList = NoteSectionMapper.INSTANCE.mapNoteSectionListToNoteSectionResponseDtoList(noteSectionList.get());
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
    public NoteSectionResponseDto createOneNoteSection(Long userId, NoteSectionSaveRequestDto noteSectionSaveRequestDto) {
        if(userId == null){
            //throw
        }
        Optional<User> user = userDao.findById(userId);
        if(!user.isPresent()){
            //throw
        }
        if(userId != noteSectionSaveRequestDto.getUserId()){
            //throw
        }
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
        // check and throw
        noteSectionDao.deleteById(id);
    }
    private boolean checkIfItExists(Long id){
        Optional<NoteSection>  noteSection = noteSectionDao.findById(id);
        if(noteSection.isPresent()){
            return true;
        }
        return false;
    }

}
