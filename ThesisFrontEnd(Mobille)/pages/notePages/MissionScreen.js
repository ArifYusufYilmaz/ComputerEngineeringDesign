import React, { useState } from "react";
import { Button, FlatList, StyleSheet, Text, TouchableOpacity, View } from "react-native";
import {  useGetAllMissionsQuery, useAddOneMissionMutation, useDeleteOneMissionMutation } from "../../api/ApiSlice";
import ContentInputModal from "../../components/modals/ContentInputModal";
import MissionCard from "../../components/noteComponents/MissionCard";
import MissionDelete from "../../components/noteComponents/MissionDelete";
import {Stack,FAB} from "@react-native-material/core";
import Icon from "@expo/vector-icons/MaterialCommunityIcons";

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
                                                    <View style={styles.renderStyle}>
                                                        <View style = {styles.card}>
                                                            <TouchableOpacity onPress={()=>handleNavigation(item.id)}>
                                                                <MissionCard mission={item}></MissionCard>
                                                            </TouchableOpacity>
                                                        </View>
                                                        <View style = {styles.deleteStyle}>
                                                            <TouchableOpacity onPress={()=> handleDeleteOneMission(item.id)}>
                                                                 <MissionDelete></MissionDelete>
                                                            </TouchableOpacity>
                                                        </View>
                                                    </View>         
                                      </>
    return(
        <View style={styles.container}>
            <View style={styles.itemStyle}>
            <FlatList keyExtractor={(item, index)=> index} data={content} renderItem={renderMissions}/> 
            </View>
            <Stack style={styles.fabStyle}>
                    <FAB icon={props => <Icon name="plus" {...props} />} onPress={handleInputToggle} />
             </Stack>
            <ContentInputModal 
                    visible={inputModalVisible}
                    onClose={handleInputToggle}
                    onSend={handleSendMissionContent}/>
           
            
        </View>
    );
}

const styles = StyleSheet.create({
    container:{
        flex:1,
        flexDirection:'row',
    },
    itemStyle:{
        marginTop:20,
        marginLeft:20,
    },
    fabStyle:{
        margin:10,
        paddingTop:20,
    },
    renderStyle:{
        backgroundColor:"blue",
        flexDirection:"row",
        width : 300,
        height: 100,
        padding: 10,
        justifyContent: "space-between",
        marginBottom: 20,
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