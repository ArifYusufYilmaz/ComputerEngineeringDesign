import React from "react";
import { Text, View } from "react-native";
import Ionicons from "react-native-vector-icons/Ionicons";

export default function NoteDelete(props){
    return (
        <View>
            <Text>
                <Ionicons name="trash-outline"/>
                {props.noteId}
            </Text>
        </View>
    );
}