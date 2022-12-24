import React, { useState } from "react";
import { StyleSheet, Text, TextInput, View } from "react-native";
import { Button } from "react-native";
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
        <View>
            <Formik initialValues ={initialFormValues} onSubmit={handleFormSubmit}>
            {({values, handleChange, handleSubmit})=>
            <>
                <TextInput placeholder="userfirstname" value={values.firstname} onChangeText={handleChange('userfirstname')} />
                <TextInput placeholder="userlastname" value={values.lastname} onChangeText={handleChange('userlastname')} />
                <TextInput placeholder="email" value={values.email} onChangeText={handleChange('email')} />
                <TextInput placeholder="password" value={values.password} onChangeText={handleChange('password')} secureTextEntry={true}/>
                <Button title="SIGN UP" onPress={handleSubmit}/>
                <Button title="GO BACK" onPress={handleGoBackNavigate}/>
            </>
            }
            </Formik>
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        // flexDirection : "row"
    }
})