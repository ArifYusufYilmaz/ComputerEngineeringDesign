import React, { useState } from "react";
import { Button, FlatList, Text, TouchableOpacity, View } from "react-native";
import {  useGetAllMissionsQuery, useAddOneMissionMutation, useDeleteOneMissionMutation } from "../../api/ApiSlice";
import ContentInputModal from "../../components/modals/ContentInputModal";
import MissionCard from "../../components/noteComponents/MissionCard";
import MissionDelete from "../../components/noteComponents/MissionDelete";

export default function MissionScreen(props){
    const [inputModalVisible, setInputModalVisible] = useState(false);

    const userId =  props.route.params.userId
    const noteSectionId = props.route.params.noteSectionId

    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error
    } = useGetAllMissionsQuery(noteSectionId)

    let content;
    if(isLoading){
        content = <Text>Loading...</Text>
    }
    else if(isSuccess){
        content = data.data
    }
    else if(isError){
        content = <Text>{error}</Text>
    }
    const [addOneMission] = useAddOneMissionMutation();
    const [deleteOneMission] = useDeleteOneMissionMutation();
    
    function handleSendMissionContent(missionContent){
        handleInputToggle()
        const mission = { "missionName": missionContent, "noteSectionId": noteSectionId}
        addOneMission(mission);
    }
    function handleDeleteOneMission(missionId){
        deleteOneMission(missionId)
    }
    function handleInputToggle(){
        setInputModalVisible(!inputModalVisible)
    }

    function handleNavigation(id){
        props.navigation.navigate("Task", {missionId: id})
    }
    const renderMissions = ({item}) => <>
                                                    <TouchableOpacity onPress={()=>handleNavigation(item.id)}>
                                                    <MissionCard mission={item}></MissionCard>
                                                    </TouchableOpacity>
                                                    <TouchableOpacity onPress={()=> handleDeleteOneMission(item.id)}>
                                                        <MissionDelete></MissionDelete>
                                                    </TouchableOpacity>
                                       </>
    return(
        <View>
            <FlatList keyExtractor={(item, index)=> index} data={content} renderItem={renderMissions}/> 
            
            <ContentInputModal 
                    visible={inputModalVisible}
                    onClose={handleInputToggle}
                    onSend={handleSendMissionContent}/>
            <Button onPress={handleInputToggle}>Click To Add Mission</Button>
        </View>
    );
}