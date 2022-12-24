
import React from "react";
import { Text, TouchableOpacity, View } from "react-native";
 import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Ionicons from "react-native-vector-icons/Ionicons";
import Toast from 'react-native-toast-message';

import NoteScreen from "../pages/notePages/NoteScreen";
import MissionScreen from "../pages/notePages/MissionScreen";
import TaskScreen from "../pages/notePages/TaskScreen";

import SignUpScreen from "../pages/authPages/SignUpScreen";
import LoginScreen from "../pages/authPages/LoginScreen";

import { useDispatch, useSelector } from "react-redux";
import { logoutUser, selectCurrentUser } from "../globalStates/SessionSlice";




const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();

function NoteStack(){
    
    const dispatch = useDispatch();
    
    function handleLogout(){
        dispatch(logoutUser());
       Toast.show({
            type: "success",
            text1: "Çıkış Yapıldı!",
            position:"top",
        })
    }

    return(
        <Stack.Navigator screenOptions={{headerRight :()=> <TouchableOpacity onPress={handleLogout}><Text>Log out</Text></TouchableOpacity>}}>
            <Stack.Screen name="Note" component={NoteScreen} />
            <Stack.Screen name="Mission" component={MissionScreen}/>
            <Stack.Screen name="Task" component={TaskScreen}/>
        </Stack.Navigator>
    );
}

function ProfileScreen(){
    return(
        <View>
            <Text>
                hello budget stack      
            </Text>
        </View>
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
                
                <Tab.Navigator initialRouteName="Note" >
                    <Tab.Screen options={{tabBarIcon: ()=> (<Ionicons name="play-forward-outline"> </Ionicons>)}} 
                                name="NoteStack"
                                component={NoteStack}/> 
                    <Tab.Screen name="Profile" component={ProfileScreen}/>
                </Tab.Navigator>
             )} 
         </NavigationContainer>
         
    );
}