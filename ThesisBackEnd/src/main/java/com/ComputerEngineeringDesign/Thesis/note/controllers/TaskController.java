package com.ComputerEngineeringDesign.Thesis.note.controllers;

import com.ComputerEngineeringDesign.Thesis.generic.response.RestResponse;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @GetMapping("/all/{missionId}")
    public ResponseEntity getAllTasksByMissionId(@PathVariable Long missionId){
        List<TaskResponseDto>  taskResponseDtoList =taskService.getAllTasksByMissionId(missionId);
        return ResponseEntity.ok(RestResponse.success(taskResponseDtoList));
    }
    @GetMapping("/{id}")    //could be diverse
    public ResponseEntity getOneTask(@PathVariable Long id){
        TaskResponseDto taskResponseDto = taskService.getOneTask(id);
        return ResponseEntity.ok(RestResponse.success(taskResponseDto));
    }
    @PostMapping("/{missionId}")
    public ResponseEntity createOneTask(@PathVariable Long missionId ,@RequestBody TaskSaveRequestDto taskSaveRequestDto){
        TaskResponseDto taskResponseDto = taskService.createOneTask(missionId,taskSaveRequestDto);
        return ResponseEntity.ok(RestResponse.success(taskResponseDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateOneTask(@PathVariable Long id, @RequestBody TaskUpdateRequestDto taskUpdateRequestDto){
        TaskResponseDto taskResponseDto = taskService.updateOneTask(id, taskUpdateRequestDto);
        return ResponseEntity.ok(RestResponse.success(taskResponseDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneTask(@PathVariable Long id){
        taskService.deleteOneTask(id);
        return ResponseEntity.ok(RestResponse.empty());
    }

}
