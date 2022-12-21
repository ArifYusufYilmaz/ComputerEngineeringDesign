import React from "react";
import { Text, View } from "react-native";

export default function MissionCard(props){


    return(
        <View>
            <Text>
                carddan yazıyorum {props.mission.id} {props.mission.missionName}
            </Text>
        </View>
    );
}