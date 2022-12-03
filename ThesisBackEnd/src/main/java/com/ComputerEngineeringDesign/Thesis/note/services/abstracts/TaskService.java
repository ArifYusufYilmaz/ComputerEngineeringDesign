package com.ComputerEngineeringDesign.Thesis.note.services.abstracts;

import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskUpdateRequestDto;

import java.util.List;

public interface TaskService {
    List<TaskResponseDto> getAllTasksByMissionId(Long missionId);

    TaskResponseDto getOneTask(Long id);

    TaskResponseDto createOneTask(TaskSaveRequestDto taskSaveRequestDto);

    TaskResponseDto updateOneTask(Long id, TaskUpdateRequestDto taskUpdateRequestDto);

    TaskResponseDto deleteOneTask(Long id);
}
