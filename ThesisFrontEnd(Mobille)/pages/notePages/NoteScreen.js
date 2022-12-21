import React, { useState } from "react";
import { FlatList, Text, TouchableOpacity, View } from "react-native";
import { Button } from "react-native-paper";
import {Stack,FAB} from "@react-native-material/core";
import Icon from "@expo/vector-icons/MaterialCommunityIcons";

import { useGetAllNoteSectionsQuery, useDeleteOneNoteSectionMutation, useAddOneNoteSectionMutation} from "../../api/ApiSlice";
import NoteCard from "../../components/noteComponents/NoteCard";
import NoteDelete from "../../components/noteComponents/NoteDelete";
import NoteContentInputModal from "../../components/modals/NoteContentInputModal";

export default function NoteScreen(props){

    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error
    } = useGetAllNoteSectionsQuery()
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


    const userId = 2;
    
    function handleNavigation(id){
         props.navigation.navigate('Mission', {noteSectionId: id, userId: userId} )
    }
    function handleDeleteNote(id){
        deleteOneNoteSection(id)
    }
    function handleAddNote(){
        const noteSection = {"noteSectionName": "fourthNote"}
        addOneNoteSection(noteSection)
    }
    function handleInputToggle(){
        setInputModalVisible(!inputModalVisible)
    }
    function handleSendContent(content){
        // content backendin istediği şekle çevrilerek gönderilmeli!
        handleInputToggle()
        const noteSection = {"noteSectionName": content}
        
         addOneNoteSection(noteSection)
    }
     const renderNoteCards = ({item}) =><> <TouchableOpacity onPress={()=> handleNavigation(item.id) }>
                                          <NoteCard note={item}></NoteCard>
                                          </TouchableOpacity>
                                          <TouchableOpacity onPress={()=> handleDeleteNote(item.id)}>
                                          <NoteDelete noteId={item.id}></NoteDelete>
                                          </TouchableOpacity>
                                          </>
    
    const [inputModalVisible, setInputModalVisible] = useState(false);
    return(
        <View>
             <Button title="Click To Go To Mission" onPress={()=>handleNavigation(2)}>Click</Button>  
            <Button title="" onPress={()=>handleAddNote()}> Click To Add Note</Button>
            <Stack >
                <FAB icon={props => <Icon name="plus" {...props} />} onPress={handleInputToggle}/>
            </Stack>
            <NoteContentInputModal 
                    visible={inputModalVisible}
                    onClose={handleInputToggle}
                    onSend={handleSendContent}/>
            <FlatList keyExtractor={(item, index) => index} data={content} renderItem={renderNoteCards}/>
        </View>
    );
}