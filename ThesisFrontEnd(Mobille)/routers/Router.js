
import React from "react";
import { Text, View } from "react-native";
 import { NavigationContainer } from "@react-navigation/native";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";
import { createNativeStackNavigator } from "@react-navigation/native-stack";
import Ionicons from "react-native-vector-icons/Ionicons";

import NoteScreen from "../pages/notePages/NoteScreen";
import MissionScreen from "../pages/notePages/MissionScreen";
import TaskScreen from "../pages/notePages/TaskScreen";



function MovieScreen(){
    return(
        <View>
            <Text>
                hello movie screen
            </Text>
        </View>
    );
}
function MovieWatchedScreen(){
    return(
        <View>
            <Text>
                hello movie watched screen
            </Text>
        </View>
    );
}


const Stack = createNativeStackNavigator();

function NoteStack(){
    return(
        <Stack.Navigator>
            <Stack.Screen name="Note" component={NoteScreen}/>
            <Stack.Screen name="Mission" component={MissionScreen}/>
            <Stack.Screen name="Task" component={TaskScreen}/>
        </Stack.Navigator>
    );
}
function MovieStack(){
    return(
        <Stack.Navigator>
            <Stack.Screen  name="Movie" component={MovieScreen}/>
            <Stack.Screen name="MovieWatched" component={MovieWatchedScreen}/>
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

const Tab = createBottomTabNavigator();



export default function Router(){
    return(
         <NavigationContainer>
            <Tab.Navigator initialRouteName="Movie" >
                <Tab.Screen options={{tabBarIcon: ()=> (<Ionicons name="play-forward-outline"> </Ionicons>)}} name="NoteStack" component={NoteStack} /> 
                <Tab.Screen name="MovieStack" component={MovieStack} />
                <Tab.Screen name="BudgetStack" component={BudgetStack}/>
            </Tab.Navigator>
         </NavigationContainer>
    );
}