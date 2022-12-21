package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.note.converters.MissionMapper;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import com.ComputerEngineeringDesign.Thesis.note.entities.NoteSection;
import com.ComputerEngineeringDesign.Thesis.note.repositories.MissionDao;
import com.ComputerEngineeringDesign.Thesis.note.repositories.NoteSectionDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionDao missionDao;
    private final NoteSectionDao noteSectionDao;


    @Override
    public List<MissionResponseDto> getAllMissionsByNoteSectionId(Long noteSectionId) {
        Optional<List<Mission>> missionList =  missionDao.findAllByNoteSection_Id(noteSectionId);
        if(!missionList.isPresent()){
            // throw
            System.out.println("note section yok!");
        }
        List<MissionResponseDto> missionResponseDtoList = MissionMapper.INSTANCE.mapMissionListToMissionResponseDtoList(missionList.get());
        return missionResponseDtoList;
    }

    @Override
    public MissionResponseDto getOneMission(Long id) {
        Optional<Mission> mission =  missionDao.findById(id);
        if(!mission.isPresent()){
            // throw
        }
        MissionResponseDto missionResponseDto =  MissionMapper.INSTANCE.mapMissionToMissionResponseDto(mission.get());
        return missionResponseDto;
    }

    @Override
    public MissionResponseDto createOneMission(Long noteSectionId, MissionSaveRequestDto missionSaveRequestDto) {
        Optional<NoteSection> noteSection = noteSectionDao.findById(noteSectionId);
        if(!noteSection.isPresent()){
            //throw
        }
        if(noteSectionId != missionSaveRequestDto.getNoteSectionId()){
            //throw
        }
        Mission mission =  MissionMapper.INSTANCE.mapMissionSaveRequestDtoToMission(missionSaveRequestDto);
        mission = missionDao.save(mission);
        MissionResponseDto missionResponseDto =  MissionMapper.INSTANCE.mapMissionToMissionResponseDto(mission);
        return missionResponseDto;
    }

    @Override
    public MissionResponseDto updateOneMission(Long id, MissionUpdateRequestDto missionUpdateRequestDto) {
        return null;
    }

    @Override
    public void deleteOneMissionById(Long id) {
        Optional<Mission> mission =  missionDao.findById(id);
        if(mission.isPresent()){
            missionDao.deleteById(id);
        }
    }
}
