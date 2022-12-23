
import React from "react";
import { Text, View } from "react-native";
 import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Ionicons from "react-native-vector-icons/Ionicons";

import NoteScreen from "../pages/notePages/NoteScreen";
import MissionScreen from "../pages/notePages/MissionScreen";
import TaskScreen from "../pages/notePages/TaskScreen";

import SignUpScreen from "../pages/authPages/SignUpScreen";
import LoginScreen from "../pages/authPages/LoginScreen";




const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();

function NoteStack(){
    return(
        <Stack.Navigator>
            <Stack.Screen name="Note" component={NoteScreen}/>
            <Stack.Screen name="Mission" component={MissionScreen}/>
            <Stack.Screen name="Task" component={TaskScreen}/>
        </Stack.Navigator>
    );
}

function BudgetStack(){
    return(
        <View>
            <Text>
                hello budget stack      
            </Text>
        </View>
    );
}

export default function Router(){
    return(
        
         <NavigationContainer>
          {!false ? (
                <Stack.Navigator initialRouteName="Login">
                    <Stack.Screen name="SignUp" component={SignUpScreen}/>
                    <Stack.Screen name="Login" component={LoginScreen}/> 
                </Stack.Navigator>
              ) : (
                
                <Tab.Navigator initialRouteName="Note" >
                    <Tab.Screen options={{tabBarIcon: ()=> (<Ionicons name="play-forward-outline"> </Ionicons>)}} name="NoteStack" component={NoteStack} /> 
                    <Tab.Screen name="BudgetStack" component={BudgetStack}/>
                </Tab.Navigator>
                
             )} 
         </NavigationContainer>
         
    );
}