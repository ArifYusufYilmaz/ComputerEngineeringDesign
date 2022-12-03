package com.ComputerEngineeringDesign.Thesis.note.controllers;

import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.noteSectionDtos.NoteSectionUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.NoteSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/noteSections")
@RequiredArgsConstructor
public class NoteSectionController {
    private final NoteSectionService noteSectionService;

    @GetMapping
    public List<NoteSectionResponseDto> getAllNoteSections(){
        return noteSectionService.getAllNoteSections();
    }
    @GetMapping("/{id}")
    public NoteSectionResponseDto getOneNoteSection(@PathVariable Long id){
        return noteSectionService.getOneNoteSection(id);
    }
    @PostMapping
    public NoteSectionResponseDto createOneNoteSection(@RequestBody NoteSectionSaveRequestDto noteSectionSaveRequestDto){
        return noteSectionService.createOneNoteSection(noteSectionSaveRequestDto);
    }
    @PutMapping("/{id}")
    public NoteSectionResponseDto updateOneNoteSection(@PathVariable Long id, @RequestBody NoteSectionUpdateRequestDto noteSectionUpdateRequestDto){
        return noteSectionService.updateOneNoteSection(id, noteSectionUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    public void deleteOneSectionById(@PathVariable Long id){
         noteSectionService.deleteOneSectionById(id);
    }

}















