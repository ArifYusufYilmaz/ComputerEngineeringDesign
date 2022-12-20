import React from "react";
import { Text, View } from "react-native";
export default function NoteCard(props){
    return(
        <View>
            <Text>
                hello note card {props.name}
            </Text>
        </View>
    );
}