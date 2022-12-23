import React, { useState } from "react";
import { TextInput, View } from "react-native";
import { Stack, Button } from "@react-native-material/core";
import Icon from "@expo/vector-icons/MaterialCommunityIcons";
import Modal from "react-native-modal";


const ContentInputModal = ({visible, onClose, onSend}) =>{
   
    const [text, setText] = useState(null);

    function handleSend(){
        if(!text){
            return;
        }
         onSend(text);
         setText(null);
    }
    return(
        <Modal isVisible={visible}
                swipeDirection = "down"
                onSwipeComplete={onClose}
                onBackdropPress={onClose}
                onBackButtonPress={onClose}>
            <View>
                <TextInput placeholder={"Write something"} onChangeText={setText} multiline/>
                <Stack>
                    <Button title="Send" trailing={props => <Icon name="send" {...props}/>} onPress={handleSend}/>
                </Stack>
            </View>
        </Modal>
    );
}
export default ContentInputModal;