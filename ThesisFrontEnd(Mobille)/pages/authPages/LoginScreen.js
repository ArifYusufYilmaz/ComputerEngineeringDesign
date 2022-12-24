import React, { useState } from "react";
import { ActivityIndicator, Button, StyleSheet, Text, TextInput, View } from "react-native";
import {Formik} from 'formik';
import Toast from 'react-native-toast-message';

import { useLoginUserMutation } from "../../api/ApiSlice";
import { useDispatch, useSelector } from "react-redux";
import { loginUser, selectCurrentUser } from "../../globalStates/SessionSlice";


const initialFormValues = {
    userfirstname: '',
    userlastname:'',
    email:'',
    password:'',
}

export default function LoginScreen(props){
    const currentUser  = useSelector(selectCurrentUser);
     const dispatch = useDispatch();

    const [loading, setLoading] = useState(false);

    const [loginUserApi] = useLoginUserMutation();

    function handleNavigateToSignup(){
        props.navigation.navigate("SignUp")
    }
    function handleLoginSuccess(userId){
        try{
        Toast.show({
            type: 'success',
            text1: "Giriş Yapıldı!",
            position:"top",
        })
        dispatch(loginUser(userId))
        } catch(error){
            console.log(error)
        }
    }
    function handleLoginError(message){
        Toast.show({  
            type: 'error',
            text1: "HATALI İŞLEM!  " + message,
            position:"top",
         })
    }
    function handleFormSubmit(formValues){
        setLoading(true)
        const userObject = {"userFirstName" : formValues.userfirstname,
                             "userLastName" : formValues.userlastname,
                            "userEmail": formValues.email,
                            "userPassword": formValues.password}
          try{
            loginUserApi(userObject)
            .unwrap()
            .then((payload) =>   handleLoginSuccess(payload.data.id))
            .catch((error) =>handleLoginError(error.data.data.message));
          }catch(error){
             
          }
           setLoading(false)
    }
    
    return(
        <View>
            <Formik initialValues={initialFormValues} onSubmit={handleFormSubmit}>
            {({values, handleChange, handleSubmit}) =>
             <>
                <TextInput placeholder="userfirstname" value={values.firstname} onChangeText={handleChange('userfirstname')} />
                <TextInput placeholder="userlastname" value={values.lastname} onChangeText={handleChange('userlastname')} />
                <TextInput placeholder="email" value={values.email} onChangeText={handleChange('email')}></TextInput>
                <TextInput placeholder="password" value={values.password} onChangeText={handleChange('password')} secureTextEntry={true}/>
                <Button title={loading ? "loading ": "Log In"} onPress={handleSubmit}/>
            </>
            }
            </Formik>
           
            <Button title="SIGN UP" onPress={handleNavigateToSignup}></Button>

        </View>
    );
}
const styles = StyleSheet.create({
    
   
})