import React from "react";
import { FlatList, Text, TouchableOpacity, View } from "react-native";
import { Button } from "react-native-paper";
import { useGetAllNoteSectionsQuery, useDeleteOneNoteSectionMutation, useAddOneNoteSectionMutation} from "../../api/ApiSlice";
import NoteCard from "../../components/noteComponents/NoteCard";
import NoteDelete from "../../components/noteComponents/NoteDelete";

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
   
     const renderNoteCards = ({item}) =><> <TouchableOpacity onPress={()=> handleNavigation(item.id) }>
                                          <NoteCard note={item}></NoteCard>
                                          </TouchableOpacity>
                                          <TouchableOpacity onPress={()=> handleDeleteNote(item.id)}>
                                          <NoteDelete noteId={item.id}></NoteDelete>
                                          </TouchableOpacity>
                                          </>
   
    return(
        <View>
            <Text>
                <Button title="Click To Go To Mission" onPress={()=>handleNavigation(2)}>Click</Button>  
            </Text>
            <Text>
                <Button title="" onPress={()=>handleAddNote()}> Click To Add Note</Button>
            </Text>
            <FlatList keyExtractor={(item, index) => index} data={content} renderItem={renderNoteCards}/>
        </View>
    );
}