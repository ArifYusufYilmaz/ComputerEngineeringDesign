package com.ComputerEngineeringDesign.Thesis.note.controllers;

import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @GetMapping("/all/{noteSectionId}")
    public List<MissionResponseDto> getAllMissionsByNoteSectionId(@PathVariable Long noteSectionId){
        return missionService.getAllMissionsByNoteSectionId(noteSectionId);
    }
    @GetMapping("/{id}")        // could be diverse
    public MissionResponseDto getOneMission(@PathVariable Long id){
        return missionService.getOneMission(id);
    }
    @PostMapping("/{noteSectionId}")
    public MissionResponseDto createOneMission(@PathVariable Long noteSectionId,@RequestBody MissionSaveRequestDto missionSaveRequestDto){
        return missionService.createOneMission(noteSectionId, missionSaveRequestDto);
    }
    @PutMapping("/{id}")
    public MissionResponseDto updateOneMission(@PathVariable Long id, @RequestBody MissionUpdateRequestDto missionUpdateRequestDto){
        return missionService.updateOneMission(id, missionUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    public void deleteOneMissionById(@PathVariable Long id){
        missionService.deleteOneMissionById(id);
    }
}
