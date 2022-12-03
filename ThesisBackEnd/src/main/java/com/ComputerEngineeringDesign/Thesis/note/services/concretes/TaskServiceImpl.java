package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.repositories.TaskDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Override
    public List<TaskResponseDto> getAllTasksByMissionId(Long missionId) {
        return null;
    }

    @Override
    public TaskResponseDto getOneTask(Long id) {
        return null;
    }

    @Override
    public TaskResponseDto createOneTask(TaskSaveRequestDto taskSaveRequestDto) {
        return null;
    }

    @Override
    public TaskResponseDto updateOneTask(Long id, TaskUpdateRequestDto taskUpdateRequestDto) {
        return null;
    }

    @Override
    public TaskResponseDto deleteOneTask(Long id) {
        return null;
    }
}
