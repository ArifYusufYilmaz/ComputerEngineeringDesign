package com.ComputerEngineeringDesign.Thesis.note.converters;

import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskResponseDto;
import com.ComputerEngineeringDesign.Thesis.note.dtos.taskDtos.TaskSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.note.entities.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);
    List<TaskResponseDto> mapTaskListToTaskResponseDtoList(List<Task> tasks);
    @Mapping(source="mission.id", target="missionId")
    TaskResponseDto mapTaskToTaskResponseDto(Task task);
    @Mapping(source="missionId", target="mission.id")
    Task mapTaskSaveRequestDtoToTask(TaskSaveRequestDto taskSaveRequestDto);
}
