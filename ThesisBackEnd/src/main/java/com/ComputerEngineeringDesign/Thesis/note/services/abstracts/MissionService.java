package com.ComputerEngineeringDesign.Thesis.note.services.abstracts;

import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionUpdateRequestDto;

import java.util.List;

public interface MissionService {
    List<MissionResponseDto> getAllMissionsByNoteSectionId(Long noteSectionId);

    MissionResponseDto getOneMission(Long id);

    MissionResponseDto createOneMission(Long noteSectionId, MissionSaveRequestDto missionSaveRequestDto);

    MissionResponseDto updateOneMission(Long id, MissionUpdateRequestDto missionUpdateRequestDto);

    void deleteOneMissionById(Long id);
}
