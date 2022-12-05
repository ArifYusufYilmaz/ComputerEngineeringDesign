import React, { useState } from "react";
import { ActivityIndicator, Button, FlatList, Text, View } from "react-native";
import axios from "axios";
export default function ApiExample() {
    
   const getUsers = ()=> {
    axios.
            get("http://localhost:8080/api/v1/users").then(response => console.log(response))
   }
    return(
        <View style={{flex:1, padding:24}}>
            <Text>hellloooo</Text>
            <Button title="Get Advice" 
                onPress={getUsers} color="green" />
        </View>
    );

};