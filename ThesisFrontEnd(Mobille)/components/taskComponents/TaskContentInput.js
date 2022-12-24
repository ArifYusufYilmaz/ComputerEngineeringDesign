import React, { useState } from 'react';
import { StyleSheet, TextInput, View } from 'react-native';
import { Stack, Button } from "@react-native-material/core";
import Icon from "@expo/vector-icons/MaterialCommunityIcons";

const TaskContentInput = ({onSend})=> {
    const [text, setText] = useState('')
    function handleSend(){
        if(!text){
            return;
        }
        onSend(text)
        setText('')
    }
    return(
        <View>
             <TextInput style={styles.inputStyle} 
                         value={text} 
                         placeholder={"Add A Task or Reminder!"}
                         onChangeText={setText} 
                         multiline 
                         placeholderTextColor={"red"}/>
             <Stack style= {styles.buttonStyle}>
                    <Button title="Send" 
                            trailing={props => <Icon name="clipboard-outline" size={30} {...props}/>}
                            onPress={handleSend}
                             />
             </Stack>
        </View>
    );
}
export default TaskContentInput;
const styles = StyleSheet.create({
    inputStyle:{
        margin: 20,
        height: 50,
        color: "red",
    },
    buttonStyle:{
        marginHorizontal:20,
    }


})