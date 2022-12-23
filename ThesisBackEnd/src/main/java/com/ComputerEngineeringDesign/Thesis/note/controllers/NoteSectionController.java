package com.ComputerEngineeringDesign.Thesis.note.controllers;

import com.ComputerEngineeringDesign.Thesis.generic.response.RestResponse;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.NoteSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/noteSections")
@RequiredArgsConstructor
public class NoteSectionController {
    private final NoteSectionService noteSectionService;
    
    @GetMapping("/user/{userId}")
    public ResponseEntity getAllNoteSectionsByUserId(@PathVariable Long userId){
        List<NoteSectionResponseDto> noteSectionResponseDtoList = noteSectionService.getAllNoteSectionsByUserId(userId);
        return ResponseEntity.ok(RestResponse.success(noteSectionResponseDtoList));
    }
    @GetMapping("/noteSection/{id}")
    public ResponseEntity getOneNoteSection(@PathVariable Long id){
        NoteSectionResponseDto noteSectionResponseDto = noteSectionService.getOneNoteSection(id);
        return ResponseEntity.ok(RestResponse.success(noteSectionResponseDto));
    }
    @PostMapping("/userId/{userId}")
    public ResponseEntity createOneNoteSection(@PathVariable Long userId,@RequestBody NoteSectionSaveRequestDto noteSectionSaveRequestDto){
        NoteSectionResponseDto noteSectionResponseDto = noteSectionService.createOneNoteSection(userId,noteSectionSaveRequestDto);
        return ResponseEntity.ok(RestResponse.success(noteSectionResponseDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateOneNoteSection(@PathVariable Long id, @RequestBody NoteSectionUpdateRequestDto noteSectionUpdateRequestDto){
        NoteSectionResponseDto noteSectionResponseDto = noteSectionService.updateOneNoteSection(id, noteSectionUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.success(noteSectionResponseDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneSectionById(@PathVariable Long id){
        noteSectionService.deleteOneSectionById(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}















