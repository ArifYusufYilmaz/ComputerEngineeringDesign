import React from "react";
import { Text, View } from "react-native";
import NoteDelete from "./NoteDelete";
import NoteUpdate from "./NoteUpdate";
export default function NoteCard(props){
    const{
        id, 
        noteSectionName
    } = props.note
    return(
        <View>
            <Text>
                 {id} {noteSectionName}
            </Text>
        
        </View>
    );
}