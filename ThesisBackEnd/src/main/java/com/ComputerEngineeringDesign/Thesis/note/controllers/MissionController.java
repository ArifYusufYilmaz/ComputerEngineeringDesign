package com.ComputerEngineeringDesign.Thesis.note.controllers;

import com.ComputerEngineeringDesign.Thesis.generic.response.RestResponse;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.missionDtos.MissionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.MissionService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/missions")
@RequiredArgsConstructor
public class MissionController {
    private final MissionService missionService;

    @GetMapping("/all/{noteSectionId}")
    public ResponseEntity getAllMissionsByNoteSectionId(@PathVariable Long noteSectionId){
        List<MissionResponseDto> missionResponseDtoList = missionService.getAllMissionsByNoteSectionId(noteSectionId);
        return ResponseEntity.ok(RestResponse.success(missionResponseDtoList));
    }
    @GetMapping("/{id}")        // could be diverse
    public ResponseEntity getOneMission(@PathVariable Long id){
        MissionResponseDto missionResponseDto = missionService.getOneMission(id);
        return ResponseEntity.ok(RestResponse.success(missionResponseDto));
    }
    @PostMapping("/{noteSectionId}")
    public ResponseEntity createOneMission(@PathVariable Long noteSectionId,@RequestBody MissionSaveRequestDto missionSaveRequestDto){
        MissionResponseDto missionResponseDto = missionService.createOneMission(noteSectionId, missionSaveRequestDto);
        return ResponseEntity.ok(RestResponse.success(missionResponseDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateOneMission(@PathVariable Long id, @RequestBody MissionUpdateRequestDto missionUpdateRequestDto){
        MissionResponseDto missionResponseDto =missionService.updateOneMission(id, missionUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.success(missionResponseDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneMissionById(@PathVariable Long id){
        missionService.deleteOneMissionById(id);
        ResponseEntity.ok(RestResponse.empty());
    }
}
