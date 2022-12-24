import React from "react";
import { StyleSheet, Text, View } from "react-native";
import NoteDelete from "./NoteDelete";
import NoteUpdate from "./NoteUpdate";
export default function NoteCard(props){
    const{
        id, 
        noteSectionName
    } = props.note
    return(
        <View>
            <Text style={styles.textStyle}>
                 {noteSectionName}
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