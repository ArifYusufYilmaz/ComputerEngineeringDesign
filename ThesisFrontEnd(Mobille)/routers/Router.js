
import React from "react";
import { StyleSheet, Text, TouchableOpacity, View } from "react-native";
 import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Ionicons from "react-native-vector-icons/Ionicons";
import Toast from 'react-native-toast-message';
import {Dimensions} from 'react-native';

import NoteScreen from "../pages/notePages/NoteScreen";
import MissionScreen from "../pages/notePages/MissionScreen";
import TaskScreen from "../pages/notePages/TaskScreen";

import SignUpScreen from "../pages/authPages/SignUpScreen";
import LoginScreen from "../pages/authPages/LoginScreen";

import { useDispatch, useSelector } from "react-redux";
import { logoutUser, selectCurrentUser } from "../globalStates/SessionSlice";
import ProfileScreen from "../pages/notePages/ProfileScreen";




const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();

const windowHeight = Dimensions.get('window').height;

function NoteStack(){
    
    const dispatch = useDispatch();
    
    function handleLogout(){
        dispatch(logoutUser());
       Toast.show({
            type: "success",
            text1: "Çıkış Yapıldı!",
            position:"top",
            topOffset: windowHeight / 2,
        })
    }

    return(
        <Stack.Navigator initialRouteName="Note" screenOptions={{headerRight :()=> 
                                                            <TouchableOpacity onPress={handleLogout}>
                                                                        <Ionicons name="log-out-outline" size={50}> </Ionicons>
                                                            </TouchableOpacity>}}>

           
            <Stack.Screen name="Note" component={NoteScreen} />
            <Stack.Screen name="Mission" component={MissionScreen}/>
            <Stack.Screen name="Task" component={TaskScreen}/>
        </Stack.Navigator>
    );
}


export default function Router(){

    const { loginSituation } = useSelector(selectCurrentUser);

    return(
         <NavigationContainer>
          {!loginSituation ? (
                <Stack.Navigator initialRouteName="Login">
                    <Stack.Screen name="SignUp" component={SignUpScreen}/>
                    <Stack.Screen name="Login" component={LoginScreen}/> 
                </Stack.Navigator>
              ) : (
                
                <Tab.Navigator screenOptions={{tabBarStyle: {height:50}, tabBarShowLabel:false}}>
                    <Tab.Screen options={{tabBarIcon: ()=> (<Ionicons name="book-outline" size={40}> </Ionicons>)}}
                                name="NoteStack"
                                component={NoteStack}/> 
                    <Tab.Screen options={{tabBarIcon: ()=> (<Ionicons name="person-outline" size={40}> </Ionicons>)}}
                                name="Profile" component={ProfileScreen}/>
                </Tab.Navigator>
             )} 
         </NavigationContainer>
         
    );
}
const styles = StyleSheet.create({
    container:{
        backgroundColor:"blue",
    },
    tabStyles:{
        backgroundColor:"red",
        
    }
})