import React from "react";
import { Button, StyleSheet, Text, View } from "react-native";
import { FlatList } from "react-native";
import { TouchableOpacity } from "react-native";
import { useAddOneTaskMutation, useDeleteOneTaskMutation, useGetAllTasksQuery } from "../../api/ApiSlice";
import TaskCard from "../../components/taskComponents/TaskCard";
import TaskContentInput from "../../components/taskComponents/TaskContentInput";
import TaskDelete from "../../components/taskComponents/TaskDelete";

export default function TaskScreen(props){
    const missionId = props.route.params.missionId;


    const [addOneTask] = useAddOneTaskMutation();
    const [deleteOneTask] = useDeleteOneTaskMutation();
    
    const{
        data,
        isLoading,
        isSuccess,
        error,
        isError
    } = useGetAllTasksQuery(missionId);
    let content;
    if(isLoading){
        content = <Text>Loading..</Text>
    }
    else if(isSuccess){
        content = data.data
    }
    else if(isError){
        content = <Text>{error}</Text>
    }

    function handleSendTaskContent(taskContent){
        const task = {"taskName" : taskContent, "missionId": missionId}
        addOneTask(task)
    }
    function handleDeleteTask(taskId){
        deleteOneTask(taskId)
    }
    const renderTasks = ({item}) => <>  
                                        <View style={styles.renderStyle}>
                                            <View style={styles.card}>
                                                <TaskCard task={item}></TaskCard>
                                            </View>
                                            <View style={styles.deleteStyle}>
                                                <TouchableOpacity onPress={()=>handleDeleteTask(item.id)}>
                                                    <TaskDelete></TaskDelete>
                                                </TouchableOpacity>
                                            </View>
                                        </View>
                                    </>
    return(
        <View>
            <TaskContentInput onSend={handleSendTaskContent}></TaskContentInput>
            <FlatList keyExtractor={(item,index)=> index} data={content} renderItem={renderTasks}/>
        </View>
    );
}
const styles = StyleSheet.create({
    renderStyle:{
        backgroundColor:"blue",
        flexDirection:"row",
        // width : 300,
        height: 100,
        padding: 10,
        justifyContent: "space-between",
        marginHorizontal: 10,
        marginVertical: 20,
    },
    card:{
        backgroundColor:"green",
        justifyContent: "center",
        alignItems: "center",
        flex:2,
    },
    deleteStyle:{
        flex:1,
         justifyContent: "center",
         alignItems: "center",
         backgroundColor:"yellow",
    }
})