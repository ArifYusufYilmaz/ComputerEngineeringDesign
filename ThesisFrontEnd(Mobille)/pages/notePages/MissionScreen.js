import React from "react";
import { Text, TouchableOpacity, View } from "react-native";

export default function MissionScreen(props){
    function handleNavigation(id){
        props.navigation.navigate("Task", {missionId: id})
    }
    return(
        <View>
            <Text>
                hello mission new
                 {props.route.params.id} {props.route.params.userId}

            </Text>
            <TouchableOpacity onPress={()=> handleNavigation(2)}>
                <Text>
                    move to Tasks
                </Text>
            </TouchableOpacity>
        </View>
    );
}