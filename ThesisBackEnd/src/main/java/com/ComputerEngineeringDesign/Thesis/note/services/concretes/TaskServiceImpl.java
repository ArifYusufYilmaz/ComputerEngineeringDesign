package com.ComputerEngineeringDesign.Thesis.note.services.concretes;

import com.ComputerEngineeringDesign.Thesis.note.converters.TaskMapper;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.Mission;
import com.ComputerEngineeringDesign.Thesis.note.entities.Task;
import com.ComputerEngineeringDesign.Thesis.note.repositories.MissionDao;
import com.ComputerEngineeringDesign.Thesis.note.repositories.TaskDao;
import com.ComputerEngineeringDesign.Thesis.note.services.abstracts.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;
    private final MissionDao missionDao;
    @Override
    public List<TaskResponseDto> getAllTasksByMissionId(Long missionId) {
        Optional<List<Task>> taskList = taskDao.findAllByMission_Id(missionId);
        if(!taskList.isPresent()){
            // throw
        }
        List<TaskResponseDto> taskResponseDtoList = TaskMapper.INSTANCE.mapTaskListToTaskResponseDtoList(taskList.get());
        return taskResponseDtoList;
    }

    @Override
    public TaskResponseDto getOneTask(Long id) {
        Optional<Task> task = taskDao.findById(id);
        if(!task.isPresent()){

        }
        TaskResponseDto taskResponseDto = TaskMapper.INSTANCE.mapTaskToTaskResponseDto(task.get());
        return taskResponseDto;
    }

    @Override
    public TaskResponseDto createOneTask(Long missionId,TaskSaveRequestDto taskSaveRequestDto) {
        Optional<Mission> mission = missionDao.findById(missionId);
        if(!mission.isPresent()){
            //throw
        }
        if(missionId != taskSaveRequestDto.getMissionId()){
            //throw
        }
        Task task =  TaskMapper.INSTANCE.mapTaskSaveRequestDtoToTask(taskSaveRequestDto);
        task = taskDao.save(task);
        TaskResponseDto taskResponseDto =  TaskMapper.INSTANCE.mapTaskToTaskResponseDto(task);
        return taskResponseDto;
    }

    @Override
    public TaskResponseDto updateOneTask(Long id, TaskUpdateRequestDto taskUpdateRequestDto) {
        return null;
    }

    @Override
    public void deleteOneTask(Long id) {
        Optional<Task> task = taskDao.findById(id);
        if(!task.isPresent()){

        }
        taskDao.deleteById(id);
    }
}
