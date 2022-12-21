import React from "react";
import { FlatList, Text, TouchableOpacity, View } from "react-native";
import {  useGetAllMissionsQuery } from "../../api/ApiSlice";
import MissionCard from "../../components/noteComponents/MissionCard";

export default function MissionScreen(props){
    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error
    } = useGetAllMissionsQuery(props.route.params.noteSectionId)

    let content;
    if(isLoading){
        content = <Text>Loading...</Text>
    }
    else if(isSuccess){
        content = data.data
        console.log(data)
    }
    else if(isError){
        content = <Text>{error}</Text>
    }
    
    function handleNavigation(id){
        props.navigation.navigate("Task", {missionId: id})
    }
     const renderMissions = ({item}) => <TouchableOpacity onPress={()=>handleNavigation(item.id)}><MissionCard mission={item}></MissionCard></TouchableOpacity>
    return(
        <View>
            <Text>
                
                 {props.route.params.noteSectionId} {props.route.params.userId}

            </Text>
            <FlatList keyExtractor={(item, index)=> index} data={content} renderItem={renderMissions}/> 
            <TouchableOpacity onPress={()=> handleNavigation(2)}>
                <Text>
                    move to Tasks
                </Text>
            </TouchableOpacity>
        </View>
    );
}