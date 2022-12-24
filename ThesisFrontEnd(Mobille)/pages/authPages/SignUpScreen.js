import React, { useState } from "react";
import { StyleSheet, Text, TextInput, View } from "react-native";
import { Stack, Button } from "@react-native-material/core";
import {Formik} from 'formik';
import Toast from 'react-native-toast-message';

import {  useSignUpUserMutation } from "../../api/ApiSlice";

const initialFormValues = {
    userfirstname: '',
    userlastname: '',
    email: '',
    password: '',
}

export default function SignUpScreen(props){
    const [loading, setLoading] = useState(false);
    const [signUpUser] = useSignUpUserMutation();


    function handleGoBackNavigate(){
        props.navigation.goBack();
    }
    function handleAddUserFulfilled(userFirstName){
        Toast.show({
            type: 'success',
            text1: "Kullanıcı Eklendi!  "+ userFirstName,
            position:"top",
        })
        handleGoBackNavigate();
    }
    function handleAddUserRejected(message){
        Toast.show({  
            type: 'error',
            text1: "HATALI İŞLEM!  " + message,
            position:"top",
            topOffset: 120,
         })
    }
    function handleFormSubmit(formValues){
        const userObject = {"userFirstName" : formValues.userfirstname,
                            "userLastName" : formValues.userlastname,
                           "userEmail": formValues.email,
                           "userPassword": formValues.password}

         setLoading(true)
       
         signUpUser(userObject)
                               .unwrap()
                               .then((payload) =>   handleAddUserFulfilled(payload.data.userFirstName))
                               .catch((error) => handleAddUserRejected(error.data.data.message));
           
         setLoading(false)
      
   }
    return(
        <View style ={styles.container}>
            <Formik initialValues ={initialFormValues} onSubmit={handleFormSubmit}>
            {({values, handleChange, handleSubmit})=>
            <>
                <TextInput style={styles.inputStyle} placeholder="userfirstname" value={values.firstname} onChangeText={handleChange('userfirstname')} />
                <TextInput style={styles.inputStyle} placeholder="userlastname" value={values.lastname} onChangeText={handleChange('userlastname')} />
                <TextInput style={styles.inputStyle} placeholder="email" value={values.email} onChangeText={handleChange('email')} />
                <TextInput style={styles.inputStyle} placeholder="password" value={values.password} onChangeText={handleChange('password')} secureTextEntry={true}/>
                
                <Stack style={styles.buttonStyle}>
                    <Button title="SIGN UP" onPress={handleSubmit}/>
                 </Stack>
                 <Stack style={styles.buttonStyle}>
                     <Button title="GO BACK" onPress={handleGoBackNavigate}/>
                 </Stack>
                 
            </>
            }
            </Formik>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flex:1,
        backgroundColor:"#B9FFF8",
        justifyContent:"center",
    },
    inputStyle:{
        padding:15,
        margin:10,
        borderRadius:20,
        backgroundColor:"#7FB77E",
        color: "white",
    },
    buttonStyle:{
        padding:10,
        margin:10,
    }

   
})