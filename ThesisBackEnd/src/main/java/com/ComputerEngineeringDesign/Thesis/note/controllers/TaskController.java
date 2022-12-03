package com.ComputerEngineeringDesign.Thesis.note.controllers;

import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/{missionId}")
    public List<TaskResponseDto> getAllTasksByMissionId(@PathVariable Long missionId){
        return taskService.getAllTasksByMissionId(missionId);
    }
    @GetMapping("/{id}")    //could be diverse
    public TaskResponseDto getOneTask(@PathVariable Long id){
        return taskService.getOneTask(id);
    }
    @PostMapping()
    public TaskResponseDto createOneTask(@RequestBody TaskSaveRequestDto taskSaveRequestDto){
        return taskService.createOneTask(taskSaveRequestDto);
    }
    @PutMapping("/{id}")
    public TaskResponseDto updateOneTask(@PathVariable Long id, @RequestBody TaskUpdateRequestDto taskUpdateRequestDto){
        return taskService.updateOneTask(id, taskUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    public TaskResponseDto deleteOneTask(@PathVariable Long id){
        return taskService.deleteOneTask(id);
    }

}
