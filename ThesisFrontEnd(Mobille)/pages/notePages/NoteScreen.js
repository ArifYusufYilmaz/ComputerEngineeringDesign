import React, { useState } from "react";
import { FlatList, Text, TouchableOpacity, View } from "react-native";
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
             topOffset: 300
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
                                          <TouchableOpacity onPress={()=> handleNavigation(item.id) }>
                                          <View>
                                          <NoteCard note={item}></NoteCard>
                                          </View>
                                          </TouchableOpacity>
                                          <TouchableOpacity onPress={()=> handleDeleteNote(item.id)}>
                                          <View>
                                          <NoteDelete noteId={item.id}></NoteDelete>
                                          </View>
                                          </TouchableOpacity>
                                          </>
    
    const [inputModalVisible, setInputModalVisible] = useState(false);
    return(
        
        <View>
            <Stack >
                <FAB icon={props => <Icon name="plus" {...props} />} onPress={handleInputToggle}/>
            </Stack>
            <ContentInputModal 
                    visible={inputModalVisible}
                    onClose={handleInputToggle}
                    onSend={handleSendContent}/>
            <FlatList keyExtractor={(item, index) => index} data={content} renderItem={renderNoteCards}/>
            
        </View>
       
        
    );
}