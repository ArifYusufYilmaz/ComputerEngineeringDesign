import React from "react";
import { Text, View } from "react-native";

export default function TaskScreen(props){
    return(
        <View>
            <Text>
                hello task screen missionId {props.route.params.missionId}
            </Text>
        </View>
    );
}