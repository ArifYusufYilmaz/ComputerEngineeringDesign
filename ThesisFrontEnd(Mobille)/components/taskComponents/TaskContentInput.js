import React, { useState } from 'react';
import { TextInput, View } from 'react-native';
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
             <TextInput value={text} placeholder={"Add A Task or Reminder!"} onChangeText={setText} multiline/>
             <Stack>
                    <Button title="Send" trailing={props => <Icon name="send" {...props}/>} onPress={handleSend} />
             </Stack>
        </View>
    );
}
export default TaskContentInput;