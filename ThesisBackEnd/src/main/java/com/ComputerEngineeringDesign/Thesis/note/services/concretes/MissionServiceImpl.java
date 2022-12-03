package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.repositories.MissionDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionDao missionDao;

    @Override
    public List<MissionResponseDto> getAllMissionsByNoteSectionId(Long noteSectionId) {
        return null;
    }

    @Override
    public MissionResponseDto getOneMission(Long id) {
        return null;
    }

    @Override
    public MissionResponseDto createOneMission(Long noteSectionId, MissionSaveRequestDto missionSaveRequestDto) {
        return null;
    }

    @Override
    public MissionResponseDto updateOneMission(Long id, MissionUpdateRequestDto missionUpdateRequestDto) {
        return null;
    }

    @Override
    public void deleteOneMissionById(Long id) {

    }
}
