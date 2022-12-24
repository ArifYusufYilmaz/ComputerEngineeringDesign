import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { useSelector } from 'react-redux';
import { useGetOneUserQuery } from '../../api/ApiSlice';
import { selectCurrentUser } from '../../globalStates/SessionSlice';
import Ionicons from "react-native-vector-icons/Ionicons";


export default function ProfileScreen(){

    const {userId} =  useSelector(selectCurrentUser);
    
    const {
        data,
        isLoading,
        isSuccess,
        isError,
        error
    } = useGetOneUserQuery(userId);

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
    
    return(
        <View style={styles.container}>
             <View style={styles.iconStyle}>
                <Ionicons name="person-outline" size={150}> </Ionicons>
            </View>
            <View style={styles.userStyle}>
                <View style={styles.userInfoStyle}>
                    <Text style={styles.textStyle}> Kullanıcı Adı</Text>
                    <Text style={styles.textStyle}>Kullanıcı SoyAdı </Text>
                    <Text style={styles.textStyle}> Kullanıcı email  </Text>
                </View>
                <View style={styles.userValueStyle}>
                    <Text style={styles.textStyle}> {content.userFirstName}</Text>
                    <Text style={styles.textStyle}> {content.userLastName} </Text>
                    <Text style={styles.textStyle}> {content.userEmail}   </Text>
            </View>
            </View>
           
        </View>
    );
}
const styles = StyleSheet.create({
container:{
        flex:1,
    },
 userStyle:{
   
    flexDirection:"row",
    justifyContent: "center",
    alignItems:"center",
 },
 iconStyle:{
    height:350,
    alignItems:"center",
    justifyContent:"center",
 },
 userValueStyle:{
    alignItems:"center",
 },
 userInfoStyle:{

 },
 textStyle:{
    margin:25,
    fontSize:15,
    borderRadius: 6,

 }
})