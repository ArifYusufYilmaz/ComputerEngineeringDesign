import React from "react";
import { FlatList, Text, TouchableOpacity, View } from "react-native";
import { Button } from "react-native-paper";
import { useGetAllNoteSectionsQuery } from "../../api/NoteApiSlice";
import NoteCard from "../../components/noteComponents/NoteCard";

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
            //  content = [data.data]
            content = data
            console.log(content)
    }
    else if(isError){
        content = <Text>{error}</Text>
    }


    // const data = ["1","2","3","4"];
    const userId = 2;
    
    function handleNavigation(id){
         props.navigation.navigate('Mission', {id: id, userId: userId} )
    }
    
    const renderNoteCards = ({item}) => <TouchableOpacity onPress={()=> handleNavigation(item.id) }><NoteCard name={item.noteSectionName}></NoteCard></TouchableOpacity>
    
    return(
        <View>
            <Text>
                <Button title="Click To Go To Mission" onPress={()=>handleNavigation(2)}>Click</Button>  
            </Text>
            
            <FlatList keyExtractor={(item, index) => index} data={content} renderItem={renderNoteCards}/> 
        </View>
    );
}