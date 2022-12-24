import React, { useState } from "react";
import { ActivityIndicator, StyleSheet, Text, TextInput, View } from "react-native";
import {Formik} from 'formik';
import Toast from 'react-native-toast-message';
import { Stack, Button } from "@react-native-material/core";
import {Dimensions} from 'react-native';



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

    const windowHeight = Dimensions.get('window').height;



    function handleNavigateToSignup(){
        props.navigation.navigate("SignUp")
    }
    function handleLoginSuccess(userId){
        try{
        Toast.show({
            type: 'success',
            text1: "Giriş Yapıldı!",
            position:"top",
            topOffset:windowHeight/5,
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
            topOffset: windowHeight/5
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
        <View style={styles.container}>
            <Formik initialValues={initialFormValues} onSubmit={handleFormSubmit}>
            {({values, handleChange, handleSubmit}) =>
             <>
                <TextInput style={styles.inputStyle} placeholder="userfirstname" value={values.firstname} onChangeText={handleChange('userfirstname')} />
                <TextInput style={styles.inputStyle} placeholder="userlastname" value={values.lastname} onChangeText={handleChange('userlastname')} />
                <TextInput style={styles.inputStyle} placeholder="email" value={values.email} onChangeText={handleChange('email')}></TextInput>
                <TextInput style={styles.inputStyle} placeholder="password" value={values.password} onChangeText={handleChange('password')} secureTextEntry={true}/>
                <Stack style={styles.buttonStyle}>
                     <Button title={loading ? "loading ": "Log In"} onPress={handleSubmit} />
                 </Stack>
               </>
            }
            </Formik>
            <Stack style={styles.buttonStyle}>
                 <Button title="SIGN UP" onPress={handleNavigateToSignup} backgroundColor={"red"} ></Button>
            </Stack>
           

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