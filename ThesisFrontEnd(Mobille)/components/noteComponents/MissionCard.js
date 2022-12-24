import React from "react";
import { Text, View } from "react-native";

export default function MissionCard(props){
    const missionId = props.mission.id
    const missionName = props.mission.missionName
    
    return(
        <View>
            <Text>
                {missionId} {missionName} 
            </Text>
        </View>
    );
}