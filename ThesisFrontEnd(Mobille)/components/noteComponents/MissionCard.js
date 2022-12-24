import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function MissionCard(props){
    const missionId = props.mission.id
    const missionName = props.mission.missionName
    
    return(
        <View>
            <Text style={styles.textStyle}>
                {missionName} 
            </Text>
        </View>
    );
}
const styles = StyleSheet.create({
    textStyle:{
        fontSize :20,
        color: "white",
     }
})