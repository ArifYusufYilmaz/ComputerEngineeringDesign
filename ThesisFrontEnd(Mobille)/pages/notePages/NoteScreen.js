import React, { useState } from "react";
import { FlatList, StyleSheet, Text, TouchableOpacity, View } from "react-native";
import { Button } from "react-native-paper";
import {Stack,FAB} from "@react-native-material/core";
import Icon from "@expo/vector-icons/MaterialCommunityIcons";
import Toast from 'react-native-toast-message';

import { useGetAllNoteSectionsQuery, useDeleteOneNoteSectionMutation, useAddOneNoteSectionMutation} from "../../api/ApiSlice";
import NoteCard from "../../components/noteComponents/NoteCard";
import NoteDelete from "../../components/noteComponents/NoteDelete";
import ContentInputModal from "../../components/modals/ContentInputModal";
import {  useSelector } from "react-redux";
import {  selectCurrentUser } from "../../globalStates/SessionSlice";

export default function NoteScreen(props){
    
    const currentUser  = useSelector(selectCurrentUser);
    const userId =  currentUser.userId;

    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error
    } = useGetAllNoteSectionsQuery(userId)
    
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

    const [addOneNoteSection] = useAddOneNoteSectionMutation()
    const [deleteOneNoteSection] = useDeleteOneNoteSectionMutation()


    function handleNavigation(id){

         props.navigation.navigate('Mission', {noteSectionId: id, userId: userId} )
    }
    function handleDeleteNote(id){
        deleteOneNoteSection(id)
    }
    function handleAddNote(text1Message){
         Toast.show({
             type: 'info',
             text1: text1Message + " EKLENDİ",
             position:"top",
             topOffset: 50
         })
    }   
    function handleInputToggle(){
        setInputModalVisible(!inputModalVisible)
    }
    function handleSendContent(content){
       
        handleInputToggle()
        const noteSection = {"noteSectionName": content, "userId" : userId}
         addOneNoteSection(noteSection)
         handleAddNote(content)
    }
     const renderNoteCards = ({item}) =><> 
                                          <View style={styles.renderStyle}>
                                             <View style={styles.card}>
                                                <TouchableOpacity onPress={()=> handleNavigation(item.id) }>
                                                   <NoteCard note={item}></NoteCard>
                                                </TouchableOpacity>
                                             </View>
                                             <View style={styles.deleteStyle}> 
                                                     <TouchableOpacity onPress={()=> handleDeleteNote(item.id)}>
                                                        <NoteDelete noteId={item.id}></NoteDelete>
                                                    </TouchableOpacity>
                                             </View>
                                          </View>
                                        </>
    
    const [inputModalVisible, setInputModalVisible] = useState(false);
    return(
        
        <View style={styles.container}>
          
             <View style={styles.itemStyle} >
                <FlatList keyExtractor={(item, index) => index} data={content} renderItem={renderNoteCards}/>
            </View>

                <Stack style={styles.fabStyle}>
                    <FAB icon={props => <Icon name="plus" {...props} />} onPress={handleInputToggle} />
                </Stack>
            
             
            <ContentInputModal 
                    visible={inputModalVisible}
                    onClose={handleInputToggle}
                    onSend={handleSendContent}/>
            
            
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
        // alignItems: "flex-end",
    },
    renderStyle:{
        // flex:1,
        backgroundColor:"blue",
        flexDirection:"row",
        width : 300,
        height: 100,
        padding: 10,
        justifyContent: "space-between",
        marginBottom: 20,
    },
    card:{
        // padding:10,
        // margin:15,
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